<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/18
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>EL隐式对象pageContext</title>
	</head>
	<body>
		<p>请求URI为：${pageContext.request.requestURI}</p>
		<p>Context-Type响应头：${pageContext.response.contentType}</p>
		<p>服务器信息：${pageContext.servletContext.serverInfo}</p>
		<p>Servlet注册名：${pageContext.servletConfig.servletName}</p>
	</body>
</html>
