<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="hw05.comments" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>addcomment</title>
	</head>
	<body>
		<FORM action="addcommentcheck.jsp" Method="post">
			  <p>评论:<BR/>
			  <Input type=text name="comment" style="width:350px;height:100px">
			  <p>昵称:<BR/>
			  <Input type=text name="author"  style="width:150px;">
			  <BR/><BR/>
			<Input type=submit name="add" value="提交">
		</FORM>
	</body>
</html>
