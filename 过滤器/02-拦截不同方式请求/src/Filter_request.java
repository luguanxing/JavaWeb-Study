import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/8/12.
 */
public class Filter_request implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//初始化
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		PrintWriter out = servletResponse.getWriter();
		out.write("Filter_request->before");
		out.write("<br />");
		filterChain.doFilter(servletRequest, servletResponse);
		out.write("Filter_request->after");
		out.write("<br />");
	}

	@Override
	public void destroy() {
		//过滤器销毁时释放资源
	}
}
