package ua.nure.osmachko.summarytask4.dao;

/**
 * @author Valerii Osmachko
 *
 */
public interface SubjectDAO {

	
	/**
	 * Finds id of Subject by name of subject.
	 * @param nameOfSubject
	 * @return
	 */
	Integer findIdSubjectByNameOfSubject(String nameOfSubject);
}
