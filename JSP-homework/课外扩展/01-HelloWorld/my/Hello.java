package my;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Hello extends HttpServlet {  
	public void init(ServletConfig config) throws ServletException { 
		super.init(config);
	}
	public void service(HttpServletRequest reqest,HttpServletResponse response) throws IOException {  
		response.setContentType("text/html;charset=UTF-8");	//设置响应的MIME类型
		PrintWriter out=response.getWriter();					//获得一个向客户发送数据的输出流
		out.println("<html><body>");
		out.println("<h1>你好！servlet！</h1>");
		out.println("</body></html>");
	}
	public static void main(String[] args) {
		System.out.println("先以java应用程序方式运行以便生成class");
	}
}
