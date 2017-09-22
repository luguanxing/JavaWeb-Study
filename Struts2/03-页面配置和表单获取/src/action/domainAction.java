package action;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class domainAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		
		//操作request域对象
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("requestParam", "requestParam");
		
		//操作session域对象
		HttpSession session = request.getSession();
		session.setAttribute("sessionParam", "sessionParam");
		
		//操作ServletContext域对象
		ServletContext context = ServletActionContext.getServletContext();
		context.setAttribute("contextParam", "contextParam");
		
		return Action.NONE;
	}
	
	public static void main(String[] args) {}
	
}
