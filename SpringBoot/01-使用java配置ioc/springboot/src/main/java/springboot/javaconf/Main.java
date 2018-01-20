package springboot.javaconf;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		// 通过Java配置来实例化Spring容器
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SpringConfig.class);

		// 从Spring容器中获取Bean对象(已在SpringConfig.class中扫描)
		UserService userService = context.getBean(UserService.class);

		// 调用对象中的方法
		List<User> list = userService.queryUserList();
		for (User user : list) {
			System.out.println(user.getUsername() + ", " + user.getPassword() + ", " + user.getPassword());
		}

		// 销毁该容器
		context.destroy();
	}

}
