package ua.nure.osmachko.summarytask4.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.web.ActionType;
import ua.nure.osmachko.summarytask4.web.Path;

public class ShowSortedFacultyByTotalSeatsCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3245611532101347398L;
	
	private static final Logger LOG = Logger.getLogger(ShowSortedFacultyByTotalSeatsCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {
		LOG.debug("Start executing Command");
		
		String result = null;
		
		if (ActionType.GET == actionType) {
			result = doGet(request, response);
		}
		
		LOG.debug("Finished executing Command");
		return result;
	}

	
	private String doGet(HttpServletRequest request,
			HttpServletResponse response) {
		LOG.trace("Showing Faculties.jsp");
		return Path.FORWARD_VIEW_ALL_FACULTY;
	}
}
