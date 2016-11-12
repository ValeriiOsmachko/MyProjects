package ua.nure.osmachko.summarytask4.web.command;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.core.entity.Faculty;
import ua.nure.osmachko.summarytask4.dao.FacultyDAO;
import ua.nure.osmachko.summarytask4.dao.impl.DAOFactoryImpl;
import ua.nure.osmachko.summarytask4.web.ActionType;

public class UpdateFacultyCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5941101029576184634L;
	
	
	private static final Logger LOG = Logger.getLogger(UpdateFacultyCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {
		LOG.debug("Start executing Command");

		String result = null;

		if (actionType == ActionType.POST) {
			result = doPost(request, response);
		} else if(actionType == ActionType.GET){
			result = doGet(request, response);
		}

		LOG.debug("End executing command");
		return result;
	}
	
	private String doPost(HttpServletRequest request, HttpServletResponse response) {
		LOG.trace("Starting process of updating");
		String nameOfFaculty = request.getParameter("nameOfFaculty");
		byte[] bytes = nameOfFaculty.getBytes(StandardCharsets.ISO_8859_1);
		nameOfFaculty = new String(bytes, StandardCharsets.UTF_8);
		Integer budgetSeats = Integer.parseInt(request.getParameter("budgetSeats"));
		Integer totalSeats = Integer.parseInt(request.getParameter("totalSeats"));
		Integer id = (Integer) request.getSession().getAttribute("idOfFaculty");
		Faculty faculty = new Faculty(nameOfFaculty,budgetSeats,totalSeats);
		LOG.trace("Fields for new Faculty were got" + nameOfFaculty + " " + budgetSeats + " " + totalSeats);
		FacultyDAO facultydao = new DAOFactoryImpl().getFacultyDAO();
		facultydao.updateFaculty(id,faculty);
		
		LOG.trace("The Faculty in Data Base was updated");
		return ua.nure.osmachko.summarytask4.web.Path.REDIRECT_TO_VIEW_ALL_FACULTIES;
		
	}
	
	
	private String doGet(HttpServletRequest request, HttpServletResponse response) {
		LOG.trace("request for only showing updateFaculty.jsp");
		Integer id = Integer.parseInt(request.getParameter("facultyId"));
		LOG.trace("Id Of Faculty was got = " + id);
		request.getSession().setAttribute("idOfFaculty", id);
		return ua.nure.osmachko.summarytask4.web.Path.FORWARD_UPDATE_FACULTY_FORM;
	}

}
