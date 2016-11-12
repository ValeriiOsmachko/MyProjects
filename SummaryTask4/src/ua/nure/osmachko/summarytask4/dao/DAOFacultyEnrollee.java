package ua.nure.osmachko.summarytask4.dao;

import java.io.InputStream;
import java.util.List;

import ua.nure.osmachko.summarytask4.core.entity.FacultyEnrollee;

public interface DAOFacultyEnrollee {

	/**
	 * Insert FacultyEnrollee.
	 * @param fe
	 * @return
	 */
	boolean insertFacultyEnrollee(FacultyEnrollee fe);
	
	/**
	 * Checks the availability
	 * of registrated enrollees
	 * on faculty.
	 * @param facultyID
	 * @return
	 */
	boolean isEmptyFaculty(Integer facultyID);
	
	/**
	 * Gets all FacultyEnrollees.
	 * @return
	 */
	List<FacultyEnrollee> getAllFacultyEnrollee();
	
	/**
	 * Insert FacultyEnrollee with scan.
	 * @param fe
	 * @param is
	 * @return
	 */
	boolean insertFacultyEnrolleeWithScan(FacultyEnrollee fe, InputStream is);
}
