import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/8/27.
 */

//检验验证码
public class CheckCaptcha extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String captcha = (String)session.getAttribute("captcha");
		String receive = request.getParameter("input");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		if (captcha == null || receive == null) {
			out.println("<span style=\"color:yellow\">验证码不存在</span>");
		} else {
			if (captcha.equals(receive)) {
				out.println("<span style=\"color:green\">正确</span>");
			} else {
				out.println("<span style=\"color:red\">验证码错误</span>");
			}
		}
	}
}
