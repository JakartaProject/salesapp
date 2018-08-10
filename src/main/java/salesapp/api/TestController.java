package salesapp.api;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;
import salesapp.mybatis.entity.User;
import salesapp.mybatis.mapper.UserMapper;
import salesapp.roommybatis.entity.PRoom;
import salesapp.roommybatis.mapper.PRoomMapper;

@RestController
public class TestController {
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private PRoomMapper pRoomMapper;
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test() {
		User u = userMapper.selectByPrimaryKey(123L);
		System.out.println(JSONObject.fromObject(u));
		PRoom room = pRoomMapper.selectByPrimaryKey("9EED9398-3711-423C-9FF0-000048DD45A8");
		System.out.println("room " + JSONObject.fromObject(room));
		return "hello world!";
	}
}
