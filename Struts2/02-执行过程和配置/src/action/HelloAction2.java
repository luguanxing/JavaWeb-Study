package action;

import com.opensymphony.xwork2.Action;

public class HelloAction2 implements Action {

	@Override
	public String execute() throws Exception {
		System.out.println("HelloAction2");
		//ʹ��Action��ľ�̬final����
		return this.SUCCESS;
	}

}
