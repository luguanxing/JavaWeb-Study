package action;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {

	public String add() {
		System.out.println("add");
		return SUCCESS;
	}
	
	public String del() {
		System.out.println("del");
		return SUCCESS;
	}
	
}
