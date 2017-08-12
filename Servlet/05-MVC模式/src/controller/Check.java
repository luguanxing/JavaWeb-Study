package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

public class Check extends HttpServlet {
	public void init(ServletConfig config) throws ServletException { 
		super.init(config);
	}
	public void doPost(HttpServletRequest reqest,HttpServletResponse response) throws IOException, ServletException {  
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String username = reqest.getParameter("username");
		if (username == null || username.trim().isEmpty()) {	//����usernameΪ��,��ʾ������Ϣ
			out.println("����Ϊ�գ�����������");
		} else {												//����username��Ϊ��,����bean��ת��
			User user = new User();
			user.setUsername(username);
			reqest.setAttribute("userbean", user);				//����������bean,��ת��
			RequestDispatcher dispatcher = reqest.getRequestDispatcher("show.jsp");
			dispatcher.forward(reqest, response);
		}
	}
	public void doGet(HttpServletRequest reqest,HttpServletResponse response) throws IOException, ServletException {  
		doPost(reqest, response);
	}
	public static void main(String[] args) {
		System.out.println("����javaӦ�ó���ʽ�����Ա�����class");
	}
}
