package action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction3 extends ActionSupport {
	
	@Override
	public String execute() throws Exception {
		System.out.println("HelloAction3");
		//使用Action类的静态final常量
		return this.NONE;
	}
	
}
