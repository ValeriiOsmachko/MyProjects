package ua.nure.osmachko.summarytask4.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ContextListener implements ServletContextListener {
	
	
	private static final Logger LOGGER = Logger.getLogger(ContextListener.class);

	public void contextInitialized(ServletContextEvent event) {
		log("Servlet context initialization starts");

		ServletContext servletContext = event.getServletContext();
		initLog4J(servletContext);
		initCommandManager();

		log("Servlet context initialization finished");
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
	 * ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent event) {
		log("Servlet context destruction starts");
		// do nothing
		log("Servlet context destruction finished");
	}

	/**
	 * Initializes log4j framework.
	 *
	 * @param servletContext
	 *            with <code>log4j.properties</code> file path, from which
	 *            <code>log4j</code> will be configured
	 */
	private void initLog4J(ServletContext servletContext) {
		log("Log4J initialization started");
		try {
			PropertyConfigurator.configure(servletContext.getRealPath("WEB-INF/log4j.properties"));
		} catch (Exception ex) {
			LOGGER.error("Cannot configure Log4j", ex);
		}
		log("Log4J initialization finished");
		LOGGER.debug("Log4j has been initialized");
	}

	/**
	 * Initializes CommandManager.
	 */
	private void initCommandManager() {

		// initialize commands manager
		// just load class to JVM
		try {
			Class.forName("ua.nure.osmachko.summarytask4.web.command.CommandContainer");
		} catch (ClassNotFoundException ex) {
			throw new IllegalStateException("Cannot initialize Command Manager", ex);
		}
	}

	/**
	 * Logs actions to console
	 *
	 * @param msg
	 *            to be logged
	 */
	private void log(String msg) {
		System.out.println("[ContextListener] " + msg);
	}

}
