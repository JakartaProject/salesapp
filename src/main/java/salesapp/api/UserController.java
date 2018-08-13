package salesapp.api;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import salesapp.mybatis.entity.User;
import salesapp.mybatis.entity.UserEx;
import salesapp.service.CacheService;
import salesapp.service.MktResp;
import salesapp.service.UserService;
import salesapp.service.UserService.NumInfo;

@RestController
@RequestMapping("rest/user")
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
		cacheService.set(session, check.getData(), 24 * 3600);
		LoginInfo info = new LoginInfo();
		info.setSession(session);
		info.setUser(check.getData());
		return new MktResp<LoginInfo>(info);
	}

	@RequestMapping(path = "getUser", method = RequestMethod.GET)
	public MktResp<User> getUser(@RequestParam(ApiC.s) String session) {
		User user = (User) cacheService.get(session);
		if (user == null) {
			return MktResp.sessionOutOfDate();
		}
		return userService.getUser(user.getUserId());
	}

	@RequestMapping(path = "logout", method = RequestMethod.GET)
	public MktResp<Void> logout(@RequestParam(ApiC.s) String session) {
		cacheService.remove(session);
		return new MktResp<Void>();
	}

	@RequestMapping(path = "addUser", method = RequestMethod.GET)
	public MktResp<User> addUser(@RequestParam(ApiC.s) String session, @RequestParam("account") String account,
			@RequestParam("mysoftUserCode") String mysoftUserCode) {
		User user = (User) cacheService.get(session);
		if (user == null) {
			return MktResp.sessionOutOfDate();
		}
		return userService.addUser(user.getUserId(), account, mysoftUserCode);
	}

	@RequestMapping(path = "queryNextLevelList", method = RequestMethod.GET)
	public MktResp<List<UserEx>> queryNextLevelList(@RequestParam(ApiC.s) String session) {
		User user = (User) cacheService.get(session);
		if (user == null) {
			return MktResp.sessionOutOfDate();
		}
		return new MktResp<List<UserEx>>(userService.queryNextLevelList(user.getUserId()));
	}

	@RequestMapping(path = "queryNextLevelUser", method = RequestMethod.GET)
	public MktResp<User> queryNextLevelUser(@RequestParam(ApiC.s) String session,
			@RequestParam("userId") String userId) {
		User user = (User) cacheService.get(session);
		if (user == null) {
			return MktResp.sessionOutOfDate();
		}
		return userService.queryNextLevelUser(user.getUserId(), userId);
	}

	@RequestMapping(path = "updateNextLevelRemark", method = RequestMethod.GET)
	public MktResp<Void> updateNextLevelRemark(@RequestParam(ApiC.s) String session,
			@RequestParam("userId") String userId, @RequestParam("remark") String remark) {
		User user = (User) cacheService.get(session);
		if (user == null) {
			return MktResp.sessionOutOfDate();
		}
		return userService.updateNextLevelRemark(user.getUserId(), userId, remark);
	}

	@RequestMapping(path = "updateAccount", method = RequestMethod.GET)
	public MktResp<Void> updateAccount(@RequestParam(ApiC.s) String session, @RequestParam("newName") String newName,
			@RequestParam("newMobile") String newMobile, @RequestParam("position") String position) {
		User user = (User) cacheService.get(session);
		if (user == null) {
			return MktResp.sessionOutOfDate();
		}
		return userService.updateAccount(user.getUserId(), newName, newMobile, position);
	}

	@RequestMapping(path = "updatePassword", method = RequestMethod.GET)
	public MktResp<Void> updatePassword(@RequestParam(ApiC.s) String session, @RequestParam("oldpwd") String oldpwd,
			@RequestParam("newpwd") String newpwd) {
		User user = (User) cacheService.get(session);
		if (user == null) {
			return MktResp.sessionOutOfDate();
		}
		return userService.updatePassword(user.getUserId(), oldpwd, newpwd);
	}

	@RequestMapping(path = "removeAccount", method = RequestMethod.GET)
	public MktResp<Void> removeAccount(@RequestParam(ApiC.s) String session, @RequestParam("userId") String userId,
			@RequestParam("reason") String reason) {
		User user = (User) cacheService.get(session);
		if (user == null) {
			return MktResp.sessionOutOfDate();
		}
		return userService.removeAccount(user.getUserId(), userId, reason);
	}

	@RequestMapping(path = "transferResource", method = RequestMethod.GET)
	public MktResp<Void> transferResource(@RequestParam(ApiC.s) String session, @RequestParam("fromId") String fromId,
			@RequestParam("toId") String toId) {
		User user = (User) cacheService.get(session);
		if (user == null) {
			return MktResp.sessionOutOfDate();
		}
		return userService.transferResource(user.getUserId(), fromId, toId);
	}

	@RequestMapping(path = "queryNumInfo", method = RequestMethod.GET)
	public MktResp<NumInfo> queryNumInfo(@RequestParam(ApiC.s) String session) {
		User user = (User) cacheService.get(session);
		if (user == null) {
			return MktResp.sessionOutOfDate();
		}
		return new MktResp<NumInfo>(userService.queryNumInfo(user.getUserId()));
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
