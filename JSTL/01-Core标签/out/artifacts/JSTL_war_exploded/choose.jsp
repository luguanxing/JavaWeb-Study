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
		<title>测试choose</title>
	</head>
	<body>
		<c:set var="salary" scope="session" value="${10000*2}"/>
		<p>你的工资为 : <c:out value="${salary}"/></p>
		<c:choose>
			<c:when test="${salary <= 0}">
				太惨了。
			</c:when>
			<c:when test="${salary < 5000}">
				不错的薪水，还能生活。
			</c:when>
			<c:when test="${salary < 30000}">
				这辈子不可能打工的。
			</c:when>
			<c:otherwise>
				什么都没有。
			</c:otherwise>
		</c:choose>
	</body>
</html>
