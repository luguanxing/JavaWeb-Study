<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="hw05.comments" %> 
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="comments" class="hw05.comments" scope="request" />
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>addcommentcheck</title>
	</head>
	<body>
		<%
	        String comment=request.getParameter("comment");
	        String author=request.getParameter("author");
	        if (comment == null || author == null) {
	        	response.sendRedirect("comments.jsp");
	        } else {
	        	if (comment.isEmpty() || comment.length() > 100 || author.isEmpty() || author.length() > 15) {
	        		out.println("fuck,格式错误");
	        	} else {
	        		comments.setAuthor(author);
	        		comments.setComment(comment);
	        		comments.setDate(new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
	        		comments.getAddmessage();
	        		response.sendRedirect("comments.jsp");
	        	}
	        }
		%>
	</body>
</html>
