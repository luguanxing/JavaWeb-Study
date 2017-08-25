<%@ page import="java.io.File" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/25
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>下载文件</title>
	</head>
	<body>
		<%
			String root = request.getSession().getServletContext().getRealPath("/");
			String rootPath = root + "uploadfiles\\";
			File dir = new File(rootPath);
			String[] files = dir.list();
			for (String file : files) {
				out.write("<div style=\"border:1px solid black; margin: 2px;\">");
				out.write("<a href=\"download?filename=" + file + "\">");
				out.write("<p>"+file+"</p>");
				out.write("</a>");
				out.write("</div>");
			}
		%>
	</body>
</html>
