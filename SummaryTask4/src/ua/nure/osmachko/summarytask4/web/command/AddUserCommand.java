package ua.nure.osmachko.summarytask4.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.core.entity.User;
import ua.nure.osmachko.summarytask4.dao.UserDAO;
import ua.nure.osmachko.summarytask4.dao.impl.DAOFactoryImpl;
import ua.nure.osmachko.summarytask4.dao.impl.FacultyDAOImpl;
import ua.nure.osmachko.summarytask4.dao.impl.UserDAOImpl;
import ua.nure.osmachko.summarytask4.web.ActionType;
import ua.nure.osmachko.summarytask4.web.Path;

public class AddUserCommand extends Command {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7423187017766399581L;
	
	private static final Logger LOG = Logger.getLogger(AddUserCommand.class);
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
	
	
	private String doPost(HttpServletRequest request, HttpServletResponse response) {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String login = request.getParameter("login");
		String role = request.getParameter("role");
		
		
		UserDAO ud = new DAOFactoryImpl().getUserDAO();
		User user = new User(email,password,login,firstName,lastName,role);
		ud.insertUser(user);
		LOG.trace("User added to database");
		return Path.REDIRECT_TO_VIEW_ALL_USERS;
		
		
	}

}
