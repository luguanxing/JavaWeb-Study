package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by Administrator on 2017/8/14.
 */
public class Filter_signin implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//初始化
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("username") == null) {			//未登录
			response.sendRedirect("signin.jsp");
		} else {
			filterChain.doFilter(servletRequest, servletResponse);	//已登录
		}
	}

	@Override
	public void destroy() {
		//过滤器销毁时释放资源
	}
}
