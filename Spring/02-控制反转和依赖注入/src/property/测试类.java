package property;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ≤‚ ‘¿‡ {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		
		enityWithConstructor entity1 = (enityWithConstructor) context.getBean("entity1");
		entity1.test();
		
		System.out.println();
		
		enityWithoutConstructor entity2 =  (enityWithoutConstructor) context.getBean("entity2");
		entity2.test();
		
		System.out.println();
		
		UserService service = (UserService) context.getBean("_userService");
		service.add();
		
	}

}
