package data;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.User;

public class expressionAction extends ActionSupport {
	
	//���ʽ��װ
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("���ʽ��װ: " + user.getUsername() + " -> " + user.getPassword());
		return NONE;
	}

}
