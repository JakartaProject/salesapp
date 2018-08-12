package salesapp.api;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import salesapp.mybatis.entity.User;
import salesapp.service.CacheService;
import salesapp.service.MktResp;
import salesapp.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private CacheService cacheService;

	@RequestMapping(path = "login", method = RequestMethod.GET)
	public MktResp<LoginInfo> login(@RequestParam("account") String account,
			@RequestParam("password") String password) {
		MktResp<User> check = userService.checkAccount(account, password);
		if (!check.success()) {
			return MktResp.errorResp(check.getMsg());
		}
		String session = newSession();
		cacheService.set(session, check.getData(), 24*3600);
		LoginInfo info = new LoginInfo();
		info.setSession(session);
		info.setUser(check.getData());
		return new MktResp<LoginInfo>(info);
	}

	@RequestMapping(path = "logout", method = RequestMethod.GET)
	public MktResp<Void> logout(@RequestParam("session") String session) {
		cacheService.remove(session);
		return new MktResp<Void>();
	}
	
	private String newSession() {
		return RandomStringUtils.randomAlphabetic(20);
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(RandomStringUtils.randomAscii(20));
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(RandomStringUtils.randomAlphabetic(20));
		}
	}

	public static class LoginInfo {
		private User user;
		private String session;
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public String getSession() {
			return session;
		}
		public void setSession(String session) {
			this.session = session;
		}
	}
}
