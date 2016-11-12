package ua.nure.osmachko.summarytask4.dao;

import java.util.List;

import ua.nure.osmachko.summarytask4.core.entity.Subject;

/**
 * interface of DAOFacultySubjects.
 * @author Valerii Osmachko
 *
 */
public interface DAOFacultySubjects {

	/**
	 * Finds subject of faculty,
	 * @param facultyId
	 * @return
	 */
	List<Subject> findSubjectsByFacultyId(Integer facultyId);
	
	/**
	 * Insert subject into Faculty.
	 * @param facultyId
	 * @param subjectId
	 * @return
	 */
	boolean insertSubjectsToFaculty(Integer facultyId,Integer subjectId);
}
