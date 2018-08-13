package salesapp.service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import salesapp.mybatis.constant.UserConstant.CustomerAssociatedType;
import salesapp.mybatis.constant.UserConstant.CustomerStatus;
import salesapp.mybatis.constant.UserConstant.FollowType;
import salesapp.mybatis.constant.UserConstant.UserRole;
import salesapp.mybatis.entity.Customer;
import salesapp.mybatis.entity.CustomerEx;
import salesapp.mybatis.entity.Follow;
import salesapp.mybatis.entity.FollowEx;
import salesapp.mybatis.entity.User;
import salesapp.mybatis.mapper.CustomerMapperEx;
import salesapp.mybatis.mapper.FollowMapperEx;
import salesapp.mybatis.mapper.UserMapperEx;
import salesapp.util.UUID;

@Service
public class CustomerService {
	@Resource
	private CustomerMapperEx customerMapperEx;
	@Resource
	private UserMapperEx userMapperEx;
	@Resource
	private FollowMapperEx followMapperEx;

	@Transactional(transactionManager = "salesTransactionManager")
	public MktResp<Customer> addCustomer(String userId, String name, String mobile, String socialId, int gender,
			String email, String address) {
		Customer customer = customerMapperEx.selectByMobileAndSocialId(mobile, socialId);
		if (customer != null) {
			return MktResp.errorResp("already record");
		}
		User user = userMapperEx.selectByPrimaryKey(userId);
		if (!UserRole.role(user.getUserRole()).equals(UserRole.SELLER)) {
			return MktResp.errorResp("no permission");
		}
		customer = new Customer();
		customer.setAssociatedType(CustomerAssociatedType.RECV_SELF.flag());
		customer.setAssociatedUserId(userId);
		customer.setCustomerAddress(address);
		customer.setCustomerEmail(email);
		customer.setCustomerGender(gender);
		customer.setCustomerId(UUID.get20());
		customer.setCustomerMobile(mobile.trim());
		customer.setCustomerName(name.trim().toLowerCase());
		customer.setCustomerSocialid(socialId.trim());
		customer.setFirstRecvTime(new Date());
		customer.setFirstUserId(userId);
		customer.setStatus(CustomerStatus.SHORT_ASSOCIATED.flag());
		customerMapperEx.insertSelective(customer);
		return new MktResp<Customer>(customer);
	}

	public MktResp<List<CustomerEx>> myCustomer(String userId) {
		User user = userMapperEx.selectByPrimaryKey(userId);
		UserRole role = UserRole.role(user.getUserRole());
		Set<String> allids = allNextUserId(userId, role);
		return new MktResp<List<CustomerEx>>(customerMapperEx.selectMyCustomerOrderByFollowTime(allids));
	}

	private Set<String> allNextUserId(String userId, UserRole role) {
		Set<String> allids = new HashSet<String>(Arrays.asList(new String[] { userId }));
		List<String> ids = new LinkedList<String>(allids);
		for (int i = 0; i < role.level(); i++) {
			if (!ids.isEmpty()) {
				List<User> users = userMapperEx.selectRegistedByUplevel(ids);
				ids.clear();
				users.forEach(next -> {
					allids.add(next.getUserId());
					ids.add(next.getUserId());
				});
			}
		}
		return allids;
	}

	public MktResp<CustomerInfo> customerInfo(String userId, String customerId) {
		User user = userMapperEx.selectByPrimaryKey(userId);
		CustomerEx customer = customerMapperEx.selectExByPrimaryKey(customerId);
		List<FollowEx> fs = followMapperEx.selectByCustomerId(customerId);
		CustomerInfo info = new CustomerInfo();
		info.setCustomerEx(customer);
		info.setFollowEx(fs);
		return new MktResp<CustomerInfo>(info);
	}

	public static class CustomerInfo {
		private CustomerEx customer;
		private List<FollowEx> follow;

		public CustomerEx getCustomerEx() {
			return customer;
		}

		public void setCustomerEx(CustomerEx customer) {
			this.customer = customer;
		}

		public List<FollowEx> getFollowEx() {
			return follow;
		}

		public void setFollowEx(List<FollowEx> follow) {
			this.follow = follow;
		}
	}

	@Transactional(transactionManager = "salesTransactionManager")
	public MktResp<List<Customer>> searchCustomer(String userId, final String str) {
		if (str == null || str.length() < 4) {
			// avoid large scale result
			return new MktResp<List<Customer>>(new LinkedList<Customer>());
		}
		List<Customer> list = customerMapperEx.searchNameMobileSocialid(str.toLowerCase());
		User user = userMapperEx.selectByPrimaryKey(userId);
		UserRole role = UserRole.role(user.getUserRole());
		Set<String> allids = new HashSet<String>(Arrays.asList(new String[] { userId }));
		List<String> ids = new LinkedList<String>(allids);
		for (int i = 0; i < role.level(); i++) {
			if (!ids.isEmpty()) {
				List<User> users = userMapperEx.selectRegistedByUplevel(ids);
				ids.clear();
				users.forEach(next -> {
					allids.add(next.getUserId());
					ids.add(next.getUserId());
				});
			}
		}
		List<Customer> ret = new LinkedList<Customer>();
		list.forEach(customer -> {
			if (allids.contains(customer.getAssociatedUserId())) {
				// if the customer is associated , return it directly
				ret.add(customer);
			} else {
				// if the customer is not assoicated, the search str should be exactly matched
				if (str.equals(customer.getCustomerMobile()) || str.equals(customer.getCustomerName())
						|| str.equals(customer.getCustomerSocialid())) {
					ret.add(customer);
				}
			}
		});
		return new MktResp<List<Customer>>(ret);
	}

	@Transactional(transactionManager = "salesTransactionManager")
	public MktResp<Void> follow(String userId, String customerId, String content) {
		User user = userMapperEx.selectByPrimaryKey(userId);
		Customer customer = customerMapperEx.selectByPrimaryKey(customerId);
		if (user == null || customer == null) {
			return MktResp.errorResp("error system");
		}
		Follow f = new Follow();
		f.setCustomerId(customerId);
		f.setFollowContent(content.trim());
		f.setFollowId(UUID.get20());
		f.setFollowTime(new Date());
		f.setFollowType(FollowType.COMMON.flag());
		f.setFollowUserId(userId);
		followMapperEx.insert(f);
		customer.setLastFollowId(f.getFollowId());
		customer.setLastFollowTime(new Date());
		customerMapperEx.updateByPrimaryKeySelective(customer);
		return new MktResp<Void>();
	}

	public MktResp<List<Customer>> customerPool(String userId, String str) {
		User user = userMapperEx.selectByPrimaryKey(userId);
		UserRole role = UserRole.role(user.getUserRole());
		if (role.compare(UserRole.MANAGER) < 0) {
			return MktResp.errorResp("no permission");
		}
		if (str == null || str.trim().length() < 4) {
			str = null;
		} else {
			str = str.trim();
		}
		List<Customer> list = customerMapperEx.selectAssociatedCustomerByUser(Arrays.asList(new String[] { userId }),
				str);
		return new MktResp<List<Customer>>(list);
	}

	@Transactional(transactionManager = "salesTransactionManager")
	public MktResp<Void> allocate(String operId, List<String> customerIds, String userId) {
		User operUser = userMapperEx.selectByPrimaryKey(operId);
		User toUser = userMapperEx.selectByPrimaryKey(userId);
		if (!toUser.getUserUp().equals(operId)) {
			return MktResp.errorResp("no permission");
		}
		int associated = customerMapperEx.checkAssociated(customerIds, operId);
		if (associated != customerIds.size()) {
			return MktResp.errorResp("error system");
		}
		UserRole operRole = UserRole.role(operUser.getUserRole());
		int status;
		if (operRole.equals(UserRole.MANAGER)) {
			status = CustomerStatus.SHORT_ASSOCIATED.flag();
		} else {
			status = CustomerStatus.POOL.flag();
		}
		int count = customerMapperEx.allocateAssociated(customerIds, userId, status);
		return new MktResp<Void>();
	}

	@Transactional(transactionManager = "salesTransactionManager")
	public MktResp<Void> lock(String operId, String customerId) {
		User operUser = userMapperEx.selectByPrimaryKey(operId);
		UserRole role = UserRole.role(operUser.getUserRole());
		if (role.compare(UserRole.MANAGER) < 0) {
			return MktResp.errorResp("no permission");
		}
		Customer customer = customerMapperEx.selectByPrimaryKey(customerId);
		if (customer.getStatus() != CustomerStatus.SHORT_ASSOCIATED.flag()) {
			return MktResp.errorResp("error status");
		}
		Set<String> allNextIds = allNextUserId(operId, role);
		if (!allNextIds.contains(customerId)) {
			return MktResp.errorResp("no permission");
		}
		customer.setStatus(CustomerStatus.LONG_ASSOCIATED.flag());
		customerMapperEx.updateByPrimaryKeySelective(customer);
		return new MktResp<Void>();
	}

	@Transactional(transactionManager = "salesTransactionManager")
	public MktResp<Void> unlock(String operId, String customerId) {
		User operUser = userMapperEx.selectByPrimaryKey(operId);
		UserRole role = UserRole.role(operUser.getUserRole());
		if (role.compare(UserRole.MANAGER) < 0) {
			return MktResp.errorResp("no permission");
		}
		Customer customer = customerMapperEx.selectByPrimaryKey(customerId);
		if (customer.getStatus() != CustomerStatus.LONG_ASSOCIATED.flag()) {
			return MktResp.errorResp("error status");
		}
		Set<String> allNextIds = allNextUserId(operId, role);
		if (!allNextIds.contains(customerId)) {
			return MktResp.errorResp("no permission");
		}
		customer.setStatus(CustomerStatus.SHORT_ASSOCIATED.flag());
		customerMapperEx.updateByPrimaryKeySelective(customer);
		return new MktResp<Void>();
	}
}
