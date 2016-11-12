package ua.nure.osmachko.summarytask4.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.web.ActionType;
import ua.nure.osmachko.summarytask4.web.Path;

public class ShowEnrolleePageCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3134949953342803680L;

	private static final Logger LOG = Logger.getLogger(ShowEnrolleePageCommand.class);

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
//		UserManager manager = new UserManagerImpl();
//
//		Collection<User> doctors = manager.getDoctors();
//		LOG.trace("Doctors found: " + doctors);
//
//		Collection<Specialization> specializations = manager.getSpecializations();
//		LOG.trace("Specializations found: " + specializations);
//
//		request.setAttribute("doctors", doctors);
//		request.getSession().setAttribute("specializations", specializations);

		return Path.PAGE_ENROLLEES_PAGE;
	}

}
