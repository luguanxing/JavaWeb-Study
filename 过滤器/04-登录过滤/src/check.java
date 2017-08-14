import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by Administrator on 2017/8/14.
 */
public class check extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Writer out = resp.getWriter();
		out.write("请用post方式打开");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		if (username == null) {
			Writer out = resp.getWriter();
			out.write("没有username参数");
		} else {
			HttpSession session = req.getSession(true);
			session.setAttribute("username", username);
			resp.sendRedirect("home");
		}
	}
}
