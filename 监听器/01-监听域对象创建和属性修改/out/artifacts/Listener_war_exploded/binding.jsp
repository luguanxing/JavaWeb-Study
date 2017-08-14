<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/14
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="bean.Bean" %>
<html>
	<head>
		<title>Title</title>
	</head>
	<body>
		<%
			session.setAttribute("bean", new Bean());
		%>
	</body>
</html>
