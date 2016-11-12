package ua.nure.osmachko.summarytask4.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.web.command.Command;
import ua.nure.osmachko.summarytask4.web.command.CommandContainer;

/**
 * The Front controller.
 * @author Valerii Osmachko
 *
 */
public class FrontController extends HttpServlet{

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 6378532920699755726L;

	
	private static final Logger LOG = Logger.getLogger(FrontController.class);
	

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response, ActionType.GET);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response, ActionType.POST);
	}


	private void process(HttpServletRequest request,
			HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {

		LOG.debug("Start processing in Controller");

		// extract command name from the request
		String commandName = request.getParameter("command");
		LOG.trace("Request parameter: 'command' = " + commandName);

		// obtain command object by its name
		Command command = CommandContainer.get(commandName);
		LOG.trace("Obtained 'command' = " + command);

		// execute command and get forward address
		
		String path = command.execute(request, response, actionType);

		if (path == null) {
			LOG.trace("Redirect to address = " + path);
			LOG.debug("Controller proccessing finished");
			response.sendRedirect(Path.WELCOME_PAGE);
		} else {
			if (actionType == ActionType.GET) {
				LOG.trace("Forward to address = " + path);
				LOG.debug("Controller proccessing finished");
				RequestDispatcher disp = request.getRequestDispatcher(path);
				disp.forward(request, response);
			} else if (actionType == ActionType.POST) {
				LOG.trace("Redirect to address = " + path);
				LOG.debug("Controller proccessing finished");
				response.sendRedirect(path);
			}
		}
	}



}
