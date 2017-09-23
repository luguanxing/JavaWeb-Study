package data;

import com.opensymphony.xwork2.ActionSupport;

public class propertyAction extends ActionSupport {
	
	//属性封装
	String username;
	String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("属性封装: " + username + " -> " + password);
		return NONE;
	}

}
