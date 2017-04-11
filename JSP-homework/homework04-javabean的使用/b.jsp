<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="hw04.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>check</title>
	</head>
	<body>
		<jsp:useBean  id="user" class="hw04.user" scope="session" />
		<%
	  		request.setCharacterEncoding("utf-8");
			if (user.getUsername() != null || user.getPassword() != null) {
				response.sendRedirect("c.jsp");
				return;
			}
	        String username=request.getParameter("username");
	        String password=request.getParameter("password");
	        if (username == null || password == null) {				//不是从login.jsp打开detail.jsp则返回login.jsp
	        	response.sendRedirect("a.jsp");
	        } else if (username.isEmpty() || password.isEmpty()) {	//从login.jsp打开detail.jsp则验证帐号密码
				out.println("信息不完整");
			} else {
				System.out.println("username:"+username+"\npassword:"+password);
				user.setUsername(username);
				user.setPassword(password);
				response.sendRedirect("c.jsp");
			}
		%>
	</body>
</html>
