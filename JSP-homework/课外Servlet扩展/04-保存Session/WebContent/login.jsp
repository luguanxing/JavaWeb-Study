<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Post</title>
	</head>
	<%
		String nickname = (String)session.getAttribute("nickname");
		if (nickname != null)
			response.sendRedirect("show");
	%>
	<body>
		<FORM action="show"  method=post   name=form>
	    	<BR>输入昵称:<Input type="text"  name="nickname"></BR> 
	       <Input type="submit" value="提交" name="submit">
	    </FORM> 
	</body>
</html>