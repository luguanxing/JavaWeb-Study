package anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class 测试类 {

	public static void main(String[] args) {
		
		//注解方式创建对象
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		User user = (User) context.getBean("user");
		user.test();
		
		System.out.println();
		
		//注解方式注入对象
		UserService service = (UserService) context.getBean("userService");
		service.add();
		
	}

}
