<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="hw05.comments" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>deletecomment</title>
	</head>
	<body>
		<FORM action="deletecommentcheck.jsp" Method="post">
			  <p>删除第:
			  <Input type=text name="deletekey" style="width:50px;"> 条记录
			  <BR/><BR/>
			<Input type=submit name="delete" value="提交">
		</FORM>
	</body>
</html>
