package salesapp;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import salesapp.mybatis.entity.User;
import salesapp.mybatis.mapper.UserMapper;

@RestController
public class TestController {
	@Resource
	private UserMapper userMapper;
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test() {
		User u = userMapper.selectByPrimaryKey(123L);
		System.out.println(u);
		return "hello world!";
	}
}
