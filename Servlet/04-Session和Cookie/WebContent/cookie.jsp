<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			out.print("您上次访问时间是：");  //print()方法输出会自动换行
	
	        //获得用户的时间cookie
	        Cookie cookies[]=request.getCookies(); //返回一个cookie数组
	        for(int i=0;cookies!=null && i<cookies.length;i++){  //遍历
	            if(cookies[i].getName().equals("lastAccessTime")){   //判断是不是保存时间的cookie
	                long cookieValue=Long.parseLong(cookies[i].getValue()); //得到用户的上次访问时间,转化成一个毫秒值
	                Date date=new Date(cookieValue);  //用毫秒值创建一个Date对象
	                out.print(date.toLocaleString());  //输出
	            }
	        }
	
	
	        //给用户回送最新的访问时间
	        Cookie cookie=new Cookie("lastAccessTime",System.currentTimeMillis()+""); //创建一个保存用户最新访问时间的cookie,其值是当前的毫秒值
	        cookie.setMaxAge(1*30*24*3600); //设置cookie的有效期,以秒为单位
	        cookie.setPath("/"); //设置cookie的有效路径，这里访问day07应用下所有资源
	
	        response.addCookie(cookie); //把cookie写给浏览器
		%>
	</body>
</html>