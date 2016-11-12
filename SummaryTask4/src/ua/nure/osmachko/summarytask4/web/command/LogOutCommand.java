package ua.nure.osmachko.summarytask4.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.web.ActionType;

public class LogOutCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5027715730899128008L;
	
	private static final Logger LOG = Logger.getLogger(LogOutCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {
		LOG.debug("Start executing Command");

		String result = null;

		if (actionType == ActionType.POST) {
			result = doPost(request, response);
		} else {
			result = null;
		}

		LOG.debug("End executing command");
		return result;
	}

	
	private String doPost(HttpServletRequest request,
			HttpServletResponse response) {
		LOG.trace("Starting process of Log Out...");
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		LOG.trace("Log Out complete");
		return "index.jsp";
		
	}
	
}
