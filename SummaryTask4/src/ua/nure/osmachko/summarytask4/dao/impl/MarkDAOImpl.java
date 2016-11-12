package ua.nure.osmachko.summarytask4.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.type.PrimitiveType;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.core.entity.Mark;
import ua.nure.osmachko.summarytask4.dao.ConnectionPool;
import ua.nure.osmachko.summarytask4.dao.MarkDAO;
import ua.nure.osmachko.summarytask4.dao.Query;

/**
 * @author Valerii Osmachko
 *
 */
public class MarkDAOImpl implements MarkDAO {
	
	
	Connection connection;
	private static final Logger LOGGER = Logger.getLogger(MarkDAOImpl.class);

	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.dao.MarkDAO#getAllMarks()
	 */
	@Override
	public List<Mark> getAllMarks() {
		List<Mark> marks = new ArrayList<Mark>();
		connection = ConnectionPool.getConnection();
		try (Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(Query.SELECT_ALL_MARKS)) {
			while (rs.next()) {
				marks.add(unmarshal(rs));
			}
		} catch (SQLException e) {
			LOGGER.error("Can't get all marks", e);
		} finally {
			closeConnection();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.dao.MarkDAO#findMarkById(java.lang.Integer)
	 */
	@Override
	public Mark findMarkById(Integer idMark) {
		Mark mark = null;
		connection = ConnectionPool.getConnection();
		try (PreparedStatement pstmt = connection.prepareStatement(Query.SELECT_MARK_BY_ID)) {
			pstmt.setInt(1, idMark);
			ResultSet rs = pstmt.executeQuery(Query.SELECT_MARK_BY_ID);
			mark = unmarshal(rs);
		} catch (SQLException e) {
			LOGGER.error("Can't find mark by id", e);
		} finally {
			closeConnection();
		}
		return mark;
	}

	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.dao.MarkDAO#insertMark(ua.nure.osmachko.summarytask4.core.entity.Mark)
	 */
	@Override
	public boolean insertMark(Mark mark) {
		connection = ConnectionPool.getConnection();
		try (PreparedStatement pstmt = connection.prepareStatement(Query.INSERT_MARK)) {
			pstmt.setInt(1, mark.getMark());
			pstmt.setInt(2, mark.getSubjectId());
			pstmt.setInt(3, mark.getEnrolleeId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error("Can't insert mark");
		} finally {
			closeConnection();
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.dao.MarkDAO#updateMark(java.lang.Integer, ua.nure.osmachko.summarytask4.core.entity.Mark)
	 */
	@Override
	public boolean updateMark(Integer idMark, Mark mark) {
		connection = ConnectionPool.getConnection();
		try (PreparedStatement pstmt = connection.prepareStatement(Query.UPDATE_MARK)) {
			pstmt.setInt(1, mark.getMark());
			pstmt.setInt(2, mark.getSubjectId());
			pstmt.setInt(3, mark.getEnrolleeId());
			pstmt.setInt(4, idMark);
		} catch (SQLException e) {
			LOGGER.error("Can't update mark");
		} finally {
			closeConnection();
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.dao.MarkDAO#deleteMark(java.lang.Integer)
	 */
	@Override
	public boolean deleteMark(Integer idMark) {
		connection = ConnectionPool.getConnection();
		try (PreparedStatement pstmt = connection.prepareStatement(Query.DELETE_MARK)) {
			pstmt.setInt(1, idMark);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error("Can't delete mark", e);
		} finally {
			closeConnection();
		}
		return true;
	}

	/**
	 * @param rs
	 * @return
	 */
	private static Mark unmarshal(ResultSet rs) {
		Mark mark = new Mark();
		try {
			mark.setMark(rs.getInt("mark"));
			mark.setSubjectId(rs.getInt("Subject_idSubject"));
			mark.setEnrolleeId(rs.getInt("Enrollee_idEnrollee"));
		} catch (SQLException e) {
			LOGGER.error("Can't unmarshal Mark", e);
		}
		return mark;
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
