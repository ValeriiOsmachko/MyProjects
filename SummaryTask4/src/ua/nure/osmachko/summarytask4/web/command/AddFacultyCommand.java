package ua.nure.osmachko.summarytask4.web.command;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.core.entity.Faculty;
import ua.nure.osmachko.summarytask4.dao.DAOFacultySubjects;
import ua.nure.osmachko.summarytask4.dao.FacultyDAO;
import ua.nure.osmachko.summarytask4.dao.impl.DAOFactoryImpl;
import ua.nure.osmachko.summarytask4.dao.impl.FacultyDAOImpl;
import ua.nure.osmachko.summarytask4.web.ActionType;
import ua.nure.osmachko.summarytask4.web.Path;
import ua.nure.osmachko.summarytask4.web.utils.NewFacultyValidation;

public class AddFacultyCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2851620804982812518L;
	
	
	private static final Logger LOG = Logger.getLogger(AddFacultyCommand.class);

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
		
		return Path.FORWARD_FACULTY_ADD;
	}
	
	private String doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean valid = NewFacultyValidation.isValidNewFaculty(request.getParameter("nameOfFaculty"), request.getParameter("totalSeats"), request.getParameter("budgetSeats"));
		String result = null;
		if(valid == true) {
		String nameOfFaculty = request.getParameter("nameOfFaculty");
		byte[] bytes = nameOfFaculty.getBytes(StandardCharsets.ISO_8859_1);
		nameOfFaculty = new String(bytes, StandardCharsets.UTF_8);
		Integer totalSeats = Integer.parseInt(request.getParameter("totalSeats"));
		Integer budgerSeats = Integer.parseInt(request.getParameter("budgetSeats"));
		
		LOG.trace("Fields were got: " + nameOfFaculty + "," + totalSeats + ", " + budgerSeats);
		
		Faculty faculty = new Faculty(nameOfFaculty, budgerSeats, totalSeats);
		
		FacultyDAO facultydao = new FacultyDAOImpl();
		
		facultydao.insertFaculty(faculty);
		
		LOG.trace("The Faculty was added to database");
		
		LOG.trace("Starting Adding Subjects...");
		String firstSubject = request.getParameter("FirstSubject");
		String secondSubject = request.getParameter("SecondSubject");
		String thirdSubject = request.getParameter("ThirdSubject");
		LOG.trace("Sbujects were got : " + firstSubject + ", " + secondSubject 
				+ ", " + thirdSubject);
		Faculty faculty1 = (Faculty) facultydao.getFacultyByNameOfFaculty(faculty.getNameOfFaculty());
		Integer idFaculty = faculty1.getId();
		LOG.trace("id was got = " + idFaculty);
		Integer idFirstSubject = new DAOFactoryImpl().getSubjectDAO().findIdSubjectByNameOfSubject(firstSubject);
		Integer idSecondSubject = new DAOFactoryImpl().getSubjectDAO().findIdSubjectByNameOfSubject(secondSubject);
		Integer idThirdSubject = new DAOFactoryImpl().getSubjectDAO().findIdSubjectByNameOfSubject(thirdSubject);
		LOG.trace("id subjects = " + " id1st " + idFirstSubject
				+ " ,id2nd " + idSecondSubject + ",id3rd " + idThirdSubject);
		new DAOFactoryImpl().getDAOFacultySubjects().insertSubjectsToFaculty(idFaculty, idFirstSubject);
		new DAOFactoryImpl().getDAOFacultySubjects().insertSubjectsToFaculty(idFaculty, idSecondSubject);
		new DAOFactoryImpl().getDAOFacultySubjects().insertSubjectsToFaculty(idFaculty, idThirdSubject);
		LOG.trace("Subjects were added");
		
		
		result =  Path.REDIRECT_TO_VIEW_ALL_FACULTIES;
		}else {
			LOG.error("INVALID INPUT DATA, PLEASE TRY AGAIN!");
//			doGet(request, response);
			return Path.REDIRECT_TO_VIEW_ALL_FACULTIES;
		}
		
		return result;
	}
	

}
