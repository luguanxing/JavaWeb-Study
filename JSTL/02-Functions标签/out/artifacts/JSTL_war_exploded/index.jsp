<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/27
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
	<head>
		<title>测试JSTL的Functions标签库</title>
	</head>
	<body>
		<div>
			fn:toLowerCase("LuGuanXing") = ${fn:toLowerCase("LuGuanXing")}
		</div>
		
		<div>
			fn:toUpperCase("Luguanxing") = ${fn:toUpperCase("Luguanxing")}
		</div>
		
		<div>
			fn:escapeXml("<b>hahaha</b>") = ${fn:escapeXml("<b>hahaha</b>")}
		</div>
	</body>
</html>
