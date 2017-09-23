package data;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.User;

public class expressionAction extends ActionSupport {
	
	//表达式封装
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("表达式封装: " + user.getUsername() + " -> " + user.getPassword());
		return NONE;
	}

}
