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
		if (nickname == null || nickname.trim().isEmpty()) {	//����Ϊ��,��ʾ������Ϣ
			out.println("nicknameΪ�գ�����������");
		} else {												//������Ϊ��,�����session
			out.println("��ã�"+nickname);
			out.print("<a href=\"exit.jsp\">�˳�</a>");
			HttpSession session = reqest.getSession(true);
			session.setAttribute("nickname", nickname);
		}
		out.println("</h1></body></html>");
	}
	public void doGet(HttpServletRequest reqest,HttpServletResponse response) throws IOException {  
		HttpSession session = reqest.getSession(true);
		String nickname = (String)session.getAttribute("nickname");
		if (nickname == null) {									//δ��¼
			response.sendRedirect("login.jsp");
		} else {												//if�ѵ�¼
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<html><body><h1>");
			out.println("��ӭ������"+nickname);
			out.print("<a href=\"exit.jsp\">�˳�</a>");
			out.println("</h1></body></html>");
		}
	}
	public static void main(String[] args) {
		System.out.println("����javaӦ�ó���ʽ�����Ա�����class");
	}
}
