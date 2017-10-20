package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor1 implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println("拦截器1->方法前");
		//判断是否登录 没登录重定向到登录页面不放行 登录了则放行
		//注意不能拦截登录页面和登录方法
		String uri = request.getRequestURI();
		if (!uri.contains("/loginUI") && !uri.contains("/login")) {
			Object admin = request.getSession().getAttribute("admin");
			if (admin == null) {
				response.sendRedirect(request.getContextPath() + "/loginUI");
				return false;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("拦截器1->方法后");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("拦截器1->页面渲染后");
	}

}
