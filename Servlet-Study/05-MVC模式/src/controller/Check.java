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
		if (username == null || username.trim().isEmpty()) {	//参数username为空,显示错误信息
			out.println("输入为空，请重新输入");
		} else {												//参数username不为空,设置bean并转发
			User user = new User();
			user.setUsername(username);
			reqest.setAttribute("userbean", user);				//参数保存至bean,并转发
			RequestDispatcher dispatcher = reqest.getRequestDispatcher("show.jsp");
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
