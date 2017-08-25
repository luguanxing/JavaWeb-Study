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
		<title>上传文件</title>
	</head>
	<body>
		<form action="upload" method="post" enctype="multipart/form-data">
			<table style="border: 1px solid black; margin: 5px;">
				<tr>
					<td>上传者<input type="text" name="上传者" required/></td>
				</tr>
				<tr>
					<td>备注<input type="text" name="备注" required/></td>
				</tr>
				<tr>
					<td><input type="file" name="myfile" required/></td>
				</tr>
			</table>
			<input type="submit"  value="上传" />
		</form>
	</body>
</html>
