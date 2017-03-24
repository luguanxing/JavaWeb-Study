<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="computer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Homework02</title>
	</head>
	<body>
		<FORM action="" method=post   name=form>
	    	<P>请输入矩形长和宽数值计算<BR>
	    	矩形长:<Input type="text"  name="ra"><BR>
	    	矩形宽:<Input type="text"  name="rb"><BR>
	    	<Input type="submit" value="计算矩形" name="submit"><BR>
	    </FORM>
	    <%
	    	 String sra=request.getParameter("ra");
	    	 String srb=request.getParameter("rb");
	    	 String sr=request.getParameter("r");
	         if (sra == null || srb == null) {

	         } else {
	    %>     
	        	<computer:Rect ra="<%= sra %>" rb="<%= srb %>" />
	    <%  
	    	 }
	    %> 
	    	  
	    	  
	    <FORM action="" method=post   name=form>		
	    	<P>请输入圆形数半径计算面积<BR>
	    	圆形半径:<Input type="text"  name="r"><BR>
	        <Input type="submit" value="计算圆形" name="submit"><BR>
	    </FORM>
	    <%
	         if (sr == null) {
	        	 
	         } else {
	    %>     
	        	<computer:Round r="<%= sr %>"/>
	    <%  
	    	}
	    %> 
	</body>
</html>
