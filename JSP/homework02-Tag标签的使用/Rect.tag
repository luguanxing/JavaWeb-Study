<%@ tag pageEncoding="utf-8"%>
<%@ attribute name="ra" required="true" %>
<%@ attribute name="rb" required="true" %>
  <% 
  	request.setCharacterEncoding("utf-8");
  	try {
		double a=Double.parseDouble(ra);
		double b=Double.parseDouble(rb);
		double c=a*b;
		if (a >= 0 && b >= 0)
			out.println("矩形面积是"+c);
		else
			out.println("出现负数");
  	} catch (NumberFormatException r) {
		out.println("数据计算出错");
  	}
  %>
