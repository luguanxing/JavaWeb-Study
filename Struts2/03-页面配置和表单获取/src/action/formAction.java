package action;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class formAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		
//		//方式1 -> 使用ActionContext
//		ActionContext context = ActionContext.getContext();
//		Map<String, Object> map = context.getParameters();
//		Set<String> keys = map.keySet();
//		for (String key : keys) {
//			Object[] objs = (Object[]) map.get(key);
//			System.out.println(Arrays.toString(objs));
//		}
		
		//方式1 -> 使用HttpServletRequest
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + "->" + password);
		
		return Action.NONE;
	}
	
	public static void main(String[] args) {}
	
}
