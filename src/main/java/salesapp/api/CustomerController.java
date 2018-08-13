package salesapp.api;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import salesapp.mybatis.entity.Customer;
import salesapp.mybatis.entity.CustomerEx;
import salesapp.mybatis.entity.User;
import salesapp.service.CacheService;
import salesapp.service.CustomerService;
import salesapp.service.CustomerService.CustomerInfo;
import salesapp.service.MktResp;

@RestController
@RequestMapping("rest/customer")
public class CustomerController {
	@Resource
	private CustomerService customerService;
	@Resource
	private CacheService cacheService;

	@RequestMapping(path = "addCustomer", method = RequestMethod.GET)
	public MktResp<Customer> addCustomer(@RequestParam(ApiC.s) String session, @RequestParam("name") String name,
			@RequestParam("mobile") String mobile, @RequestParam("socialId") String socialId,
			@RequestParam("gender") int gender, @RequestParam("email") String email,
			@RequestParam("address") String address) {
		User user = (User) cacheService.get(session);
		if (user == null) {
			return MktResp.sessionOutOfDate();
		}
		return customerService.addCustomer(user.getUserId(), name, mobile, socialId, gender, email, address);
	}

	@RequestMapping(path = "myCustomer", method = RequestMethod.GET)
	public MktResp<List<CustomerEx>> myCustomer(@RequestParam(ApiC.s) String session) {
		User user = (User) cacheService.get(session);
		if (user == null) {
			return MktResp.sessionOutOfDate();
		}
		return customerService.myCustomer(user.getUserId());
	}

	@RequestMapping(path = "customerInfo", method = RequestMethod.GET)
	public MktResp<CustomerInfo> customerInfo(@RequestParam(ApiC.s) String session,
			@RequestParam("customerId") String customerId) {
		User user = (User) cacheService.get(session);
		if (user == null) {
			return MktResp.sessionOutOfDate();
		}
		return customerService.customerInfo(user.getUserId(), customerId);
	}

	@RequestMapping(path = "searchCustomer", method = RequestMethod.GET)
	public MktResp<List<Customer>> searchCustomer(@RequestParam(ApiC.s) String session,
			@RequestParam(value = "str", required = false) String str) {
		User user = (User) cacheService.get(session);
		if (user == null) {
			return MktResp.sessionOutOfDate();
		}
		return customerService.searchCustomer(user.getUserId(), str);
	}

	@RequestMapping(path = "follow", method = RequestMethod.GET)
	public MktResp<Void> follow(@RequestParam(ApiC.s) String session, @RequestParam("customerId") String customerId,
			@RequestParam("content") String content) {
		User user = (User) cacheService.get(session);
		if (user == null) {
			return MktResp.sessionOutOfDate();
		}
		return customerService.follow(user.getUserId(), customerId, content);
	}

	@RequestMapping(path = "customerPool", method = RequestMethod.GET)
	public MktResp<List<Customer>> customerPool(@RequestParam(ApiC.s) String session,
			@RequestParam(value = "str", required = false) String str) {
		User user = (User) cacheService.get(session);
		if (user == null) {
			return MktResp.sessionOutOfDate();
		}
		return customerService.customerPool(user.getUserId(), str);
	}

	@RequestMapping(path = "allocate", method = RequestMethod.GET)
	public MktResp<Void> allocate(@RequestParam(ApiC.s) String session, @RequestParam("customerIds") String customerIds,
			@RequestParam("userId") String userId) {
		User user = (User) cacheService.get(session);
		if (user == null) {
			return MktResp.sessionOutOfDate();
		}
		List<String> customers = Arrays.asList(customerIds.split(","));
		if (customers.isEmpty()) {
			return new MktResp<Void>();
		}
		return customerService.allocate(user.getUserId(), customers, userId);
	}

	@RequestMapping(path = "lock", method = RequestMethod.GET)
	public MktResp<Void> lock(@RequestParam(ApiC.s) String session, @RequestParam("customerId") String customerId) {
		User user = (User) cacheService.get(session);
		if (user == null) {
			return MktResp.sessionOutOfDate();
		}
		return customerService.lock(user.getUserId(), customerId);
	}

	@RequestMapping(path = "unlock", method = RequestMethod.GET)
	public MktResp<Void> unlock(@RequestParam(ApiC.s) String session, @RequestParam("customerId") String customerId) {
		User user = (User) cacheService.get(session);
		if (user == null) {
			return MktResp.sessionOutOfDate();
		}
		return customerService.unlock(user.getUserId(), customerId);
	}
}
