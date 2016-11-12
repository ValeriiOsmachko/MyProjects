package ua.nure.osmachko.summarytask4.dao;

/**
 * Class which contains all SQL Statements.
 * @author Valerii Osmachko
 *
 */
public class Query {
	
	public static final String INSERT_ENROLLEE = "INSERT INTO Enrollee(city,region,User_idUser,isBlocked) values(?,?,?,?);";
	public static final String SELECT_ALL_FROM_ENROLLEES = "SELECT * FROM ENROLLEE";
	public static final String DELETE_ENROLLEE = "DELETE from ENROLLEE WHERE id = ?";
	public static final String UPDATE_ENROLLEE = "UPDATE ENROLLEE SET city = ?, region = ?, User_idUser = ?, isBlocked = ? WHERE id = ?";
	public static final String SELECT_ENROLLEE_BY_CITY = "SELECT * from ENROLLEE WHERE city = ?";
	public static final String SELECT_ENROLLEE_BY_REGION = "SELECT * from ENROLLEE WHERE region = ?";
	public static final String SELECT_ENROLLEE_BY_STATUS = "SELECT * from ENROLLEE WHERE isBlocked = ?";
	public static final String INSERT_INTO_FACULTY = "INSERT INTO Faculty(nameOfFaculty,total_seats,budget_seats) values(?,?,?);";
	public static final String DELETE_FACULTY = "DELETE  FROM Faculty where id = ?";
	public static final String UPDATE_FACUTY = "UPDATE Faculty SET nameOfFaculty = ?, total_seats = ?, budget_seats = ? where id = ?";
	public static final String SELECT_FACULTY_BY_ID = "SELECT * from Faculty where id = ?";
	public static final String SELECT_FACULTY_BY_NAMEOFFACULTY = "SELECT * from Faculty where nameOfFaculty = ?";
	public static final String SELECT_FACULT_BY_BUDGET_SEATS = "SELECT * from Faculty where budget_seats = ?";
	public static final String SELECT_FACULTY_BY_TOTAL_SEATS = "SELECT * from Faculty where total_seats = ?";
	public static final String SELECT_ALL_FACULTY = "SELECT * FROM Faculty";
	public static final String INSERT_USER = "INSERT INTO Users(first_name,last_name,email,password,login,role) values (?,?,?,?,?,?)";	
	public static final String DELETE_USER = "DELETE FROM Users where id = ?";
	public static final String UPDATE_USER = "UPDATE Users SET first_name = ?, last_name = ?, email = ?, password = ?, login = ?,  role = ? where id = ?";
	public static final String SELECT_USER_BY_ID = "select *  from Users where  id = ?";
	public static final String SELECT_USER_BY_EMAIL = "select *  from Users where  email = ?";
	public static final String SELECT_USER_BY_ROLE = "select *  from Users where  role = ?";
	public static final String SELECT_ALL_USERS = "select *  from Users";
	public static final String SELECT_USER_BY_FIRSTNAME = "select *  from Users where first_name = ?";
	public static final String SELECT_USER_BY_LOGIN = "SELECT * from Users where login = ?";
	public static final String SELECT_USER_BY_LASTNAME = "select *  from Users where last_name = ?";
	public static final String SELECT_ALL_MARKS= "SELECT * FROM Mark";
	public static final String SELECT_MARK_BY_ID = "SELECT * FROM Mark WHERE id = ?;";
	public static final String INSERT_MARK = "INSERT INTO Mark(mark,Subject_idSubject,Enrollee_idEnrollee) values (?,?,?);";
	public static final String UPDATE_MARK = "UPDATE Mark SET mark = ?, Subject_idSubject = ?, Enrollee_idEnrollee = ? where id = ?; ";
	public static final String DELETE_MARK = "DELETE FROM Mark where id = ?";
	public static final String BLOCK_ENROLEE = "UPDATE  Enrollee SET isBlocked = true where User_idUser = ?;";
	public static final String UNBLOCK_ENROLEE = "UPDATE  Enrollee SET isBlocked = false where User_idUser = ?;";
	
}
