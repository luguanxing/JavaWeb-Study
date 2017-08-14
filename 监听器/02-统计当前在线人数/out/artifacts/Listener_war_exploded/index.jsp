<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/15
  Time: 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>Title</title>
	</head>
	<body>
		<p>当前在线人数(session数)为：<%=application.getAttribute("count")%></p>
		<a href="exit.jsp">点击退出</a>
	</body>
</html>
