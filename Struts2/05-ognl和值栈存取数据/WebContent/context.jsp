<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>OGNL显示域对象</title>
	</head>
	<body>
		
		<p>request_key = ${request_key }</p>
		<p>request_key = <s:property value="#request.request_key"/></p>
		
	</body>
</html>