<%@ page import="com.sun.org.apache.xpath.internal.operations.String" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/14
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>Title</title>
	</head>
	<body>
		<%
			getServletConfig().getServletContext().setAttribute("username", "hahaha");
			getServletConfig().getServletContext().setAttribute("username", "hahaha2");
			getServletConfig().getServletContext().removeAttribute("username");
			session.setAttribute("username", "hahaha");
			session.setAttribute("username", "hahaha2");
			session.removeAttribute("username");
			request.setAttribute("username", "hahaha");
			request.setAttribute("username", "hahaha2");
			request.removeAttribute("username");
		%>
	</body>
</html>
