package annoAndxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class 测试类 {

	public static void main(String[] args) {
		
		//注解和xml混用方式创建对象
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		UserService service = (UserService) context.getBean("userService");
		service.add();
		
	}

}
