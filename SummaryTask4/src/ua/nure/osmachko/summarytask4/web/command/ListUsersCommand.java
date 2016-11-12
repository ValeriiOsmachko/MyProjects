package ua.nure.osmachko.summarytask4.web.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.core.entity.Enrollee;
import ua.nure.osmachko.summarytask4.core.entity.User;
import ua.nure.osmachko.summarytask4.dao.EnrolleeDAO;
import ua.nure.osmachko.summarytask4.dao.UserDAO;
import ua.nure.osmachko.summarytask4.dao.impl.DAOFactoryImpl;
import ua.nure.osmachko.summarytask4.web.ActionType;
import ua.nure.osmachko.summarytask4.web.Path;
import ua.nure.osmachko.summarytask4.web.command.dto.UserConverter;
import ua.nure.osmachko.summarytask4.web.command.dto.UserDto;

public class ListUsersCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8802137618226595298L;
	
	private static final Logger LOG = Logger.getLogger(ListUsersCommand.class);

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
		LOG.trace("Starting doGet() method in ListUsersCommand....");
		UserDAO ud = new DAOFactoryImpl().getUserDAO();
		List<User> collection = ud.getAllUsers();
		List<UserDto> userdto = new ArrayList<UserDto>();
		for(User item : collection) {
			userdto.add(UserConverter.getInstance().convert(item));
		}
		request.getSession().setAttribute("userses", userdto);
		
		return Path.FORWARD_TO_VIEW_ALL_USERS;
	}
	
//	private String doPost(HttpServletRequest request, HttpServletResponse response) {
//		String firstName = request.getParameter("firstName");
//		String lastName = request.getParameter("lastName");
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		String login = request.getParameter("login");
//		String role = request.getParameter("role");
//		
//		
//		UserDAO ud = new DAOFactoryImpl().getUserDAO();
//		User user = new User(email,password,login,firstName,lastName,role);
//		ud.insertUser(user);
//		LOG.trace("User added to database");
//		return Path.REDIRECT_TO_VIEW_ALL_USERS;
//		
//		
//	}

}
