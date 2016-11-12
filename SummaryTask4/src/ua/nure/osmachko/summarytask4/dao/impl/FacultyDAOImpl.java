package ua.nure.osmachko.summarytask4.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.core.entity.Faculty;
import ua.nure.osmachko.summarytask4.dao.ConnectionPool;
import ua.nure.osmachko.summarytask4.dao.FacultyDAO;
import ua.nure.osmachko.summarytask4.dao.Query;

public class FacultyDAOImpl implements FacultyDAO {
	
	
	private static final Logger LOGGER = Logger.getLogger(FacultyDAOImpl.class);
	
	Connection connection;

	@Override
	public Faculty insertFaculty(Faculty faculty) {
		connection = ConnectionPool.getConnection();
		try(PreparedStatement pstmt = connection.prepareStatement(Query.INSERT_INTO_FACULTY)) {
				pstmt.setString(1, faculty.getNameOfFaculty());
				pstmt.setInt(2, faculty.getTotalSeats());
				pstmt.setInt(3, faculty.getBudgetSeats());
				pstmt.executeUpdate();
				pstmt.close();
		}catch (SQLException e) {
			LOGGER.error("Can't insert Faculty", e);
		} finally {
			closeConnection();
		}
		return faculty;
	}

	@Override
	public boolean deleteFaculty(Integer facultyId) {
		connection = ConnectionPool.getConnection();
		try(PreparedStatement pstmt = connection.prepareStatement(Query.DELETE_FACULTY)) {
			pstmt.setInt(1, facultyId);
			pstmt.executeUpdate();
			pstmt.close();
		}catch (SQLException e) {
			LOGGER.error("Can't delete Faculty", e);
		}finally {
			closeConnection();
		}
		
		return true;
		
	}

	@Override
	public boolean updateFaculty(Integer facultyId, Faculty faculty) {
		LOGGER.trace("Starting process in DAO in update faculty method");
	    LOGGER.trace("Fields were got : " + "faculty name " + faculty.getNameOfFaculty() + "total seats " + 
		faculty.getTotalSeats() + "budget seats " + faculty.getBudgetSeats() + " id of faculty " + facultyId);
		connection = ConnectionPool.getConnection();
		try(PreparedStatement pstmt = connection.prepareStatement(Query.UPDATE_FACUTY)) {
			pstmt.setString(1, faculty.getNameOfFaculty());
			pstmt.setInt(2, faculty.getTotalSeats());
			pstmt.setInt(3, faculty.getBudgetSeats());
			pstmt.setInt(4, facultyId);
			pstmt.executeUpdate();
			pstmt.close();
		}catch (SQLException e) {
			LOGGER.error("Can't update faculty", e);
		} finally {
			closeConnection();
		}
		return true;
	}

	@Override
	public Faculty getFacultyById(Integer facultyId) {
		connection = ConnectionPool.getConnection();
		Faculty faculty = null;
		try(PreparedStatement pstmt = connection.prepareStatement(Query.SELECT_FACULTY_BY_ID)) {
			pstmt.setInt(1, facultyId);
			pstmt.execute();
			ResultSet rs = pstmt.getResultSet();
			while(rs.next()){
			faculty = new Faculty(rs.getString("nameOfFaculty"), rs.getInt("budget_seats"), rs.getInt("total_seats"));
			}
			pstmt.close();
			rs.close();
		}catch (SQLException e) {
			LOGGER.error("Can't get Faculty by id", e);
		} finally {
			closeConnection();
		}
		return faculty;
	}

	@Override
	public Faculty getFacultyByNameOfFaculty(String nameOfFaculty) {
		Faculty faculties = null;
		connection = ConnectionPool.getConnection();
		try(PreparedStatement pstmt = connection.prepareStatement(Query.SELECT_FACULTY_BY_NAMEOFFACULTY)) {
			pstmt.setString(1, nameOfFaculty);
			pstmt.execute();
			ResultSet rs = pstmt.getResultSet();
			while(rs.next()){
				faculties = new Faculty(rs.getInt("id"),rs.getString("nameOfFaculty"), rs.getInt("budget_seats"), rs.getInt("total_seats"));
			}
			pstmt.close();
			rs.close();
		}catch (SQLException e) {
			LOGGER.error("Can't get faculty by name of faculty", e);
		} finally {
			closeConnection();
		}
		return faculties;
	}

	@Override
	public List<Faculty> getFacultyByNumberOfBudgetSeats(Integer budgetSeats) {
		List<Faculty> faculties = new ArrayList<Faculty>();
		connection = ConnectionPool.getConnection();
		try(PreparedStatement pstmt = connection.prepareStatement(Query.SELECT_FACULT_BY_BUDGET_SEATS)) {
			pstmt.setInt(1, budgetSeats);
			ResultSet rs = pstmt.executeQuery(Query.SELECT_FACULT_BY_BUDGET_SEATS);
			while(rs.next()) {
				faculties.add(new Faculty(rs.getString("nameOfFaculty"), rs.getInt("budget_seats"), rs.getInt("total_seats")));
			}
			pstmt.close();
			rs.close();
		}catch (SQLException e) {
			LOGGER.error("Can't get Faculty by budget seats", e);
		} finally {
			closeConnection();
		}
		return faculties;
	}

	@Override
	public List<Faculty> getFacultyByNumberOfTotalSeats(Integer totalSeats) {
		List<Faculty> faculties = new ArrayList<Faculty>();
		connection = ConnectionPool.getConnection();
		try(PreparedStatement pstmt = connection.prepareStatement(Query.SELECT_FACULTY_BY_TOTAL_SEATS)) {
			pstmt.setInt(1, totalSeats);
			ResultSet rs = pstmt.executeQuery(Query.SELECT_FACULTY_BY_TOTAL_SEATS);
			while (rs.next()) {
				faculties.add(new Faculty(rs.getString("nameOfFaculty"), rs.getInt("budget_seats"), rs.getInt("total_seats")));
			}
			pstmt.close();
			rs.close();
		}catch (SQLException e) {
			LOGGER.error("Can't get faculty by number of total seats", e);
		} finally {
			closeConnection();
		}
		return faculties;
	}

	@Override
	public List<Faculty> getAllFaculty() {
		List<Faculty> faculties = new ArrayList<Faculty>();
		connection = ConnectionPool.getConnection();
		try(Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(Query.SELECT_ALL_FACULTY)) {
			 while (rs.next()) {
				faculties.add(new Faculty(rs.getInt("id"),rs.getString("nameOfFaculty"), rs.getInt("budget_seats"), rs.getInt("total_seats")));
				
			}
			 statement.close();
			 rs.close();
		}catch (SQLException e) {
			LOGGER.error("Can't get all faculties", e);
		}finally {
			closeConnection();
		}
		return faculties;
	}
	
	
	private void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean updateFaculty(Faculty faculty) {
		connection = ConnectionPool.getConnection();
		try(PreparedStatement pstmt = connection.prepareStatement(Query.UPDATE_FACUTY)) {
			pstmt.setString(1, faculty.getNameOfFaculty());
			pstmt.setInt(2, faculty.getTotalSeats());
			pstmt.setInt(3, faculty.getBudgetSeats());
			pstmt.setInt(4, faculty.getId());
			pstmt.executeUpdate();
			pstmt.close();
		}catch (SQLException e) {
			// TODO: handle exception
		}finally {
			closeConnection();
		}
		return true;
	}

	@Override
	public boolean deleteFaculty(Faculty faculty) {
		connection = ConnectionPool.getConnection();
		try(PreparedStatement pstmt = connection.prepareStatement(Query.DELETE_FACULTY))  {
			pstmt.setInt(1, faculty.getId());
			pstmt.executeUpdate();
			pstmt.close();
		}catch (SQLException e) {
			LOGGER.error("Can't delete faculty");
		} finally {
			closeConnection();
		}
		return true;
	}

	@Override
	public Integer getNumberOfBudgetSeats(Integer idFaculty) {
		connection = ConnectionPool.getConnection();
		Integer numberOfBudgetSeats = 0;
		try(PreparedStatement pstmt = connection.prepareStatement("select budget_seats from Faculty where id = ?;"))  {
			pstmt.setInt(1, idFaculty);
			pstmt.execute();
			ResultSet rs = pstmt.getResultSet();
			while(rs.next()) {
				numberOfBudgetSeats = rs.getInt("budget_seats");
			}
			pstmt.close();
			rs.close();
		}catch (SQLException e) {
			LOGGER.error("Can't delete faculty");
		} finally {
			closeConnection();
		}
		return numberOfBudgetSeats;
	}

	@Override
	public String getNameOfFacultyById(Integer idFaculty) {
		connection = ConnectionPool.getConnection();
		String nameOfFaculty = null;
		try(PreparedStatement pstmt = connection.prepareStatement("select nameOfFaculty from Faculty where id = ?;"))  {
			pstmt.setInt(1, idFaculty);
			pstmt.execute();
			ResultSet rs = pstmt.getResultSet();
			while(rs.next()) {
				nameOfFaculty = rs.getString("nameOfFaculty");
			}
			pstmt.close();
			rs.close();
		}catch (SQLException e) {
			LOGGER.error("Can't delete faculty");
		} finally {
			closeConnection();
		}
		return nameOfFaculty;
	}

	
}
