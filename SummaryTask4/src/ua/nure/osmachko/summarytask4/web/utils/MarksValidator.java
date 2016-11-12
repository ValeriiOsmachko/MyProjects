package ua.nure.osmachko.summarytask4.web.utils;

public class MarksValidator {

	public static boolean isValidmarks(String firstMark, String secondMark, String thirdMark) {
		return (validateFirstmark(firstMark) && validateSecondmark(secondMark) &&
				validateThirdmark(thirdMark));
	}

	private static boolean validateThirdmark(String thirdMark) {
		if(thirdMark == null) {
			return false;
		}
		if(!thirdMark.matches("(?<=\\s|^)\\d+(?=\\s|$)")){
			return false;
		}
		Integer a = Integer.parseInt(thirdMark);
		if(!(100<=a && a<=200)) {
			return false;
		}
		return true;
	}

	private static boolean validateFirstmark(String firstMark) {
		if(firstMark == null) {
			return false;
		}
		if(!firstMark.matches("(?<=\\s|^)\\d+(?=\\s|$)")){
			return false;
		}
		Integer a = Integer.parseInt(firstMark);
		if(!(100<=a && a<=200)) {
			return false;
		}
		return true;
	}

	private static boolean validateSecondmark(String secondMark) {
		if(secondMark == null) {
			return false;
		}
		if(!secondMark.matches("(?<=\\s|^)\\d+(?=\\s|$)")){
			return false;
		}
		Integer a = Integer.parseInt(secondMark);
		if(!(100<=a && a<=200)) {
			return false;
		}
		return true;
	}
}
