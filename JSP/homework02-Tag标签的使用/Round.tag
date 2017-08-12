<%@ tag pageEncoding="utf-8"%>
<%@ attribute name="r" required="true" %>
  <%
  	request.setCharacterEncoding("utf-8");
	try {
     	double a=Double.parseDouble(r);
     	double c=3.14*a*a;
		if (a >= 0)
       		out.println("圆的面积是"+c);
		else
			out.println("出现负数");
  	} catch (NumberFormatException r) {
		out.println("数据计算出错");
  	}
  %>
