package ua.nure.osmachko.summarytask4.dao;

import java.util.List;

import ua.nure.osmachko.summarytask4.core.entity.Faculty;

/**
 * interface of FacultyDAO.
 * @author Valerii Osmachko
 *
 */
public interface FacultyDAO {

	/**
	 * Inserting new Faculty.
	 * @param faculty
	 * @return
	 */
	Faculty insertFaculty(Faculty faculty);
	
	/**
	 * Deleting Faculty.
	 * @param facultyId
	 * @return
	 */
	boolean deleteFaculty(Integer facultyId);
	
	/**
	 * Updating Faculty.
	 * @param facultyId
	 * @param faculty
	 * @return
	 */
	boolean updateFaculty(Integer facultyId, Faculty faculty);
	
	/**
	 * Getting faculty by id.
	 * @param facultyId
	 * @return
	 */
	Faculty getFacultyById(Integer facultyId);
	
	/**
	 * Getting Faculty by name of Faculty.
	 * @param nameOfFaculty
	 * @return
	 */
	Faculty getFacultyByNameOfFaculty(String nameOfFaculty);
	
	/**
	 * Getting faculty by number of budget seats.
	 * @param budgetSeats
	 * @return
	 */
	List<Faculty> getFacultyByNumberOfBudgetSeats(Integer budgetSeats);
	
	/**
	 * Getting faculty by number of total seats.
	 * @param totalSeats
	 * @return
	 */
	List<Faculty> getFacultyByNumberOfTotalSeats(Integer totalSeats);
	
	/**
	 * Getting list fo all Faculties.
	 * @return
	 * 
	 */
	List<Faculty> getAllFaculty();
	
	/**
	 * Updating Faculty.
	 * @param faculty
	 * @return
	 */
	boolean updateFaculty(Faculty faculty);
	
	/**
	 * Deleting faculty.
	 * @param faculty
	 * @return
	 */
	boolean deleteFaculty(Faculty faculty);
	
	/**
	 * Getting number of budget seats.
	 * @param idFaculty
	 * @return
	 */
	Integer getNumberOfBudgetSeats(Integer idFaculty);
	
	/**
	 * Getting name of faculty by id.
	 * @param idFaculty
	 * @return
	 */
	String getNameOfFacultyById(Integer idFaculty);
	
	
}


