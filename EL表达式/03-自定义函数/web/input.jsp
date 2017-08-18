<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/18
  Time: 0:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="my" uri="/luguanxing" %>
<html>
	<head>
		<title>自定义EL表达式防HTML注入</title>
	</head>
	<body>
		<form action="" method="post">
			<textarea name="data"></textarea>
			<input type="submit" value="提交">
		</form>
		<p>您输入的内容:${my:filter(param.data)}</p>
	</body>
</html>
