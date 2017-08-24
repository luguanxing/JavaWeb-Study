<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/24
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>上传图片</title>
	</head>
	<body>
		<form action="upload" method="post" enctype="multipart/form-data">
			<input type="file" name="fileName" />
			<input type="submit"  value="上传" />
		</form>
	</body>
</html>
