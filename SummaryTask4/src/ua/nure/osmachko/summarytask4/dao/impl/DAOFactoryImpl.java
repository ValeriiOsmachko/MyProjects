package ua.nure.osmachko.summarytask4.dao.impl;

import ua.nure.osmachko.summarytask4.dao.DAOFactory;
import ua.nure.osmachko.summarytask4.dao.DAOFacultyEnrollee;
import ua.nure.osmachko.summarytask4.dao.DAOFacultySubjects;
import ua.nure.osmachko.summarytask4.dao.EnrolleeDAO;
import ua.nure.osmachko.summarytask4.dao.FacultyDAO;
import ua.nure.osmachko.summarytask4.dao.MarkDAO;
import ua.nure.osmachko.summarytask4.dao.SubjectDAO;
import ua.nure.osmachko.summarytask4.dao.UserDAO;

/**
 * @author Valerii Osmachko
 *
 */
public class DAOFactoryImpl extends DAOFactory {

	@Override
	public EnrolleeDAO getEnrolleeDAO() {
		return new EnrolleeDAOImpl();
	}

	@Override
	public FacultyDAO getFacultyDAO() {
		return new FacultyDAOImpl();
	}

	@Override
	public UserDAO getUserDAO() {
		return new UserDAOImpl();
	}

	@Override
	public MarkDAO getMarkDAO() {
		return new MarkDAOImpl();
	}

	@Override
	public DAOFacultySubjects getDAOFacultySubjects() {
		return new DAOFacultySubjectsImpl();
	}

	@Override
	public SubjectDAO getSubjectDAO() {
		return new SubjectDAOImpl();
	}

	@Override
	public DAOFacultyEnrollee getDAOFacultyEnrollee() {
		return new DAOFacultyEnrolleeImpl();
	}

}
