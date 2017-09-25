<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>valuestack查看值栈</title>
	</head>
	<body>
		
		<s:debug></s:debug>
		<h2>★方法3：对象变量方法(会不分配新空间)</h2>
		<p>自动遍历list = { </p>
			<c:forEach items="${list}" var="user">
				${user.username }
				${user.password }
				<br/>
			</c:forEach>
		<p>} </p>
	</body>
</html>