package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	public String execute() throws Exception {
		//���������������������Զ�޷���¼
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (username.equals("admin") && password.equals("admin")) {
			request.getSession().setAttribute("username", username);
			return "success";
		} else {
			request.setAttribute("msg", "�ʺ�/�������(��Ϊadmin)");
			return "failed";
		}
		
	}
	
}
