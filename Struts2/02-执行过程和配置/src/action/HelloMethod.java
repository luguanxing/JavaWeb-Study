package action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloMethod extends ActionSupport {
	
	public String add() throws Exception {
		System.out.println("add");
		return NONE;
	}
	
	public String update() throws Exception {
		System.out.println("update");
		return NONE;
	}
	
	
}
