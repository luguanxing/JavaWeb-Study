<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<jsp:useBean id="userbean" class="model.User" scope="request"/> <!-- 取出controller设置的bean并显示 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%
		if (userbean.getUsername() == null)				//未登录
			response.sendRedirect("login.jsp");
		else											//已登录
	%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Show</title>
	</head>
	<body>
		<h1>你好,<jsp:getProperty name="userbean" property="username"/></h1>
	</body>
</html>
