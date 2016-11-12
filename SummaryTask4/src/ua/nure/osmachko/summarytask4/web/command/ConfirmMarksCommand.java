package ua.nure.osmachko.summarytask4.web.command;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.core.entity.Enrollee;
import ua.nure.osmachko.summarytask4.core.entity.FacultyEnrollee;
import ua.nure.osmachko.summarytask4.core.entity.User;
import ua.nure.osmachko.summarytask4.dao.impl.DAOFactoryImpl;
import ua.nure.osmachko.summarytask4.web.ActionType;
import ua.nure.osmachko.summarytask4.web.Path;
import ua.nure.osmachko.summarytask4.web.utils.MarksValidator;



@MultipartConfig
public class ConfirmMarksCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5099583718548817166L;

	
	private static final Logger LOG = Logger.getLogger(ConfirmMarksCommand.class);
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
		LOG.trace("request for only showing addFacultyForm.jsp");
		String mark1 = request.getParameter("0");
		String mark2 = request.getParameter("1");
		String mark3 = request.getParameter("2");
		return Path.FORWARD_FACULTY_ADD;
	}
	
	
	private String doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, IllegalStateException, ServletException {
		boolean valid = MarksValidator.isValidmarks(request.getParameter("0"), request.getParameter("1"), request.getParameter("2"));
		String result = null;
		if(valid == true) {
		Integer mark1 = Integer.parseInt(request.getParameter("0"));
		Integer mark2 = Integer.parseInt(request.getParameter("1"));
		Integer mark3 = Integer.parseInt(request.getParameter("2"));
		LOG.trace("mark1 = "  + mark1 + ", mark2 = " + mark2 + ", mark3 = " + mark3);
		Integer summaryPoint = mark1 + mark2 + mark3;
		User user = (User) request.getSession().getAttribute("user");
		Enrollee enrollee = (Enrollee) request.getSession().getAttribute("enrollee");
		Integer idFaculty = (Integer) request.getSession().getAttribute("FacultyId");
		FacultyEnrollee fe = new FacultyEnrollee(idFaculty,user.getId(),user.getFirstName(),user.getLastName(),enrollee.getCity(),
				enrollee.getRegion(),summaryPoint);
		LOG.trace("FacultyEnrollee was created" + fe);
		new DAOFactoryImpl().getDAOFacultyEnrollee().insertFacultyEnrollee(fe);	
		LOG.trace("added to databese");
		result = Path.REDIRECT_TO_VIEW_ALL_FACULTIES;
		} else {
			LOG.error("Not Correct Marks! Try Again");
			result = Path.REDIRECT_TO_SHOW_FACULTY_SUBJECTS;
		}
		
		return result;
		
	}

}
