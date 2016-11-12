package ua.nure.osmachko.summarytask4.dao.impl;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

import ua.nure.osmachko.summarytask4.core.entity.User;
import ua.nure.osmachko.summarytask4.dao.ConnectionPool;
import ua.nure.osmachko.summarytask4.dao.UserDAO;

public class UserDAOImplTest {
	
	private static UserDAO userDAO = null;
	private static User testUser = null;

	@BeforeClass
	public static void beforeClass() {
		userDAO = new UserDAOImpl();
		testUser = new User("v_osmachko@mail.ru","abc","abc","Valeron","Valeron","client");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
			dataSource.setURL("jdbc:mysql://localhost:3306/st4db");
			dataSource.setUser("root");
			dataSource.setPassword("root");
			new ConnectionPool(dataSource);
		}catch(ClassNotFoundException ex) {
			System.out.println("Cannot get DataSource without JNDI");
		}
	}
	
	@Test
	public void testGetAllUsers() {
		Assert.assertNotNull(userDAO.getAllUsers());
	}

	@Test
	public void testInsertUser() {
		Assert.assertNotNull(userDAO.insertUser(testUser));
	}
	
	@Test
	public void testDeleteUser() {
		Assert.assertFalse(userDAO.deleteUser(testUser.getId()));
	}
	
	
	@Test
	public void testGetFirstNameById() {
		userDAO.insertUser(testUser);
		userDAO.getFirstNameById(testUser.getId());
	}
	
	
	@Test
	public void testGetLastNameById() {
		userDAO.insertUser(testUser);
		Assert.assertNull(userDAO.getLastNameById(testUser.getId()));
	}
	
	
	@Test
	public void testGetEmailById() {
		userDAO.insertUser(testUser);
		Assert.assertNull(userDAO.getEmailById(testUser.getId()));
	}
	
	
	@Test
	public void testGetuserById() {
		userDAO.insertUser(testUser);
		Assert.assertNull(userDAO.getUserById(testUser.getId()));
	}
	
	
}
