package ua.nure.osmachko.summarytask4.core.entity;

/**
 * Faculty subjects entity. The main purpose is to tell
 * what subjects are need to the Enrollee.
 * @author Valerii Osmachko 
 *
 */
public class FacultySubjects extends Entity {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -7922018570068748685L;

	/**
	 * id of subject.
	 */
	private int subjectId;
	/**
	 * id of faculty.
	 */
	private int facultyId;

	/**
	 * Constructor.
	 * @param subject
	 * @param faculty
	 */
	public FacultySubjects(Subject subject, Faculty faculty) {
		this(subject.getId(), faculty.getId());
	}

	/**
	 * Empty constructor.
	 */
	public FacultySubjects() {

	}

	/**
	 * Constructor.
	 * @param subjectId
	 * @param facultyId
	 */
	public FacultySubjects(int subjectId, int facultyId) {
		super();
		this.subjectId = subjectId;
		this.facultyId = facultyId;
	}

	/**
	 * Getter for subjcetID.
	 * @return
	 */
	public int getSubjectId() {
		return subjectId;
	}

	/**
	 * Setter for subjectId.
	 * @param subjectId
	 */
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	/**Getter for facultyId.
	 * @return
	 */
	public int getFacultyId() {
		return facultyId;
	}

	/**
	 * Setter for FacultyId.
	 * @param facultyId
	 */
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	
	
}
