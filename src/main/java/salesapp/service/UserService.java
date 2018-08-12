package salesapp.service;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import salesapp.mybatis.constant.UserConstant;
import salesapp.mybatis.constant.UserConstant.CustomerAssociatedType;
import salesapp.mybatis.constant.UserConstant.CustomerStatus;
import salesapp.mybatis.constant.UserConstant.UserRole;
import salesapp.mybatis.constant.UserConstant.UserStatus;
import salesapp.mybatis.entity.Customer;
import salesapp.mybatis.entity.User;
import salesapp.mybatis.entity.UserEx;
import salesapp.mybatis.mapper.CustomerMapperEx;
import salesapp.mybatis.mapper.UserMapperEx;
import salesapp.util.UUID;

@Service
public class UserService {
	@Resource
	private UserMapperEx userMapperEx;
	@Resource
	private CustomerMapperEx customerMapperEx;

	@Transactional(transactionManager = "salesTransactionManager")
	public MktResp<User> addUser(String userId, String account, String mysoftUserCode) {
		User createUser = userMapperEx.selectByPrimaryKey(userId);
		if (createUser == null || createUser.getUserStatus() != UserConstant.UserStatus.REGISTED.flag()) {
			return MktResp.errorResp("no permission");
		}
		UserRole role = UserRole.role(createUser.getUserRole());
		UserRole nextLevel = role.nextLevel();
		if (nextLevel == null) {
			return MktResp.errorResp("no permission");
		}
		User tobeCreate = userMapperEx.selectRegistedByAccount(account);
		if (tobeCreate != null) {
			return MktResp.errorResp("this account is already used");
		}
		tobeCreate = userMapperEx.selectRegistedByMysoftUserCode(mysoftUserCode);
		if (tobeCreate != null) {
			return MktResp.errorResp("this UserCode is already used in Mysoft");
		}
		tobeCreate = new User();
		tobeCreate.setCt(new Date());
		tobeCreate.setMysoftUserCode(mysoftUserCode);
		tobeCreate.setUserAccount(account);
		tobeCreate.setUserId(UUID.get20());
		tobeCreate.setUserPwd(RandomStringUtils.random(6));
		tobeCreate.setUserInitPwd(tobeCreate.getUserPwd());
		tobeCreate.setUserRole(nextLevel.flag());
		tobeCreate.setUserStatus(UserStatus.REGISTED.flag());
		tobeCreate.setUserUp(createUser.getUserId());
		int count = userMapperEx.insertSelective(tobeCreate);
		if (count != 1) {
			return MktResp.errorResp("system error");
		}
		return new MktResp<User>(tobeCreate);
	}

	public MktResp<User> queryNextLevelUser(String queryId, String userId) {
		User user = userMapperEx.selectByPrimaryKey(userId);
		if (!user.getUserUp().equals(queryId)) {
			return MktResp.errorResp("no permission");
		}
		return new MktResp<User>(user);
	}

	public MktResp<User> checkAccount(String account, String password) {
		User user = userMapperEx.selectRegistedByAccount(account);
		if (user == null || !user.getUserPwd().equals(password)) {
			return MktResp.errorResp("account or password is error");
		}
		user.setUserPwd("");
		return new MktResp<User>(user);
	}

	public MktResp<Void> updateNextLevelRemark(String queryId, String userId, String remark) {
		User user = userMapperEx.selectByPrimaryKey(userId);
		if (!user.getUserUp().equals(queryId)) {
			return MktResp.errorResp("no permission");
		}
		user.setUserRemark(remark);
		userMapperEx.updateByPrimaryKey(user);
		return new MktResp<Void>();
	}
	
	public MktResp<Void> updateAccount(String userId, String newName, String newMobile, String position) {
		User user = userMapperEx.selectByPrimaryKey(userId);
		user.setUserName(newName);
		user.setUserMobile(newMobile);
		user.setUserPosition(position);
		userMapperEx.updateByPrimaryKey(user);
		return new MktResp<Void>();
	}
	
	public MktResp<Void> updatePassword(String userId, String oldpwd, String newpwd) {
		User user = userMapperEx.selectByPrimaryKey(userId);
		if (!oldpwd.equals(user.getUserPwd())) {
			return MktResp.errorResp("error password");
		}
		user.setUserPwd(newpwd);
		user.setUserInitPwd("");
		userMapperEx.updateByPrimaryKey(user);
		return new MktResp<Void>();
	}

	@Transactional(transactionManager = "salesTransactionManager")
	public MktResp<Void> removeAccount(String operId, String userId, String reason) {
		User user = userMapperEx.selectByPrimaryKey(userId);
		if (!user.getUserUp().equals(operId)) {
			return MktResp.errorResp("no permission");
		}
		UserRole role = UserRole.role(user.getUserRole());
		if (role.equals(UserRole.SELLER)) {
			// transfer all customer to pool
			String generalUserId = userMapperEx.selectByPrimaryKey(operId).getUserUp();
			List<Customer> customers = customerMapperEx
					.selectAssociatedCustomerByUser(Arrays.asList(new String[] { userId }), null);
			customers.forEach(c -> {
				c.setAssociatedType(CustomerAssociatedType.ALLOCATED.flag());
				c.setAssociatedUserId(generalUserId);
				c.setStatus(CustomerStatus.POOL.flag());
				customerMapperEx.updateByPrimaryKeySelective(c);
			});
		} else {
			// check next level
			List<User> nextLevel = userMapperEx.selectRegistedByUplevel(Arrays.asList(new String[] { userId }));
			if (!nextLevel.isEmpty()) {
				return MktResp.errorResp("transfer first");
			}
		}
		// remove account
		user.setUserRemark(reason + " || " + user.getUserRemark());
		user.setUserStatus(UserStatus.DELETED.flag());
		userMapperEx.updateByPrimaryKeySelective(user);
		return new MktResp<Void>();
	}

	public List<UserEx> queryNextLevelList(String userId) {
		List<UserEx> nextLevel = userMapperEx.selectRegistedExByUp(userId);
		nextLevel.forEach(ue -> ue.setUserPwd(""));
		return nextLevel;
	}

	@Transactional(transactionManager = "salesTransactionManager")
	public MktResp<Void> transferResource(String operId, String fromId, String toId) {
		if (fromId.equals(toId)) {
			return new MktResp<Void>();
		}
		User fromUser = userMapperEx.selectByPrimaryKey(fromId);
		User toUser = userMapperEx.selectByPrimaryKey(toId);
		if (!fromUser.getUserUp().equals(operId) || !toUser.getUserUp().equals(operId)) {
			return MktResp.errorResp("no permission");
		}
		if (UserRole.role(fromUser.getUserRole()).equals(UserRole.SELLER)) {
			// only manager and general manager can be transfered resource
			return MktResp.errorResp("no permission");
		}
		List<User> nextLevel = userMapperEx.selectRegistedByUplevel(Arrays.asList(new String[] { fromId }));
		nextLevel.forEach(nl -> {
			nl.setUserUp(toId);
			userMapperEx.updateByPrimaryKeySelective(nl);
		});
		return new MktResp<Void>();
	}

	@Transactional(transactionManager = "salesTransactionManager")
	public NumInfo queryNumInfo(String userId) {
		User queryUser = userMapperEx.selectByPrimaryKey(userId);
		UserRole role = UserRole.role(queryUser.getUserRole());
		List<String> ids = new LinkedList<String>(Arrays.asList(new String[] { userId }));
		List<User> users = new LinkedList<User>(Arrays.asList(new User[] { queryUser }));
		NumInfo numInfo = new NumInfo();
		if (role.compare(UserRole.ADMIN) >= 0) {
			users = userMapperEx.selectRegistedByUplevel(ids);
			ids.clear();
			users.forEach(u -> ids.add(u.getUserId()));
			numInfo.setGeneralManagerNum(users.size());
		}
		if (role.compare(UserRole.GENERAL_MANAGER) >= 0) {
			users = userMapperEx.selectRegistedByUplevel(ids);
			ids.clear();
			users.forEach(u -> ids.add(u.getUserId()));
			numInfo.setManagerNum(users.size());
		}
		if (role.compare(UserRole.MANAGER) >= 0) {
			users = userMapperEx.selectRegistedByUplevel(ids);
			ids.clear();
			users.forEach(u -> ids.add(u.getUserId()));
			numInfo.setSellerNum(users.size());
		}
		if (role.compare(UserRole.SELLER) >= 0) {
			List<Customer> customers = customerMapperEx.selectAssociatedCustomerByUser(ids, null);
			numInfo.setCustomerNum(customers.size());
		}
		return numInfo;
	}

	public static class NumInfo {
		private int generalManagerNum;
		private int managerNum;
		private int sellerNum;
		private int customerNum;

		public int getGeneralManagerNum() {
			return generalManagerNum;
		}

		public void setGeneralManagerNum(int generalManagerNum) {
			this.generalManagerNum = generalManagerNum;
		}

		public int getManagerNum() {
			return managerNum;
		}

		public void setManagerNum(int managerNum) {
			this.managerNum = managerNum;
		}

		public int getSellerNum() {
			return sellerNum;
		}

		public void setSellerNum(int sellerNum) {
			this.sellerNum = sellerNum;
		}

		public int getCustomerNum() {
			return customerNum;
		}

		public void setCustomerNum(int customerNum) {
			this.customerNum = customerNum;
		}
	}
}
