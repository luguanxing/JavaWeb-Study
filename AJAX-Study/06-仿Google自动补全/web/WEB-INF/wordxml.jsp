<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/2
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%--与传统试图层不同，本jsp只返回xml--%>
<%@ page contentType="text/xml;charset=UTF-8" language="java" %>
<words>
	<%
		String prefix = request.getParameter("word");
		List<String> list = new LinkedList();
		list.add("absolute");
		list.add("anyone");
		list.add("anything");
		list.add("apple");
		list.add("break");
		for (String word : list) {
			if (word.startsWith(prefix)) {
				%><word><%=word%></word><%
			}
		}
	%>
</words>
