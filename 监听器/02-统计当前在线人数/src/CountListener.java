import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Administrator on 2017/8/15.
 */
public class CountListener implements HttpSessionListener {
	
	private int count = 0; //某段时间内session数，用于统计在线人数

	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		count++;
		ServletContext context = httpSessionEvent.getSession().getServletContext();	//修改全局人数变量
		context.setAttribute("count", new Integer(count));
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		count--;
		ServletContext context = httpSessionEvent.getSession().getServletContext();
		context.setAttribute("count", new Integer(count));
	}
}
