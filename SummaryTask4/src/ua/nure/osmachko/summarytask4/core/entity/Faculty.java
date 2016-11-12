package ua.nure.osmachko.summarytask4.core.entity;

/**
 * This class is the bean for the 
 * entity of faculty.
 * @author Valerii Osmachko
 *
 */
public class Faculty extends Entity {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -4086480183665579660L;

	/**
	 * Field id.
	 */
	private int id;
	/**
	 * Field name of faculty.
	 */
	private String nameOfFaculty;
	/**
	 * Field budget Seats.
	 */
	private int budgetSeats;
	/**
	 * Field total Seats.
	 */
	private int totalSeats;

	/**
	 * Public constructor for bean of Faculty.
	 * 
	 * @param nameOfFaculty
	 * @param budgetSeats
	 * @param totalSeats
	 */
	public Faculty(String nameOfFaculty, int budgetSeats, int totalSeats) {
		this.nameOfFaculty = nameOfFaculty;
		this.budgetSeats = budgetSeats;
		this.totalSeats = totalSeats;
	}

	/**
	 * Public constructor for getting Enrollee from database.
	 * 
	 * @param id
	 * @param nameOfFaculty
	 * @param budgetSeats
	 * @param totalSeats
	 */
	public Faculty(int id, String nameOfFaculty, int budgetSeats, int totalSeats) {
		this.setId(id);
		this.nameOfFaculty = nameOfFaculty;
		this.budgetSeats = budgetSeats;
		this.totalSeats = totalSeats;
	}

	/**
	 * Getter for the name of faculty.
	 * 
	 * @return String
	 */
	public String getNameOfFaculty() {
		return nameOfFaculty;
	}

	/**
	 * Setter for the name of faculty.
	 * 
	 * @param nameOfFaculty
	 */
	public void setNameOfFaculty(String nameOfFaculty) {
		this.nameOfFaculty = nameOfFaculty;
	}

	/**
	 * Getter for budget places.
	 * 
	 * @return int
	 */
	public int getBudgetSeats() {
		return budgetSeats;
	}

	/**
	 * Setter for the number of budget places.
	 * 
	 * @param budgetSeats
	 */
	public void setBudgetSeats(int budgetSeats) {
		this.budgetSeats = budgetSeats;
	}

	/**
	 * Getter for number of total places on the faculty.
	 * 
	 * @return int
	 */
	public int getTotalSeats() {
		return totalSeats;
	}

	/**
	 * Setter for the number of total places.
	 * 
	 * @param totalSeats
	 */
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.osmachko.summarytask4.core.entity.Entity#getId()
	 */
	public int getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.osmachko.summarytask4.core.entity.Entity#setId(int)
	 */
	public void setId(int id) {
		this.id = id;
	}
	
}
