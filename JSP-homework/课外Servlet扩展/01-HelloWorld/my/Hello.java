package my;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Hello extends HttpServlet {  
	public void init(ServletConfig config) throws ServletException { 
		super.init(config);
	}
	public void service(HttpServletRequest reqest,HttpServletResponse response) throws IOException {  
		response.setContentType("text/html;charset=UTF-8");	//������Ӧ��MIME����
		PrintWriter out=response.getWriter();					//���һ����ͻ��������ݵ������
		out.println("<html><body>");
		out.println("<h1>��ã�servlet��</h1>");
		out.println("</body></html>");
	}
	public static void main(String[] args) {
		System.out.println("����javaӦ�ó���ʽ�����Ա�����class");
	}
}
