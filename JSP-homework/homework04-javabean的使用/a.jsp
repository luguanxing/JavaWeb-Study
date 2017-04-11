<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>a</title>
	</head>
	<body>
		<jsp:useBean  id="user" class="hw04.user" scope="session" />
		<%
	  		request.setCharacterEncoding("utf-8");
			if (user.getUsername() != null || user.getPassword() != null) {
				response.sendRedirect("c.jsp");
				return;
			}
		%>
		<FORM action="b.jsp"  method=post  name=form>
	    	<P>请输入下列信息：
	    	<BR>输入您的帐号:<Input type="text"  name="username"></BR> 
	    	<BR>输入您的密码:<Input type="password"  name="password"></BR> 
	        <Input type="submit" value="提交" name="submit">
	    </FORM> 
	</body>
</html>
