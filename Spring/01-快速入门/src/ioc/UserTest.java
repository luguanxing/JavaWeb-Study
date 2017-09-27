package ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
	
	@Test
	public void testUser() {
		
		//���������ļ�
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		
		//�õ����ô����Ķ���
		User user = (User) context.getBean("user");
		
		System.out.println(user);
		user.add();
		
	}

}
