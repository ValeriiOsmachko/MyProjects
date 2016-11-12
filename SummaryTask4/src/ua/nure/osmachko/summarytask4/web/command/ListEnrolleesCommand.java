package ua.nure.osmachko.summarytask4.web.command;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.core.entity.Enrollee;
import ua.nure.osmachko.summarytask4.dao.EnrolleeDAO;
import ua.nure.osmachko.summarytask4.dao.impl.EnrolleeDAOImpl;
import ua.nure.osmachko.summarytask4.web.ActionType;

public class ListEnrolleesCommand extends Command{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2198947123920988813L;
	
	private static final Logger LOG = Logger.getLogger(ListEnrolleesCommand.class);
	

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
		EnrolleeDAO enrolledao = new EnrolleeDAOImpl();	
		Collection<Enrollee> enrollees = enrolledao.getAllEnrollees();
		LOG.trace("Enrollees found: " + enrollees);
		request.setAttribute("enrollees", enrollees);
		
		
		return ua.nure.osmachko.summarytask4.web.Path.FORWARD_VIEW_ALL_ENROLLEES;
				
		
	}

}
