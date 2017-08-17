<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/18
  Time: 0:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>Web域相关对象</title>
	</head>
	<body>
		<%
			pageContext.setAttribute("username", "luguanxing");
			request.setAttribute("username", "lgx");
			session.setAttribute("username", "LGX");
			application.setAttribute("username", "LuGuanXing");
		%>
		<p>表达式\${pageScope.username}的值为：${pageScope.username}</p>
		<p>表达式\${requestScope.username}的值为：${requestScope.username}</p>
		<p>表达式\${sessionScope.username}的值为：${sessionScope.username}</p>
		<p>表达式\${applicationScope.username}的值为：${applicationScope.username}</p>
	</body>
</html>
