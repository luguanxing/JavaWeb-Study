<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/27
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>测试set</title>
	</head>
	<body>
		<jsp:useBean id="user" class="bean.User" />
		<c:set var="param" value="session" scope="session" />
		<c:set var="param" value="request" scope="request" />
		<c:set target="${user}" property="name" value="lgx"/>
		<div>sessionScope.param = ${sessionScope.param}</div>
		<div>requestScope.param = ${requestScope.param}</div>
		<div>user.name = ${user.name}</div>
	</body>
</html>
