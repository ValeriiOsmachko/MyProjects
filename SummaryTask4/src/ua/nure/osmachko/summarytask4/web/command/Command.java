package ua.nure.osmachko.summarytask4.web.command;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.osmachko.summarytask4.web.ActionType;

public abstract class Command implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8232986207034616233L;

	
	
	
	public abstract String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException;
	
	
	@Override
	public final String toString() {
		return getClass().getSimpleName();
	}
	
}
