package ua.nure.osmachko.summarytask4.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.core.entity.Faculty;
import ua.nure.osmachko.summarytask4.dao.FacultyDAO;
import ua.nure.osmachko.summarytask4.dao.impl.FacultyDAOImpl;
import ua.nure.osmachko.summarytask4.web.ActionType;
import ua.nure.osmachko.summarytask4.web.Path;

public class DeleteFacultyCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7182433369956512369L;
	
	private static final Logger LOG = Logger.getLogger(DeleteFacultyCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {
		LOG.debug("Start executing Command");
		
		String result = null;
		
		if (ActionType.POST == actionType) {
			result = doPost(request, response);
		}
		
		LOG.debug("Finished executing Command");
		return result;
	}
	
	
	private String doPost(HttpServletRequest request, HttpServletResponse response) {
		LOG.trace("Starting process of deleting");
		Integer id = Integer.parseInt(request.getParameter("facultyId"));
		LOG.trace("Id of Faculty was got" + id);
		FacultyDAO facultydao = new FacultyDAOImpl();
		facultydao.deleteFaculty(id);
		LOG.trace("The Faculty was deleted from database");
		return ua.nure.osmachko.summarytask4.web.Path.REDIRECT_TO_VIEW_ALL_FACULTIES;
	}

}
