<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="hw05.comments" %> 
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="comments" class="hw05.comments" scope="request" />
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>deletecommentcheck</title>
	</head>
	<body>
		<%
	        String deletekey=request.getParameter("deletekey");
	        if (deletekey == null) {
	        	response.sendRedirect("comments.jsp");
	        } else {
	        	comments.setDeletekey(deletekey);
	        	if (comments.getDeletemessage().toString().equals("")) {
	        		response.sendRedirect("comments.jsp");
	        	} else {
	        		out.println("fuck,删除失败");
	        	}
	        }
		%>
	</body>
</html>
