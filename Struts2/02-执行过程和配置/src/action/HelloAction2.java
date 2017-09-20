package action;

import com.opensymphony.xwork2.Action;

public class HelloAction2 implements Action {

	@Override
	public String execute() throws Exception {
		System.out.println("HelloAction2");
		//使用Action类的静态final常量
		return this.SUCCESS;
	}

}
