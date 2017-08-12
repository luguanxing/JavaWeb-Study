import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AJAXXMLServer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            req.setCharacterEncoding("UTF-8");
            //修改点1：响应的Content-Typ修改为text/xml格式，即返回XML格式
            resp.setContentType("text/xml;charset=utf-8");
            PrintWriter out = resp.getWriter();
            String name = req.getParameter("name");
            //修改点2：返回的数据需要拼装成xml格式，只返回所需数据
            StringBuilder sb = new StringBuilder();
            sb.append("<message>");
            if(name == null || name.length() == 0){
                sb.append("用户名不能为空").append("</message>");
            } else{
                if(name.equals("luguanxing")){
                    sb.append("用户名[" + name + "]已经存在，请使用其他用户名").append("</message>");
                } else{
                    sb.append("用户名[" + name + "]尚未存在，可以使用该用户名注册").append("</message>");
                }
            }
            out.println(sb.toString());
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
