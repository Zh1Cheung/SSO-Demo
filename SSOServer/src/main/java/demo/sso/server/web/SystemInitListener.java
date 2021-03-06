package demo.sso.server.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author : Zh1Cheung 945503088@qq.com
 * @date : 2018/6/6 20:21
 */


@WebListener
public class SystemInitListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent event) {
		// Do nothing
	}

	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();
		servletContext.setAttribute("appctx", servletContext.getContextPath());
		servletContext.setAttribute("sysName", servletContext.getInitParameter("sysName"));
	}

}
