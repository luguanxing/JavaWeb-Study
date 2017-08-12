<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>check</title>
	</head>
	<body>
		<%!
			synchronized boolean check(String user) {
				ServletContext app = getServletContext();
				Vector<String> users = (Vector<String>)app.getAttribute("users");
				if (users == null) {
					users = new Vector<String>();
				} else {
					String[] signinfos = user.split("#");
					for (int i = 0; i < users.size(); i++) {
						String[] usersi = users.get(i).split("#");
						if (usersi[0].equals(signinfos[0])) {
							if (usersi[1].equals(signinfos[1]))
								return true;
							else
								return false;
						}
					}
				}
				users.add(user);
				app.setAttribute("users", users);
				return true;
			}
		%>
	
		<%
	  		request.setCharacterEncoding("utf-8");
	        String username=request.getParameter("username");
	        String password=request.getParameter("password");
	        if (username == null || password == null) {				//不是从login.jsp打开detail.jsp则返回login.jsp
	        	response.sendRedirect("sign.jsp");
	        } else if (username.isEmpty() || password.isEmpty()) {	//从login.jsp打开detail.jsp则验证帐号密码
				out.println("信息不完整");
			} else {
				String user = username + "#" + password;
				if (check(user)) {
					session.setAttribute("user", username);
					out.println("注册成功");
					response.sendRedirect("detail.jsp");
				} else {
					out.println("用户名已被注册或密码不正确");
					%>
						<FORM action="sign.jsp"  method=post  name=form>
					        <Input type="submit" value="返回" name="submit">
						</FORM>
					<%
				}
			}
		%>
	</body>
</html>
