package action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;

import entity.User;
import service.UserService;

public class UserAction extends ActionSupport {
	
	@Resource(name="userService")
	private UserService service;
	
	@Override
	public String execute() throws Exception {
		System.out.println("Action->execute");
		
		User user_add = new User();
		user_add.setUsername("ssh_test");
		user_add.setPassword("123");
		service.add(user_add);
		
		User user_get = service.get(1);
		System.out.println(user_get);
		
		service.find();
		
		return NONE;
	}

}
