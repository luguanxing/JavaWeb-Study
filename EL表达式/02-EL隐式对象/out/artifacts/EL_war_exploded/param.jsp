<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/18
  Time: 0:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>显示param参数</title>
	</head>
	<body>
		<form action="">
			<div>param:<input type="text" name="num" /></div>
			<div>paramValues[0]:<input type="text" name="nums" /></div>
			<div>paramValues[1]:<input type="text" name="nums" /></div>
			<input type="submit" value="提交" />
			<input type="reset" value="重置" />
		</form>
		<div>param:${param.num}</div>
		<div>paramValues[0]:${paramValues.nums[0]}</div>
		<div>paramValues[1]:${paramValues.nums[1]}</div>
	</body>
</html>
