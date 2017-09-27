package ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
	
	@Test
	public void testUser() {
		
		//加载配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		
		//得到配置创建的对象
		User user = (User) context.getBean("user");
		
		System.out.println(user);
		user.add();
		
	}

}
