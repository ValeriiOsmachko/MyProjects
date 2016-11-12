package ua.nure.osmachko.summarytask4.core.entity;

/**
 * The entity of user, 
 * @author Valerii Osmachko
 *
 */
public class User extends Entity {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -4296812728878771179L;
	
	
	/**
	 * id user.
	 */
	private int id;
	/**
	 * email of user.
	 */
	private String email;
	/**
	 * password of user.
	 */
	private String password;
	/**
	 * Login 
	 */
	private String login;
	/**
	 * First name.
	 */
	private String firstName;
	/**
	 * last name.
	 */
	private String  lastName;
	/**
	 * role of user.
	 */
	private String role;
	
	public User(){
		
	}
	
	

	/**
	 * Constructor for user.
	 * @param id
	 * @param email
	 * @param password
	 * @param login
	 * @param firstName
	 * @param lastName
	 * @param role
	 */
	public User(int id,String email, String password,String login, String firstName, String lastName, String role) {
		super();
		this.setId(id);
		this.email = email;
		this.password = password;
		this.login = login;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	/**
	 * Constructor for user.
	 * @param email
	 * @param password
	 * @param login
	 * @param firstName
	 * @param lastName
	 * @param role
	 */
	public User(String email, String password,String login, String firstName, String lastName, String role) {
		super();
		this.email = email;
		this.password = password;
		this.login = login;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	/**
	 * Getter for email.
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter for email.
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter for password.
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter for password.
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter for first Name.
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter for first name.
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**Getter for last name.
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter for last name.
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter for role.
	 * @return
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Setter for role.
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}



	/**
	 * getter for login.
	 * @return
	 */
	public String getLogin() {
		return login;
	}



	/**Setter for login.
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
	}



	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.core.entity.Entity#getId()
	 */
	public int getId() {
		return id;
	}



	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.core.entity.Entity#setId(int)
	 */
	public void setId(int id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", login=" + login + ", firstName="
				+ firstName + ", lastName=" + lastName + ", role=" + role + "]";
	}

	
	
	
	
}
