package ua.nure.osmachko.summarytask4.web.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.core.entity.Subject;
import ua.nure.osmachko.summarytask4.dao.DAOFacultySubjects;
import ua.nure.osmachko.summarytask4.dao.impl.DAOFactoryImpl;
import ua.nure.osmachko.summarytask4.web.ActionType;
import ua.nure.osmachko.summarytask4.web.Path;

public class RegistrateOnFacultyCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4793530729378554748L;
	
	private static final Logger LOG = Logger.getLogger(RegistrateOnFacultyCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {
		LOG.debug("Start executing Command");

		String result = null;

		if (ActionType.GET == actionType) {
			result = doGet(request, response);
		} else if (ActionType.POST == actionType) {
			result = doPost(request, response);
		}

		LOG.debug("Finished executing Command");

		return result;
	}

	
	private String doGet(HttpServletRequest request, HttpServletResponse response) {
		LOG.trace("request for only showing showSubjectsOnFaculty.jsp");
		
		return Path.FORWARD_SHOW_SUBJECTS_ON_FACULTY;
	}
	
	private String doPost(HttpServletRequest request, HttpServletResponse response) {
		Integer facultyId = Integer.parseInt(request.getParameter("facultyId"));
		LOG.trace("Fields were got: " + "facultyId = " + facultyId);
		request.getSession().setAttribute("FacultyId", facultyId);
		DAOFacultySubjects daofs = new DAOFactoryImpl().getDAOFacultySubjects();
		LOG.trace("finding subjects by faculty id..");
		List<Subject> subjects = daofs.findSubjectsByFacultyId(facultyId);
		request.getSession().setAttribute("subjects", subjects);
		LOG.trace("subjects were found" + subjects);
		
		
		return Path.REDIRECT_TO_SHOW_FACULTY_SUBJECTS;
	}
}
