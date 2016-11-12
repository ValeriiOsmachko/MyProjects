package ua.nure.osmachko.summarytask4.web.command;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.core.entity.Faculty;
import ua.nure.osmachko.summarytask4.dao.FacultyDAO;
import ua.nure.osmachko.summarytask4.dao.impl.DAOFactoryImpl;
import ua.nure.osmachko.summarytask4.dao.impl.FacultyDAOImpl;
import ua.nure.osmachko.summarytask4.web.ActionType;
import ua.nure.osmachko.summarytask4.web.Path;
import ua.nure.osmachko.summarytask4.web.command.dto.FacultyDto;

public class SortFacultyByNameCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2755154433535039795L;
	
	private static final Logger LOG = Logger.getLogger(SortFacultyByNameCommand.class);
	
	
	private static final Comparator<FacultyDto> SORT_FACULTY_BY_NAME = new Comparator<FacultyDto>() {

		@Override
		public int compare(FacultyDto o1, FacultyDto o2) {
			return o1.getNameOfFaculty().compareTo(o2.getNameOfFaculty());
		}
	};

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
	
	private String doPost(HttpServletRequest request,
			HttpServletResponse response) {
		
		LOG.trace("Starting sorting faculties using Comporator");
//		FacultyDAO facultydao = new DAOFactoryImpl().getFacultyDAO();
//		List<Faculty> faculties = facultydao.getAllFaculty();
		List<FacultyDto> faculties = (List<FacultyDto>) request.getSession().getAttribute("faculties");
		Collections.sort(faculties, SORT_FACULTY_BY_NAME);
		request.getSession().setAttribute("faculties", faculties);
		LOG.trace("Faculties are sorted successfully");
		return Path.REDIRECT_TO_SHOW_SORTED_BY_NAME;
	}

}
