package junit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mapper.UserMapper;
import pojo.User;

public class UserMapperTest {

	@Test
	public void testMapper() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper = (UserMapper) context.getBean(UserMapper.class);
		//扫描包时只能用class获取bean,因为没有指定id
		//UserMapper userMapper = (UserMapper) context.getBean("userMapper");
		User user = userMapper.findUserById(10);
		System.out.println(user);
	}
	
}
