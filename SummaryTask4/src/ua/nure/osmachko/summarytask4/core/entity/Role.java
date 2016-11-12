package ua.nure.osmachko.summarytask4.core.entity;

/**
 * User role type.
 * @author Valerii Osmachko
 *
 */
public enum Role {
	
	ADMIN,CLIENT;
	
	/**
	 * getter for enum.
	 * @return
	 */
	public String getName(){
		return name().toLowerCase();
	}

}
