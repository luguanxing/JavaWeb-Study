package c3p0;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ������ {

	public static void main(String[] args) {
		
		//ע�ⷽʽ��������
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		UserService service = (UserService) context.getBean("userService");
		service.add();
		
	}

}
