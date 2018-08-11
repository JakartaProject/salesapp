package salesapp.service;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import salesapp.mybatis.constant.UserConstant;
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
		tobeCreate.setUserRole(nextLevel.flag());
		tobeCreate.setUserStatus(UserStatus.REGISTED.flag());
		tobeCreate.setUserUp(createUser.getUserId());
		int count = userMapperEx.insertSelective(tobeCreate);
		if (count != 1) {
			return MktResp.errorResp("system error");
		}
		return new MktResp<User>(tobeCreate);
	}
	
	public List<UserEx> queryNextLevel(String userId) {
		List<UserEx> nextLevel = userMapperEx.selectRegistedExByUp(userId);
		return nextLevel;
	}
	
	public NumInfo queryNumInfo(String userId) {
		User queryUser = userMapperEx.selectByPrimaryKey(userId);
		UserRole role = UserRole.role(queryUser.getUserRole());
		List<String> ids = new LinkedList<String>(Arrays.asList(new String[] {userId}));
		List<User> users = new LinkedList<User>(Arrays.asList(new User[] {queryUser}));
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
			List<Customer> customers = customerMapperEx.selectCustomerByUser(ids);
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
