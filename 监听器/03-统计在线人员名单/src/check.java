import bean.OnlineUser;
import bean.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.UUID;

/**
 * Created by Administrator on 2017/8/14.
 */
public class check extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user_ex = (User) session.getAttribute("user");
		if (user_ex == null) {
			req.setCharacterEncoding("utf-8");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			if (username != null && !username.trim().isEmpty()) {
				User user = new User();
				user.setId(UUID.randomUUID().toString());
				user.setUsername(username);
				user.setPassword(password);
				req.getSession(true).setAttribute("user", user);
				resp.sendRedirect("show");
			} else {
				resp.setContentType("text/html;charset=UTF-8");
				Writer out = resp.getWriter();
				out.write("格式错误<br />");
			}
		} else {
			resp.setContentType("text/html;charset=UTF-8");
			Writer out = resp.getWriter();
			out.write("已登录<br />");
		}
	}
}
