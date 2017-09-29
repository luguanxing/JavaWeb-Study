package anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserService {

	//自动注入,不需要set方法
	@Autowired
	private UserDao dao1;
	
	//手动注入,需要指定被注入对象,不需要set方法
	@Resource(name="userDao")
	private UserDao dao2;
	
	public void add() {
		System.out.println("UserService->add");
		dao1.add();
		dao2.add();
	}
	
}
