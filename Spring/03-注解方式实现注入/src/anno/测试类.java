package anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ������ {

	public static void main(String[] args) {
		
		//ע�ⷽʽ��������
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		User user = (User) context.getBean("user");
		user.test();
		
		System.out.println();
		
		//ע�ⷽʽע�����
		UserService service = (UserService) context.getBean("userService");
		service.add();
		
	}

}
