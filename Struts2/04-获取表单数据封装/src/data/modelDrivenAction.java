package data;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.User;

public class modelDrivenAction extends ActionSupport implements ModelDriven<User> {
	
	//模型驱动封装
	private User user = new User(); 
	
	@Override
	public User getModel() {
		return user;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("模型驱动封装: " + user.getUsername() + " -> " + user.getPassword());
		return NONE;
	}

}
