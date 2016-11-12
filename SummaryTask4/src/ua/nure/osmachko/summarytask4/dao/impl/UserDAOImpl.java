package ua.nure.osmachko.summarytask4.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.core.entity.User;
import ua.nure.osmachko.summarytask4.dao.ConnectionPool;
import ua.nure.osmachko.summarytask4.dao.Query;
import ua.nure.osmachko.summarytask4.dao.UserDAO;

/**
 * @author Valerii Osmachko
 *
 */
public class UserDAOImpl implements UserDAO {
	
	Connection connection;

	final static Logger logger = Logger.getLogger(UserDAOImpl.class);

	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.dao.UserDAO#insertUser(ua.nure.osmachko.summarytask4.core.entity.User)
	 */
	@Override
	public User insertUser(User user) {
		connection = ConnectionPool.getConnection();
		try (PreparedStatement pstmt = connection.prepareStatement(Query.INSERT_USER)) {
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getLogin());
			pstmt.setString(6, user.getRole());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			logger.error("Can't insert user", e);
		} finally {
			closeConnection();
		}
		return user;
	}

	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.dao.UserDAO#deleteUser(java.lang.Integer)
	 */
	@Override
	public boolean deleteUser(Integer userId) {
		connection = ConnectionPool.getConnection();
		try (PreparedStatement pstmt = connection.prepareStatement(Query.DELETE_USER)) {
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			logger.error("Can't delete user", e);
		} finally {
			closeConnection();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.dao.UserDAO#updateUser(java.lang.Integer, ua.nure.osmachko.summarytask4.core.entity.User)
	 */
	@Override
	public boolean updateUser(Integer userId, User user) {
		connection = ConnectionPool.getConnection();
		try (PreparedStatement pstmt = connection.prepareStatement(Query.UPDATE_USER)) {
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getLogin());
			pstmt.setString(6, user.getRole());
			pstmt.setInt(7, userId);
		} catch (SQLException e) {
			logger.error("Can't update user", e);
		} finally {
			closeConnection();
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.dao.UserDAO#getUserById(java.lang.Integer)
	 */
	@Override
	public User getUserById(Integer userId) {
		User us = null;
		connection = ConnectionPool.getConnection();
		try (PreparedStatement pstmt = connection.prepareStatement(Query.SELECT_USER_BY_ID)) {
			pstmt.setInt(1, userId);
			pstmt.execute();
			ResultSet rs = pstmt.getResultSet();
			while (rs.next()) {
				us = new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("login"),
						rs.getString("first_name"), rs.getString("last_name"), rs.getString("role"));
			}
		} catch (SQLException e) {
			logger.error("Can't find user by id", e);
		} finally {
			closeConnection();
		}
		return us;
	}

	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.dao.UserDAO#getUserByEmail(java.lang.String)
	 */
	@Override
	public User getUserByEmail(String email) {
		User us = null;
		connection = ConnectionPool.getConnection();
		try (PreparedStatement pstmt = connection.prepareStatement(Query.SELECT_USER_BY_EMAIL)) {
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery(Query.SELECT_USER_BY_EMAIL);
			us = new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("login"),
					rs.getString("first_name"), rs.getString("last_name"), rs.getString("role"));
		} catch (SQLException e) {
			logger.error("Can't find user by email", e);
		} finally {
			closeConnection();
		}
		return us;
	}

	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.dao.UserDAO#getUsersByRole(java.lang.String)
	 */
	@Override
	public List<User> getUsersByRole(String userRole) {
		List<User> users = new ArrayList<User>();
		connection = ConnectionPool.getConnection();
		try (PreparedStatement pstmt = connection.prepareStatement(Query.SELECT_USER_BY_ROLE)) {
			pstmt.setString(1, userRole);
			ResultSet rs = pstmt.executeQuery(Query.SELECT_USER_BY_ROLE);
			while (rs.next()) {
				users.add(new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"),
						rs.getString("login"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("role")));
			}
		} catch (SQLException e) {
			logger.error("Can't find user by role", e);
		} finally {
			closeConnection();
		}

		return users;
	}

	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.dao.UserDAO#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		connection = ConnectionPool.getConnection();
		try (Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(Query.SELECT_ALL_USERS)) {
			while (rs.next()) {
				users.add(new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"),
						rs.getString("login"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("role")));

			}
		} catch (SQLException e) {
			logger.error("Can't get all users", e);
		} finally {
			closeConnection();
		}

		return users;
	}

	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.dao.UserDAO#getUserByFistName(java.lang.String)
	 */
	@Override
	public User getUserByFistName(String firstname) {
		User us = null;
		connection = ConnectionPool.getConnection();
		try (PreparedStatement pstmt = connection.prepareStatement(Query.SELECT_USER_BY_FIRSTNAME)) {
			pstmt.setString(1, firstname);
			ResultSet rs = pstmt.executeQuery(Query.SELECT_USER_BY_FIRSTNAME);
			us = new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("login"),
					rs.getString("first_name"), rs.getString("last_name"), rs.getString("role"));
		} catch (SQLException e) {
			logger.error("Can't find user by first name", e);
		} finally {
			closeConnection();
		}
		return us;
	}

	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.dao.UserDAO#getUserByLastName(java.lang.String)
	 */
	@Override
	public User getUserByLastName(String lastName) {
		User us = null;
		connection = ConnectionPool.getConnection();
		try (PreparedStatement pstmt = connection.prepareStatement(Query.SELECT_USER_BY_LASTNAME)) {
			pstmt.setString(1, lastName);
			ResultSet rs = pstmt.executeQuery(Query.SELECT_USER_BY_LASTNAME);
			us = new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("login"),
					rs.getString("first_name"), rs.getString("last_name"), rs.getString("role"));
		} catch (SQLException e) {
			logger.error("Can't find user by last name", e);
		} finally {
			closeConnection();
		}
		return us;
	}

	/**
	 * Close connection.
	 */
	private void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.dao.UserDAO#getUserByLogin(java.lang.String)
	 */
	@Override
	public User getUserByLogin(String login) {
		User user = null;
		connection = ConnectionPool.getConnection();
		try (PreparedStatement pstmt = connection.prepareStatement(Query.SELECT_USER_BY_LOGIN)) {
			pstmt.setString(1, login);
			pstmt.execute();
			ResultSet rs = pstmt.getResultSet();
			if (rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("login"),
						rs.getString("first_name"), rs.getString("last_name"), rs.getString("role"));
			}
			rs.close();
		} catch (SQLException e) {
			logger.error("Can't find user by login", e);
		} finally {
			closeConnection();
		}
		return user;
	}

	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.dao.UserDAO#getEmailById(java.lang.Integer)
	 */
	@Override
	public String getEmailById(Integer id) {
		String email = null;
		connection = ConnectionPool.getConnection();
		try (PreparedStatement pstmt = connection.prepareStatement("select email from Users where id = ?;")) {
			pstmt.setInt(1, id);
			pstmt.execute();
			ResultSet rs = pstmt.getResultSet();
			if (rs.next()) {
				email = rs.getString("email");
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			logger.error("Can't find user by login", e);
		} finally {
			closeConnection();
		}
		return email;
	}

	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.dao.UserDAO#getFirstNameById(java.lang.Integer)
	 */
	@Override
	public String getFirstNameById(Integer id) {
		String firstName = null;
		connection = ConnectionPool.getConnection();
		try (PreparedStatement pstmt = connection.prepareStatement("select first_name from Users where id = ?;")) {
			pstmt.setInt(1, id);
			pstmt.execute();
			ResultSet rs = pstmt.getResultSet();
			if (rs.next()) {
				firstName = rs.getString("first_name");
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			logger.error("Can't find user by login", e);
		} finally {
			closeConnection();
		}
		return firstName;
	}

	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.dao.UserDAO#getLastNameById(java.lang.Integer)
	 */
	@Override
	public String getLastNameById(Integer id) {
		String lastName = null;
		connection = ConnectionPool.getConnection();
		try (PreparedStatement pstmt = connection.prepareStatement("select last_name from Users where id = ?;")) {
			pstmt.setInt(1, id);
			pstmt.execute();
			ResultSet rs = pstmt.getResultSet();
			if (rs.next()) {
				lastName = rs.getString("last_name");
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			logger.error("Can't find user by login", e);
		} finally {
			closeConnection();
		}
		return lastName;
	}

	
	
}
