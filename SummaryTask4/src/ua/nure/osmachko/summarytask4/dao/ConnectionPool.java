package ua.nure.osmachko.summarytask4.dao;

import java.sql.Connection;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * This class has connection pool.
 * @author Valerii Osmachko
 *
 */
public class ConnectionPool {

	
	/**
	 * DataSource field.
	 */
	private static DataSource dataSource;
	
	
	/**
	 * Constructor for JUnit tests.
	 * @param dataSource
	 */
	public ConnectionPool(DataSource dataSource) {
		ConnectionPool.dataSource = dataSource;
	}
	
	/**
	 * Get free connection from pool.
	 * 
	 * @return connection.
	 */
	public static synchronized Connection getConnection() {
		if (dataSource == null) {
			try {
				Context initContext = new InitialContext();
				Context envContext = (Context) initContext.lookup("java:/comp/env");
				dataSource = (DataSource) envContext.lookup("jdbc/st4db");
			} catch (NamingException e) {
				System.out.println("Cannot find the data source");
			}
		}

		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			System.out.println("Cannot establish connection");
			return null;
		}
	}
}
