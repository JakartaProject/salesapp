package salesapp.api;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONArray;
import salesapp.mybatis.mapper.UserMapper;
import salesapp.roommybatis.mapper.PRoomMapper;
import salesapp.service.CustomerService;
import salesapp.service.UserService;

@RestController
public class TestController {
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private PRoomMapper pRoomMapper;
	
	@Resource
	private UserService userService;
	
	@Resource
	private CustomerService customerService;
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test() {
//		String userId = "123";
//		System.out.println(JSONArray.fromObject(userService.queryNextLevelList(userId)));
//		System.out.println(JSONObject.fromObject(userService.queryNumInfo(userId)));
//		User u = userMapper.selectByPrimaryKey(userId);
//		System.out.println(JSONObject.fromObject(u));
//		PRoom room = pRoomMapper.selectByPrimaryKey("9EED9398-3711-423C-9FF0-000048DD45A8");
//		System.out.println("room " + JSONObject.fromObject(room));
//		return "hello world!";
		return JSONArray.fromObject(customerService.myCustomer("123")).toString();
	}
}
