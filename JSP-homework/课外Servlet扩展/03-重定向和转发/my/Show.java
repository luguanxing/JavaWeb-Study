package my;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Show extends HttpServlet {  
	public void init(ServletConfig config) throws ServletException { 
		super.init(config);
	}
	public void doPost(HttpServletRequest reqest,HttpServletResponse response) throws IOException {  
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<html><body><h1>");
		String str = reqest.getParameter("number");
		double number = 0;
		try {
			number = Double.parseDouble(str);
			out.println("收到参数:"+number);
		} catch (Exception e) {
			out.println("参数格式有误");
		}
		out.println("</h1></body></html>");
	}
	public void doGet(HttpServletRequest reqest,HttpServletResponse response) throws IOException, ServletException {  
		RequestDispatcher dispatcher = reqest.getRequestDispatcher("check");	//转发
		dispatcher.forward(reqest, response);
	}
	public static void main(String[] args) {
		System.out.println("先以java应用程序方式运行以便生成class");
	}
}