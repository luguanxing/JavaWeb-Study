import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/6/5.
 */
public class AJAXCacheServer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            Integer clicks = (Integer) req.getSession().getAttribute("clicks");
            int sum = 0;
            if (clicks == null) {
                sum = 1;
                req.getSession().setAttribute("clicks", 1);
            } else {
                sum = clicks.intValue() + 1;
                req.getSession().setAttribute("clicks", sum);
            }
            String name = req.getParameter("name");  //1.取参数信息
            if(name == null || name.length() == 0){   //2.检查参数合法
                out.println("用户名不能为空");
            } else{
                //3.校验操作
                if(name.equals("luguanxing")){
                    out.println("用户名[" + name + "]已经存在，请使用其他用户名， " + sum);  //4.区别传统应用，这里只返回用户需要的数据(*)而不是返回新页面
                } else{
                    out.println("用户名[" + name + "]尚未存在，可以使用该用户名注册，" + sum);
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
