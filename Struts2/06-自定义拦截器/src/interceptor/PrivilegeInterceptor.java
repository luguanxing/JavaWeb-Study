package interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		ActionContext context = ActionContext.getContext();
		
		if (context.getSession().get("user") != null) {
			//放行
			return invocation.invoke();
		} else {
			//未登录
			context.put("msg", "尚未登录");
			return Action.LOGIN;
		}
	}

}
