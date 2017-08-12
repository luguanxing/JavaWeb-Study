<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="hw04.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>c</title>
	</head>
	<body>
		<jsp:useBean  id="user" class="hw04.user" scope="session" />
		<%
			String username = user.getUsername();
			String password = user.getPassword();
			if (username == null || password == null)
				response.sendRedirect("a.jsp");
		%>
		<TABLE border=1>
		  <TR>
		    <TH>帐号</TH> <TH>密码</TH>
		  </TR>
		  <TR>
		    <TD><jsp:getProperty name= "user" property="username"/></TD> 
		    <TD><jsp:getProperty name= "user" property="password"/></TD> 
		  </TR>
		</TABLE>
		<FORM action="exit.jsp"  method=post  name=form>
	        <Input type="submit" value="退出" name="submit">
		</FORM>
	</body>
</html>
