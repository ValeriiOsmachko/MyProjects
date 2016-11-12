package ua.nure.osmachko.summarytask4.core.entity;

/**
 * The bean for mark entity.
 * contains mark, id of the subject 
 * and id of the enrollee.
 * @author Valerii Osmachko
 *
 */
public class Mark extends Entity {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -5540163528132566353L;

	
	/**
	 * mark.
	 */
	private int mark;
	/**
	 * subject id.
	 */
	private int subjectId;
	/**
	 * EnrolleeId.
	 */
	private int enrolleeId;
	
	public Mark() {
		
	}

	/**
	 * Constructor.
	 * @param mark
	 * @param subjectId
	 * @param enrolleeId
	 */
	public Mark(int mark, int subjectId, int enrolleeId) {
		super();
		this.mark = mark;
		this.subjectId = subjectId;
		this.enrolleeId = enrolleeId;
	}

	/**
	 * Getting Mark.
	 * @return int
	 */
	public int getMark() {
		return mark;
	}

	/**
	 * Setting mark.
	 * @param mark
	 */
	public void setMark(int mark) {
		this.mark = mark;
	}

	/**
	 * Getting subject id.
	 * @return int
	 */
	public int getSubjectId() {
		return subjectId;
	}

	/**
	 * Setting subject id.
	 * @param subjectId
	 */
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	/**
	 * Getting id of the enrollee.
	 * @return int
	 */
	public int getEnrolleeId() {
		return enrolleeId;
	}

	/**
	 * Setting id of the enrollee.
	 * @param enrolleeId
	 */
	public void setEnrolleeId(int enrolleeId) {
		this.enrolleeId = enrolleeId;
	}
	
	
}
