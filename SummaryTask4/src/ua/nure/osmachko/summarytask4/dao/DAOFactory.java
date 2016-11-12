package ua.nure.osmachko.summarytask4.dao;

/**
 * DAOFactory.
 * @author Valerii Osmachko
 *
 */
public abstract class DAOFactory {

	
	/**
	 * Method, which returns EnrolleeDAOImlp object.
	 * @return EnrolleeDAO
	 */
	public abstract EnrolleeDAO getEnrolleeDAO();
	
	/**
	 * Method, which returns FacultyDAOImlp object.
	 * @return FacultyDAO
	 */
	public abstract FacultyDAO getFacultyDAO();
	
	/**
	 * Method, which returns UserDAOImlp object.
	 * @return UserDAO
	 */
	public abstract UserDAO getUserDAO();
	
	/**
	 * Method, which returns MarkDAOImlp object.
	 * @return MarkDAO
	 */
	public abstract MarkDAO getMarkDAO();
	
	/**
	 * Method, which returns DAOFacultySubjectsImlp object.
	 * @return DAOFacultySubjects
	 */
	public abstract DAOFacultySubjects getDAOFacultySubjects();
	
	/**
	 * Method, which returns SubjectDAOImlp object.
	 * @return SubjectDAO
	 */
	public abstract SubjectDAO getSubjectDAO();
	
	/**
	 * Method, which returns DAOFacultyEnrolleeImlp object.
	 * @return DAOFacultyEnrollee
	 */
	public abstract DAOFacultyEnrollee getDAOFacultyEnrollee();
}
