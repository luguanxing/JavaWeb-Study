package action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloMethod2 extends ActionSupport {
	
	public String add() throws Exception {
		System.out.println("add2");
		return NONE;
	}
	
	public String update() throws Exception {
		System.out.println("update2");
		return NONE;
	}
	
	
}
