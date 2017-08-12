import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Created by Administrator on 2017/8/12.
 */
public class index extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.write("hello index!");
		out.write("<br />");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}