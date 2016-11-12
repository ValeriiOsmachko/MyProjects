package ua.nure.osmachko.summarytask4.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.dao.ConnectionPool;
import ua.nure.osmachko.summarytask4.dao.SubjectDAO;

/**
 * @author Valerii Osmachko
 *
 */
public class SubjectDAOImpl implements SubjectDAO {

	Connection connection;

	private static final Logger LOGGER = Logger.getLogger(SubjectDAOImpl.class);

	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.dao.SubjectDAO#findIdSubjectByNameOfSubject(java.lang.String)
	 */
	@Override
	public Integer findIdSubjectByNameOfSubject(String nameOfSubject) {
		LOGGER.trace("finding id subject");
		Integer id = 0;
		connection = ConnectionPool.getConnection();
		try (PreparedStatement pstmt = connection.prepareStatement("select id from Subject where nameOfSubject = ?;")) {
			pstmt.setString(1, nameOfSubject);
			pstmt.execute();
			ResultSet rs = pstmt.getResultSet();
			while (rs.next()) {
				id = rs.getInt("id");
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			closeConnection();
		}
		return id;
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
}
