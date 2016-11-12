package ua.nure.osmachko.summarytask4.web.utils;

import org.apache.log4j.Logger;

public class FieldValidation {

	private static Logger LOG = Logger.getLogger(FieldValidation.class);
	
	private static final String positiveDecimalNumberRegEx = "\\d+";
	private static final String filledRegex = "^[а-яА-ЯёЁa-zA-Z][а-яА-ЯёЁa-zA-Z0-9-_\\.]{1,20}$";
	private static final String isLatinWord = "[a-zA-Z ]+";
	private static final String isCyrillicWord = "[а-яА-Я ]+";
	private static final String loginRegex = "^[a-z0-9_-]{3,15}$";
	
	public static boolean isFilled(String... values) {

		if (checkNull(values)) {
			return false;
		}

		for (String value : values) {
			System.out.println(value + value.matches(filledRegex));
			if (!value.matches(filledRegex)) {
			LOG.error("VALUE DOESN'T MATHCES FILLED REGEX");
				return false;
			}
		}
		return true;
	}
	
	private static <T> boolean checkNull(
			@SuppressWarnings("unchecked") T... values) {
		if (values == null) {
			return true;
		} else {
			for (T value : values) {
				if (value == null) {
					return true;
				}
			}
			return false;
		}
	}
	
	public static boolean isPositiveDecimalNumber(String... values) {

		if (checkNull(values)) {
			return false;
		}

		for (String value : values) {
			if (!value.matches(positiveDecimalNumberRegEx)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isCorrectLogin(String login) {
		if (!login.matches(loginRegex)) {
			return false;
		}
		return true;
	}
}
