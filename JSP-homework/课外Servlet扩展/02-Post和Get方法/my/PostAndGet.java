package my;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PostAndGet extends HttpServlet {  
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
			out.println("�յ�����:"+number);
		} catch (Exception e) {
			out.println("������ʽ����");
		}
		out.println("</h1></body></html>");
	}
	public void doGet(HttpServletRequest reqest,HttpServletResponse response) throws IOException {  
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<html><body><h1>");
		out.println("����post��ʽ��number�������б�ҳ��");
		out.println("</h1></body></html>");
	}
	public static void main(String[] args) {
		System.out.println("����javaӦ�ó���ʽ�����Ա�����class");
	}
}