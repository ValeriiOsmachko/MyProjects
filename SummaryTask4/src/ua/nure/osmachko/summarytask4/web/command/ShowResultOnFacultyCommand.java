package ua.nure.osmachko.summarytask4.web.command;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.core.entity.User;
import ua.nure.osmachko.summarytask4.dao.UserDAO;
import ua.nure.osmachko.summarytask4.dao.impl.DAOFactoryImpl;
import ua.nure.osmachko.summarytask4.web.ActionType;
import ua.nure.osmachko.summarytask4.web.Path;
import ua.nure.osmachko.summarytask4.web.utils.RegistrateUserValidator;

public class ShowResultOnFacultyCommand extends Command{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3103911368195737803L;
	
	
	private static final Logger LOG = Logger.getLogger(MakeResultOnFacultyCommand.class);

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
		String s = request.getParameter("nameOfFaculty");
		request.getSession().setAttribute("currentFaculty", s);
		return Path.REDIRECT_TO_SHOW_RESULTS;
	}

}
