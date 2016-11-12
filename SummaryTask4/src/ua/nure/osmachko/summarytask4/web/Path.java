package ua.nure.osmachko.summarytask4.web;

/**
 * 
 *Class which contains all Pathes in the programm,
 *pages and regirect pages.
 * @author Valerii Osmachko
 *
 */
public class Path {


	public static final String PAGE_LOGIN = "/login.jsp";
	public static final String PAGE_ERROR_PAGE = "/error_page.jsp";
	
	public static final String PAGE_ADMIN_PAGE = "/admin_page.jsp";
	
	public static final String PAGE_ENROLLEES_PAGE = "/enrollees_page.jsp";
	public static final String PAGE_INSERT_ENROLLEE_PAGE = "/WEB-INF/jsp/insert_enrollee.jsp";
	public static final String PAGE_UPDETE_ENROLLEE_PAGE = "/WEB-INF/jsp/update_enrollee.jsp";
	public static final String PAGE_REGISTRATION_PAGE = "/RegistrationForm.jsp";
	
	public static final String PAGE_FACULTIES_PAGE = "/WEB-INF/jsp/faculty.jsp";
	public static final String PAGE_INSERT_FACULTY_PAGE = "/WEB-INF/jsp/insert_faculty.jsp";
	public static final String PAGE_UPDATE_FACULTY_PAGE = "/WEB-INF/jsp/update_enrollee.jsp";
	public static final String WELCOME_PAGE= "";
	public static final String FORWARD_VIEW_ALL_ENROLLEES = "/WEB-INF/listEnrollees.jsp";
	public static final String FORWARD_VIEW_ALL_FACULTY = "/listFaculties.jsp";
	public static final String FORWARD_FACULTY_ADD = "/AddFacultyForm.jsp";
	public static final String FORWARD_SHOW_SUBJECTS_ON_FACULTY = "/showSubjectsOnFaculty.jsp";
	public static final String FORWARD_USER_ADD = "/WEB-INF/AddUserForm.jsp";
	public static final String FORWARD_ENROLLEE_ADD = "/RegistrateAsEnrollee.jsp";
	public static final String FORWARD_TO_VIEW_ALL_USERS = "/user_list.jsp";
	public static final String FORWARD_UPDATE_FACULTY_FORM = "/UpdateFaculty.jsp";
	public static final String FORWARD_TO_VIEW_RESULTS = "/ShowResults.jsp";
	
	
	
	
	public static final String REDIRECT_TO_VIEW_ALL_ENROLLEES = "controller?command=listEnrolles";
	public static final String REDIRECT_TO_VIEW_ALL_USERS = "controller?command=listUsers";
	public static final String REDIRECT_TO_VIEW_ALL_FACULTIES = "controller?command=listFaculties";
	public static final String REDIRECT_TO_SHOW_SORTED_BY_NAME = "controller?command=showSortedByName";
	public static final String REDIRECT_TO_SHOW_SORTED_BY_TOTAL_SEATS = "controller?command=sortFacultyByTotalSeats";
	public static final String REDIRECT_TO_SHOW_SORTED_BY_BUDGET_SEATS = "controller?command=sortFacultyByBudgetSeats";
	public static final String REDIRECT_TO_SHOW_FACULTY_SUBJECTS = "controller?command=showFacultySubjects";
	public static final String REDIRECT_TO_SHOW_ADMIN_PAGE = "controller?command=showAdminPage";
	public static final String REDIRECT_TO_SHOW_ENROLLEE_PAGE = "controller?command=showEnrolleePage";
	public static final String REDIRECT_TO_SHOW_REGISTRATION_PAGE = "controller?command=showRegistrationPage";
	public static final String REDIRECT_TO_SHOW_RESULTS = "controller?command=showResultsOnFaculty";
	public static final String REDIRECT_TO_SHOW_ADD_ENROLLEE = "controller?command=addEnrollee";
	
	
	
	
	
	
	
}
