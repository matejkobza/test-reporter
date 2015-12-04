package sk.trilobit.eskn.reporter;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Simple {@link ServletContextListener} to test gh-2058.
 */
@Component
public class ExampleServletContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("*** contextInitialized");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("*** contextDestroyed");
	}

}
