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
		<title>测试foreach</title>
	</head>
	<body>
		<c:forEach var="i" begin="1" end="5">
			i = ${i} <br/>
		</c:forEach>
	</body>
</html>
