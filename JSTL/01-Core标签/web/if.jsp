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
		<title>测试if</title>
	</head>
	<body>
		<c:set var="salary" value="${8000*2}" scope="session"/>
		<c:if test="${salary > 8000}">
		<p>工资为: ${salary}<p>
		</c:if>
	</body>
</html>
