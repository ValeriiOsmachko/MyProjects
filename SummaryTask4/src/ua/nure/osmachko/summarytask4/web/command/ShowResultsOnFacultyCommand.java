package ua.nure.osmachko.summarytask4.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.web.ActionType;
import ua.nure.osmachko.summarytask4.web.Path;

public class ShowResultsOnFacultyCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1205300318190633452L;
	
	private static final Logger LOG = Logger.getLogger(ShowResultsOnFacultyCommand.class);

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
	
	
	private String doGet(HttpServletRequest request, HttpServletResponse response) {
		return Path.FORWARD_TO_VIEW_RESULTS;
	}

}
