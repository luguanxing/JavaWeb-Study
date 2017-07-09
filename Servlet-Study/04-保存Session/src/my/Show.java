package my;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

public class Show extends HttpServlet {  
	public void init(ServletConfig config) throws ServletException { 
		super.init(config);
	}
	public void doPost(HttpServletRequest reqest,HttpServletResponse response) throws IOException {  
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String nickname = reqest.getParameter("nickname");
		out.println("<html><body><h1>");
		if (nickname == null || nickname.trim().isEmpty()) {	//参数为空,显示错误信息
			out.println("nickname为空，请重新输入");
		} else {												//参数不为空,保存进session
			out.println("你好！"+nickname);
			out.print("<a href=\"exit.jsp\">退出</a>");
			HttpSession session = reqest.getSession(true);
			session.setAttribute("nickname", nickname);
		}
		out.println("</h1></body></html>");
	}
	public void doGet(HttpServletRequest reqest,HttpServletResponse response) throws IOException {  
		HttpSession session = reqest.getSession(true);
		String nickname = (String)session.getAttribute("nickname");
		if (nickname == null) {									//未登录
			response.sendRedirect("login.jsp");
		} else {												//if已登录
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<html><body><h1>");
			out.println("欢迎回来！"+nickname);
			out.print("<a href=\"exit.jsp\">退出</a>");
			out.println("</h1></body></html>");
		}
	}
	public static void main(String[] args) {
		System.out.println("先以java应用程序方式运行以便生成class");
	}
}
