<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Homework01</title>
	</head>
	<body>
		<FORM action="hw01_b.jsp"  method=post   name=form>
	    	<P>请输入下列信息：
	    	<BR>输入您的帐号(非空):<Input type="text"  name="username"></BR> 
	    	<BR>输入您的密码(长度>=6位):<Input type="password"  name="password"></BR> 
			<BR>输入您的姓名(非空):<Input type="text"  name="name"></BR>
       		<BR>选择您的性别:<Input type="radio" name="S" value="male" checked="default">男 
                     	 <Input type="radio" name="S" value="female">女 
            <BR>选择您的意识形态:<Input type="radio" name="I" value="com">共产主义
						<Input type="radio" name="I" value="soc">社会主义
						<Input type="radio" name="I" value="fre">自由主义
						<Input type="radio" name="I" value="mid"  checked="default">中间派  
						<Input type="radio" name="I" value="con">保守主义
						<Input type="radio" name="I" value="fas">法西斯主义  
						<Input type="radio" name="I" value="naz">纳粹主义
						<Input type="radio" name="I" value="ter">神权主义   
	       <BR>
	       <Input type="submit" value="提交" name="submit">
	    </FORM> 
	</body>
</html>
