package action;

import com.opensymphony.xwork2.ActionSupport;

public class hiAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		return "welcome";
	}
	
	public static void main(String[] args) {}
	
}
