package ua.nure.osmachko.summarytask4.core.entity;

/**
 * The bean for the subject, which student have to 
 * pass.
 * @author Valerii Osmachko
 *
 */
public class Subject extends Entity{

	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1834683719186355656L;

	/**
	 * id of subject.
	 */
	private int id;
	/**
	 * name of subject.
	 */
	private String nameOfSubject;

	/**
	 * Constructor.
	 * 
	 * @param nameOfSubject
	 */
	public Subject(String nameOfSubject) {
		this.nameOfSubject = nameOfSubject;
	}

	/**
	 * Getter for the name of subject.
	 * 
	 * @return String
	 */
	public String getNameOfSubject() {
		return nameOfSubject;
	}

	/**
	 * Setter for the name of subject.
	 * 
	 * @param nameOfSubject
	 */
	public void setNameOfSubject(String nameOfSubject) {
		this.nameOfSubject = nameOfSubject;
	}

	@Override
	public String toString() {
		return "Subject [nameOfSubject=" + nameOfSubject + "]";
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
