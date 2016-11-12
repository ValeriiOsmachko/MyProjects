package ua.nure.osmachko.summarytask4.web.utils;

public class NewFacultyValidation {

	
	public static boolean isValidNewFaculty(String nameOfFaculty, String totalSeats, String budgetSeats) {
		return (validateNameOfFaculty(nameOfFaculty) && validateTotalSeats(totalSeats) && validateBudgetSeats(budgetSeats));
	}

	private static boolean validateBudgetSeats(String budgetSeats) {
		if(budgetSeats == null) {
			return false;
		}
		if(!budgetSeats.matches("(?<=\\s|^)\\d+(?=\\s|$)")){
			return false;
		}
		
		return true;
	}

	private static boolean validateTotalSeats(String totalSeats) {
		if(totalSeats == null) {
			return false;
		}
		if(!totalSeats.matches("(?<=\\s|^)\\d+(?=\\s|$)")){
			return false;
		}
		
		return true;
	}

	private static boolean validateNameOfFaculty(String nameOfFaculty) {
		if(nameOfFaculty == null) {
			return false;
		}
		if(!nameOfFaculty.matches("^([a-zA-Z\u0080-\u024F]+(?:. |-| |'))*[a-zA-Z\u0080-\u024F]*$")){
			return false;
		}
		return true;
	}
}
