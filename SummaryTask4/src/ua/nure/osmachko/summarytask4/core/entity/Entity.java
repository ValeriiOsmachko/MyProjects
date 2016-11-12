package ua.nure.osmachko.summarytask4.core.entity;

import java.io.Serializable;

/**
 * Class of Entity.
 * @author Valerii Osmachko
 *
 */
public abstract class Entity implements Serializable{

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 1369008817919379847L;
	/**
	 * Field id.
	 */
	private int id;

	/**
	 * Getter for id.
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for id.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
}
