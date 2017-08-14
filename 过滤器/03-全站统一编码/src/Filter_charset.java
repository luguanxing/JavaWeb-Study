import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * Created by Administrator on 2017/8/12.
 */
public class Filter_charset implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//初始化
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		servletRequest.setCharacterEncoding("utf-8");
		servletResponse.setContentType("text/html;charset=UTF-8");
		Writer out = servletResponse.getWriter();
		out.write("过滤器->全站采了用utf-8编码 <br/>");
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
		//过滤器销毁时释放资源
	}
}
