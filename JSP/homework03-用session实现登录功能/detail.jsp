<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>detail</title>
	</head>
	<body>
		<%
			String username = (String)session.getAttribute("user");
			if (username == null)
				response.sendRedirect("sign.jsp");
			else {
				if (username.equals("admin")) {
					out.println(username+"你好,您是管理员");
				} else if (username.equals("teacher")) {
					out.println(username+"你好,您是教师");
				} else {
					out.println(username+"你好,您是用户");
				}
			}
		%>
		<BR/>
		<FORM action="exit.jsp"  method=post  name=form>
	        <Input type="submit" value="退出" name="submit">
		</FORM>
	</body>
</html>
