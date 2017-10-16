package junit;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mapper.UserMapper;
import pojo.User;
import pojo.UserExample;


public class UserMapperTest {

	@Test
	public void testCountWithConditions() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper = context.getBean(UserMapper.class);
		
		UserExample example = new UserExample();
		String username = "明";
		example.createCriteria().andSexEqualTo("1").andUsernameLike("%" + username + "%");
		
		int count = userMapper.countByExample(example);
		System.out.println(count);
	}
	
	@Test
	public void testSelect() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper = context.getBean(UserMapper.class);
		
		User user = userMapper.selectByPrimaryKey(10);
		System.out.println(user);
		
		UserExample example = new UserExample();
		example.createCriteria().andIdBetween(1, 30);
		List<User> users = userMapper.selectByExample(example);
		for (User u : users) {
			System.out.println(u.getId() + " -> " + u.getUsername());
		}
	}
	
	@Test
	public void testOrder() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper = context.getBean(UserMapper.class);
		
		User user = userMapper.selectByPrimaryKey(10);
		System.out.println(user);
		
		UserExample example = new UserExample();
		example.createCriteria().andIdBetween(1, 30);
		example.setOrderByClause("id DESC");
		List<User> users = userMapper.selectByExample(example);
		for (User u : users) {
			System.out.println(u.getId() + " -> " + u.getUsername());
		}
	}
	
}
