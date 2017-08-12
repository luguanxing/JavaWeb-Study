<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="hw05.comments" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="comments" class="hw05.comments" scope="request" />
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>comments</title>
	</head>
	<body>
		<FORM action="addcomment.jsp" Method="post">
			<Input type=submit name="addcomment" value="添加留言">
		</FORM>
		<FORM action="deletecomment.jsp" Method="post">
			<Input type=submit name="deletecomment" value="删除留言">
		</FORM>
		<FORM action="" Method="post">
			  <P>查询评论关键字:
			  <Input type=text name="querykey">
			  <Input type=submit name="query" value="查询">
		</FORM>
		<%
	        String querykey=request.getParameter("querykey");
	        if (querykey == null || querykey == "") {
	        	%>
	        		<jsp:getProperty  name= "comments"  property="queryResultByAll"/>
	        	<%
	        } else {
	        		comments.setQuerykey(querykey);
	        	%>
	        		<P>关于<u><%=querykey%></u>的结果
	        		<jsp:getProperty  name= "comments"  property="queryResultByCondition"/>
	        	<%
	        }
		%>
	</body>
</html>
