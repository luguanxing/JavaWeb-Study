<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/15
  Time: 0:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="bean.OnlineUser" %>
<jsp:useBean id="user" class="bean.User" scope="session"/>
<html>
	<head>
		<title>Title</title>
	</head>
	<body>
		<p>你好,<%=user.getUsername()%></p>
		<a href="exit.jsp">点击退出</a>
		<p>当前用户列表:<br />
			<%
				Map users = OnlineUser.getInstance().getOnlineUsers();
				for (Object onlineusername : users.values()) {
					out.print(onlineusername + "<br />");
				}
			%>
		</p>
	</body>
</html>
