import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ClassicServer extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String old = request.getParameter("name");
            if(old == null || old.length() == 0){
                out.println("用户名不能为空");
            } else{
                String name = new String(old.getBytes("UTF-8"), "UTF-8");
                if(name.equals("luguanxing")){
                    out.println("用户名[" + name + "]已经存在，请使用其他用户名");
                } else{
                    out.println("用户名[" + name + "]尚未存在，可以使用该用户名注册");
                }
            }
            out.println("<br/><a href=\"classic.html\">返回校验页面</a>");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
