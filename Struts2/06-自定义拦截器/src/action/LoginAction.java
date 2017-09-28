package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import struts2.User;

public class LoginAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();
	
	@Override
	public User getModel() {
		return user;
	}
	
	@Override
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
			context.getSession().put("user", user);
			return SUCCESS;
		} else {
			context.put("msg", "帐号/密码错误");
			return INPUT;
		}
	}

}
