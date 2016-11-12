package ua.nure.osmachko.summarytask4.web.command;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.core.entity.Enrollee;
import ua.nure.osmachko.summarytask4.core.entity.User;
import ua.nure.osmachko.summarytask4.dao.UserDAO;
import ua.nure.osmachko.summarytask4.dao.impl.DAOFactoryImpl;
import ua.nure.osmachko.summarytask4.dao.impl.UserDAOImpl;
import ua.nure.osmachko.summarytask4.web.ActionType;
import ua.nure.osmachko.summarytask4.web.Path;

public class LoginCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -475786737057260818L;
	
	private static final Logger LOG = Logger.getLogger(LoginCommand.class);

	
	
	
	
	private String doPost(HttpServletRequest request,
			HttpServletResponse response) {
		String forward = null;

		HttpSession session = request.getSession();
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		UserDAO userdao = new UserDAOImpl();
		
		User user = userdao.getUserByLogin(login);
		
		
		
//		UserManager manager = new UserManagerImpl();
//		
//		User user = manager.getUserByLogin(login);
		
		LOG.trace("User found: " + user);
		if (user == null || !password.equals(user.getPassword())) {
			request.setAttribute("errorMessage",
					"Cannot find user with such login/password");
			LOG.error("errorMessage: Cannot find user with such login/password");
//			forward = Path.PAGE_REGISTRATION_PAGE;
			forward = Path.REDIRECT_TO_SHOW_REGISTRATION_PAGE;
		} else {
			String role =  user.getRole();
//			Role userRole = Role.getRole(user);
			LOG.trace("userRole --> " + role);

			if (role.equals("admin")) {
//				forward = Path.PAGE_ADMIN_PAGE;
				forward = Path.REDIRECT_TO_SHOW_ADMIN_PAGE;
			} else {
			if (role.equals("client")) {
				boolean isEnrolleeExist = new DAOFactoryImpl().getEnrolleeDAO().isEnrolleeExistWithUserId(user.getId());
				if(isEnrolleeExist == true) {
					boolean status = new DAOFactoryImpl().getEnrolleeDAO().getStatusOfEnrollee(user.getId());
					Enrollee enrollee = new DAOFactoryImpl().getEnrolleeDAO().getEnrolleeById(user.getId());
					if(status == false) {
					request.getSession().setAttribute("enrollee", enrollee);
					forward = Path.REDIRECT_TO_VIEW_ALL_FACULTIES;
					} else if(status == true) {
						forward = "index.jsp";
					}
				} else {
//				forward = Path.PAGE_ENROLLEES_PAGE;
					forward = Path.REDIRECT_TO_SHOW_ENROLLEE_PAGE;
				}
				}
			}

			session.setAttribute("user", user);
			LOG.trace("Set the session attribute: user --> " + user);

			session.setAttribute("userRole", role);
			LOG.trace("Set the session attribute: userRole --> " + role);

			LOG.info("User " + user + " logged as " + role.toString().toLowerCase());
		}
		return forward;
	}



	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {
		LOG.debug("Start executing Command");

		String result = null;

		if (actionType == ActionType.POST) {
			result = doPost(request, response);
		} else {
			result = null;
		}

		LOG.debug("End executing command");
		return result;
	}

}
