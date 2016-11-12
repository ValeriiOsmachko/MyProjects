package ua.nure.osmachko.summarytask4.web.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.web.Path;

public class AccessFilter implements Filter {
	
	
	private static final Logger LOGGER = Logger.getLogger(AccessFilter.class);

	private static Map<String, List<String>> accessMap = new HashMap<String, List<String>>();
	private static List<String> commons = new ArrayList<String>();
	private static List<String> outOfControl = new ArrayList<String>();
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		LOGGER.debug("Filter starts");

		if (accessAllowed(request)) {
			LOGGER.debug("Filter finished");
			chain.doFilter(request, response);
		} else {
			String errorMessasge = "You do not have permission to access the requested resource";

			request.setAttribute("errorMessage", errorMessasge);
			LOGGER.trace("Set the request attribute: errorMessage --> " + errorMessasge);

			request.getRequestDispatcher(Path.PAGE_ERROR_PAGE).forward(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig conf) throws ServletException {
		LOGGER.debug("Filter initialization starts");

		// roles
		accessMap.put("admin", asList(conf.getInitParameter("admin")));
		accessMap.put("client", asList(conf.getInitParameter("client")));
		LOGGER.trace("Access map --> " + accessMap);

		// commons
		commons = asList(conf.getInitParameter("common"));
		LOGGER.trace("Common commands --> " + commons);

		// out of control
		outOfControl = asList(conf.getInitParameter("out-of-control"));
		LOGGER.trace("Out of control commands --> " + outOfControl);

		LOGGER.debug("Filter initialization finished");
		
	}
	
	private boolean accessAllowed(ServletRequest request) {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		String commandName = request.getParameter("command");
		LOGGER.trace("Command name --> " + commandName);
		if (commandName == null || commandName.isEmpty()) {
			return false;
		}
		if (outOfControl.contains(commandName)) {
			return true;
		}
		HttpSession session = httpRequest.getSession(false);
		if (session == null) {
			return false;
		}
		String userRole = (String) session.getAttribute("userRole");
		if (userRole == null) {
			return commons.contains(commandName);
		}
		return accessMap.get(userRole).contains(commandName) || commons.contains(commandName);
	}
	
	
	private List<String> asList(String str) {
		List<String> list = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(str);
		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}
		return list;
	}

}
