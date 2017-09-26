package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	public String execute() throws Exception {
		//不能拦截这个方法否则永远无法登录
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (username.equals("admin") && password.equals("admin")) {
			request.getSession().setAttribute("username", username);
			return "success";
		} else {
			request.setAttribute("msg", "帐号/密码错误(均为admin)");
			return "failed";
		}
		
	}
	
}
