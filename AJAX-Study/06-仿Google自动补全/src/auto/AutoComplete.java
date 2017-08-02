package auto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/8/2.
 */

public class AutoComplete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String word = req.getParameter("word");
		if (word != null) {
			req.setAttribute("word", word);        //转发请求到视图层(不返回页面只返回数据)
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/wordxml.jsp");
			dispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
