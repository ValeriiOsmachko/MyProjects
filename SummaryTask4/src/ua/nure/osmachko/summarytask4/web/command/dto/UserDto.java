package ua.nure.osmachko.summarytask4.web.command.dto;

public class UserDto {

	
	private int id;
	private String email;
	private String password;
	private String login;
	private String firstName;
	private String  lastName;
	private String role;
	private boolean isBlocked;
	private boolean isEnrolleeExist;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isBlocked() {
		return isBlocked;
	}
	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
		
		
		
	}
	public boolean isEnrolleeExist() {
		return isEnrolleeExist;
	}
	public void setEnrolleeExist(boolean isEnrolleeExist) {
		this.isEnrolleeExist = isEnrolleeExist;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", email=" + email + ", password=" + password + ", login=" + login + ", firstName="
				+ firstName + ", lastName=" + lastName + ", role=" + role + ", isBlocked=" + isBlocked + "]";
	}
	
	
	
}
