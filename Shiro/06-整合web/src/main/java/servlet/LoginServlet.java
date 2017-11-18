package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("login->doGet");
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("login->doPost");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			subject.login(token);
			Session session = subject.getSession();
			System.out.println("sessionId" + session.getId());
			System.out.println("sessionHost" + session.getHost());
			System.out.println("sessionTimeOut" + session.getTimeout());
			session.setAttribute("sessionData", "哈哈");
			resp.sendRedirect("success.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", "用户名或密码错误");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}

}
