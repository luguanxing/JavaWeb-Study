package interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = (String) request.getSession().getAttribute("username");
		
		if (username != null) {
			//�ѵ�¼������
			return invocation.invoke();
		} else {
			//δ��¼,��ִ��action�ķ���,ֱ�ӷ���"failed"����ֵ
			return "checkfailed";
		}
	}

}
