package salesapp.service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import salesapp.mybatis.constant.UserConstant.CustomerAssociatedType;
import salesapp.mybatis.constant.UserConstant.CustomerStatus;
import salesapp.mybatis.constant.UserConstant.UserRole;
import salesapp.mybatis.entity.Customer;
import salesapp.mybatis.entity.Follow;
import salesapp.mybatis.entity.User;
import salesapp.mybatis.mapper.CustomerMapperEx;
import salesapp.mybatis.mapper.UserMapperEx;
import salesapp.util.UUID;

@Service
public class CustomerService {
	@Resource
	private CustomerMapperEx customerMapperEx;
	@Resource
	private UserMapperEx userMapperEx;

	public MktResp<Customer> addCustomer(String userId, String name, String mobile, String socialId, String gender,
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
		customer.setCustomerGender(gender.equals("male") ? 1 : 0);
		customer.setCustomerId(UUID.get20());
		customer.setCustomerMobile(mobile.trim());
		customer.setCustomerName(name.trim().toLowerCase());
		customer.setCustomerSocialid(socialId.trim());
		customer.setFirstRecvTime(new Date());
		customer.setFirstUserId(userId);
		customer.setLastCommentTime(new Date());
		customer.setStatus(CustomerStatus.SHORT_ASSOCIATED.flag());
		customerMapperEx.insertSelective(customer);
		return new MktResp<Customer>(customer);
	}
	
	public MktResp<List<Customer>> myCustomer(String userId) {
		User user = userMapperEx.selectByPrimaryKey(userId);
		UserRole role = UserRole.role(user.getUserRole());
		Set<String> allids = new HashSet<String>(Arrays.asList(new String[] { userId }));
		List<String> ids = new LinkedList<String>(allids);
		for (int i = 0; i < role.level(); i++) {
			List<User> users = userMapperEx.selectRegistedByUplevel(ids);
			ids.clear();
			users.forEach(next -> {
				allids.add(next.getUserId());
				ids.add(next.getUserId());
			});
		}
		return new MktResp<List<Customer>>(customerMapperEx.selectMyCustomerOrderByFollowTime(allids));
	}
	
	public MktResp<CustomerInfo> customerInfo(String userId, String customerId) {
		User user = userMapperEx.selectByPrimaryKey(userId);
		UserRole role = UserRole.role(user.getUserRole());
		Customer customer = customerMapperEx.selectByPrimaryKey(customerId);
		
		CustomerInfo info = new CustomerInfo();
		info.setCustomer(customer);
		return new MktResp<CustomerInfo>();
	}
	
	public static class CustomerInfo {
		private Customer customer;
		private List<Follow> follow;

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public List<Follow> getFollow() {
			return follow;
		}

		public void setFollow(List<Follow> follow) {
			this.follow = follow;
		}
	}

	public MktResp<List<Customer>> searchCustomer(String userId, final String str) {
		if (str.length() < 4) {
			// avoid large scale result
			return new MktResp<List<Customer>>(new LinkedList<Customer>());
		}
		List<Customer> list = customerMapperEx.searchNameMobileSocialid(str.toLowerCase());
		User user = userMapperEx.selectByPrimaryKey(userId);
		UserRole role = UserRole.role(user.getUserRole());
		Set<String> allids = new HashSet<String>(Arrays.asList(new String[] { userId }));
		List<String> ids = new LinkedList<String>(allids);
		for (int i = 0; i < role.level(); i++) {
			List<User> users = userMapperEx.selectRegistedByUplevel(ids);
			ids.clear();
			users.forEach(next -> {
				allids.add(next.getUserId());
				ids.add(next.getUserId());
			});
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
}
