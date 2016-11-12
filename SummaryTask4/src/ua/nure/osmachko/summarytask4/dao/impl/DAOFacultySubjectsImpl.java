package ua.nure.osmachko.summarytask4.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sun.crypto.provider.RSACipher;
import com.sun.org.apache.bcel.internal.generic.CPInstruction;

import ua.nure.osmachko.summarytask4.core.entity.Subject;
import ua.nure.osmachko.summarytask4.dao.ConnectionPool;
import ua.nure.osmachko.summarytask4.dao.DAOFacultySubjects;

/**
 * @author Valerii Osmachko
 *
 */
public class DAOFacultySubjectsImpl implements DAOFacultySubjects {
	
private static final Logger LOG = Logger.getLogger(DAOFacultySubjectsImpl.class);
	
	Connection connection;

	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.dao.DAOFacultySubjects#findSubjectsByFacultyId(java.lang.Integer)
	 */
	@Override
	public List<Subject> findSubjectsByFacultyId(Integer facultyId) {
		LOG.trace("finding subjects by faculty id...");
		connection = ConnectionPool.getConnection();
		List<Integer> integers = new ArrayList<Integer>();
		List<Subject> subjects = new ArrayList<Subject>();
		try(PreparedStatement pstmt = connection.prepareStatement("select Subject_idSubject from Faculty_Subjects where Faculty_idFaculty = ?;")) {
			pstmt.setInt(1, facultyId);
			pstmt.execute();
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				integers.add(rs.getInt("Subject_idSubject"));
			}	
			for(Integer item : integers) {
				try(PreparedStatement pstmt1 = connection.prepareStatement("select * from Subject where id = ?;")){
					pstmt1.setInt(1, item);
					pstmt1.execute();
					ResultSet rs1 = pstmt1.executeQuery();
					while(rs1.next()) {
						subjects.add(new Subject(rs1.getString("nameOfSubject")));
					}
					pstmt1.close();
					rs1.close();
				}catch (SQLException e) {
					// TODO: handle exception
				}
			}
			pstmt.close();
			rs.close();
			
		}catch (SQLException e) {
			// TODO: handle exception
		} finally {
			closeConnection();
			LOG.trace("subjects were found" + subjects.size());
		}
		return subjects;
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
	 * @see ua.nure.osmachko.summarytask4.dao.DAOFacultySubjects#insertSubjectsToFaculty(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public boolean insertSubjectsToFaculty(Integer facultyId, Integer subjectId) {
		LOG.trace("Adding subjects to faculties");
		connection = ConnectionPool.getConnection();
		try(PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Faculty_Subjects(Faculty_idFaculty,Subject_idSubject) values (?,?);")){
			pstmt.setInt(1, facultyId);
			pstmt.setInt(2, subjectId);
			pstmt.executeUpdate();
			pstmt.close();
		}catch (SQLException e) {
			// TODO: handle exception
		}finally {
			closeConnection();
		}
		return true;
	}
}
