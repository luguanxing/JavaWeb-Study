import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Administrator on 2017/8/14.
 */
public class CreateAndDestoryListener implements ServletContextListener, HttpSessionListener, ServletRequestListener {
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("ServletContext创建");
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("ServletContext销毁");
	}
	
	@Override
	public void requestInitialized(ServletRequestEvent servletRequestEvent) {
		System.out.println("=============================");
		System.out.println("ServletRequest创建");
	}	
	
	@Override
	public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
		System.out.println("ServletRequest销毁");
		System.out.println("=============================");
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		System.out.println("HttpSession创建");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		System.out.println("HttpSession销毁");
	}
}
