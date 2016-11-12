package ua.nure.osmachko.summarytask4.web.command;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.locale.i18n.LocaleType;
import ua.nure.osmachko.summarytask4.web.ActionType;

public class LanguageCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8853052548275306970L;

	private static final Logger LOGGER = Logger.getLogger(LanguageCommand.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {
		LOGGER.debug("Start executing Command");

		String result = null;

		if (actionType == ActionType.POST) {
			result = doPost(request, response);
		} else {
			result = null;	
		}

		LOGGER.debug("End executing command");
		return result;
	}

	
	private String doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// action
//	final String action = "controller?";
////		String locale;
//
//		// get parameters
//	String url = request.getParameter("url");
//	String lang = request.getParameter("language");
//	LOGGER.trace("url: " + url + ", lang: " + lang);
////	Locale defloc = Locale.getDefault();
////	LOGGER.trace("DEFAULT = " + defloc.toString());
//	ResourceBundle rb;
//	if(lang.equals("en")) {
//		Locale englishLocale = new Locale("en", "US");
//	rb = ResourceBundle.getBundle("resources", englishLocale);	
//	} else if(lang.equals("ru")) {
//		Locale russianLocale = new Locale("ru", "RU");
//		rb = ResourceBundle.getBundle("resources", russianLocale);
//	}
//	
////		Locale userLocale = new Locale(lang);
////		 Locale userPreferredLocale = request.getLocale();
////		 
////		 if(userPreferredLocale != null) {
////			 if(userPreferredLocale.getLanguage().equals(LocaleType.EN.getValue())) {
////				 
////			 }
////		 }
////		 LOGGER.trace("Preferred Locale: " + userPreferredLocale.toString());
////		 set language
////		 ResourceBundle rs;
////		 if(lang.equals("ru")) {
////			  rs = ResourceBundle.getBundle("resources_ru.properties");
////		 } else {
////			  rs = ResourceBundle.getBundle("resources_en.properties");
////		 }
//		request.getSession().setAttribute("lang", lang);
////		LOGGER.trace("Language has been changed to " + lang);
//
//		// if language changes on login page
//	if (url.equals("command=logout") || url.equals("")) {
//		return null;
//		}
//
//		return action + url;
//	
		final String action = "controller?";

		// get parameters
		String url = request.getParameter("url");
		String lang = request.getParameter("language");
		LOGGER.trace("url: " + url + ", lang: " + lang);

		// set language
		request.getSession().setAttribute("lang", lang);
		LOGGER.trace("Language has been changed to " + lang);

		// if language changes on login page
		if (url.equals("command=logout") || url.equals("")) {
			return null;
		}

		return action + url;
	
	}
}
