<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title></title>
	</head>
	<body>
	    <%  
	  		request.setCharacterEncoding("utf-8");
			String name=request.getParameter("name");
	        String username=request.getParameter("username");
	        String password=request.getParameter("password");
	        String sex=request.getParameter("S");
	        String ideology=request.getParameter("I");
	        if (name != "") {
		        if (sex.equals("male"))
		        	out.println("<b>"+name+"</b>"+"先生,您好");
		        else
		        	out.println("<b>"+name+"</b>"+"女士,您好");
	        }
	        out.println("<br>");
	        
	        if (username != "")
	        	out.println("您的用户名是:"+"<b>"+username+"</b>");
	        else
	        	out.println("用户名不合法");
	        out.println("<br>");
	        
	        if (password.length() >= 6)
	        	out.println("您的密码是:"+"<b>"+password+"</b>");
	        else
	        	out.println("密码不合法");
	        out.println("<br>");

        	if (ideology.equals("com"))
        		out.println("您是一名<b>共产主义者</b>");
        	else if (ideology.equals("soc"))
        		out.println("您是一名<b>社会主义者</b>");
        	else if (ideology.equals("fre"))
        		out.println("您是一名<b>自由主义者</b>");
        	else if (ideology.equals("mid"))
        		out.println("您是一名<b>中间派</b>");
        	else if (ideology.equals("con"))
        		out.println("您是一名<b>保守主义者</b>");
        	else if (ideology.equals("fas"))
        		out.println("您是一名<b>法西斯主义者</b>");
        	else if (ideology.equals("naz"))
        		out.println("您是一名<b>纳粹主义者</b>");
        	else if (ideology.equals("ter"))
        		out.println("您是一名<b>神权主义者</b>");
	    %>
	</body>
</html>