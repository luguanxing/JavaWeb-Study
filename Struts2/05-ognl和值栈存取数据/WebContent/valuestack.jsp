<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>valuestack查看值栈</title>
	</head>
	<body>
		
		<s:debug></s:debug>
		<h2>方法1：使用set存放到root(会分配新空间)</h2>
		<p>param_set = <s:property value="param_set"/></p>
		
		<hr>
		<h2>方法2：使用push存放到context(会分配新空间)</h2>
		<p>查找push的值 = <s:property value="[0].top"/></p>
		
		<hr>
		<h2>★方法3：对象变量方法(会不分配新空间)</h2>
		<p>对象user.username = <s:property value="user.username"/></p>
		<p>对象user.username = <s:property value="user.password"/></p>
		<p>自动遍历list = { </p>
		<s:iterator value="list">
			<s:property value="username"/>
			<s:property value="password"/><br/>
		</s:iterator>
		<p>} </p>
		<!-- 自动取值后对象自动放入context中,需要加上# -->
		<p>自动遍历list = { </p>
		<s:iterator value="list" var="list_user">
			<s:property value="#list_user.username"/>
			<s:property value="#list_user.password"/><br/>
		</s:iterator>
		<p>} </p>
	</body>
</html>