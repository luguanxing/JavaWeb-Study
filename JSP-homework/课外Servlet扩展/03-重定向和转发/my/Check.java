package my;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Check extends HttpServlet {  
	public void init(ServletConfig config) throws ServletException { 
		super.init(config);
	}
	public void doPost(HttpServletRequest reqest,HttpServletResponse response) throws IOException, ServletException {  
		String str = reqest.getParameter("number");
		if (str == null || str.trim().length() == 0) {
			response.sendRedirect("post.jsp");	//重定向
		} else {
			RequestDispatcher dispatcher = reqest.getRequestDispatcher("show");	//转发
			dispatcher.forward(reqest, response);
		}
	}
	public void doGet(HttpServletRequest reqest,HttpServletResponse response) throws IOException, ServletException {  
		doPost(reqest, response);
	}
	public static void main(String[] args) {
		System.out.println("先以java应用程序方式运行以便生成class");
	}
}