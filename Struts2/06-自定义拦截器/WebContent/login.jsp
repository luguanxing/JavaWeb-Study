<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>拦截器登录</title>
	</head>
	<body>
		<span style="color:red">${msg} </span>
		<form action="${pageContext.request.contextPath }/login.action" method="post">
			<input name="username" type="text"/><br/>
			<input name="password" type="text"/><br/>
			<input type="submit" value="登录"/>
		</form>
	</body>
</html>