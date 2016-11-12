package ua.nure.osmachko.summarytask4.dao;

import java.util.List;

import ua.nure.osmachko.summarytask4.core.entity.User;

/**
 * interface UserDAO.
 * @author Valerii Osmachko
 *
 */
public interface UserDAO {
	
	/**
	 * Inserting User into database.
	 * @param user
	 * @return
	 */
	User insertUser(User user);
	
	/**
	 * Deleting user.
	 * @param userId
	 * @return
	 */
	boolean deleteUser(Integer userId);
	
	/**
	 * Updating user.
	 * @param userId
	 * @param user
	 * @return
	 */
	boolean updateUser(Integer  userId, User user);
	
	/**
	 * Getting User by id.
	 * @param userId
	 * @return
	 */
	User getUserById(Integer userId);
	
	/**
	 * Getting user by email.
	 * @param email
	 * @return
	 */
	User getUserByEmail(String email);
	
	/**
	 * Getting User by role.
	 * @param userRole
	 * @return
	 */
	List<User> getUsersByRole(String userRole);
	
	/**
	 * Getting All users.
	 * @return
	 */
	List<User> getAllUsers(); 
	
	/**
	 * Getting User by first name.
	 * @param firstname
	 * @return
	 */
	User getUserByFistName(String firstname);
	
	/**
	 * Getting user by last name.
	 * @param lastName
	 * @return
	 */
	User getUserByLastName(String lastName);
	
	/**
	 * getting user by login.
	 * @param login
	 * @return
	 */
	User getUserByLogin(String login);
	
	/**
	 * Getting email by id.
	 * @param id
	 * @return
	 */
	String getEmailById(Integer id);
	
	/**
	 * Getting first name by id.
	 * @param id
	 * @return
	 */
	String getFirstNameById(Integer id);
	
	/**
	 * Getting first name by id.
	 * @param id
	 * @return
	 */
	String getLastNameById(Integer id);
	
	
	
}
