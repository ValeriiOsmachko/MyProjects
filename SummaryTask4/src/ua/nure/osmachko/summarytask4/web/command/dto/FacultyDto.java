package ua.nure.osmachko.summarytask4.web.command.dto;

/**
 * Bean for Faculty DTO.
 * @author Valerii Osmachko
 *
 */
public class FacultyDto {
	
	private int id;
	private String nameOfFaculty;
	private int budgetSeats;
	private int totalSeats;
	private boolean isEmtpy;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameOfFaculty() {
		return nameOfFaculty;
	}
	public void setNameOfFaculty(String nameOfFaculty) {
		this.nameOfFaculty = nameOfFaculty;
	}
	public int getBudgetSeats() {
		return budgetSeats;
	}
	public void setBudgetSeats(int budgetSeats) {
		this.budgetSeats = budgetSeats;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public boolean isEmtpy() {
		return isEmtpy;
	}
	public void setEmtpy(boolean isEmtpy) {
		this.isEmtpy = isEmtpy;
	}
	@Override
	public String toString() {
		return "FacultyDto [id=" + id + ", nameOfFaculty=" + nameOfFaculty + ", budgetSeats=" + budgetSeats
				+ ", totalSeats=" + totalSeats + ", isEmtpy=" + isEmtpy + "]";
	}
	
	
}
