package ua.nure.osmachko.summarytask4.web;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.swing.internal.plaf.basic.resources.basic;

import ua.nure.osmachko.summarytask4.core.entity.Faculty;

/**
 * Servlet implementation class SortFacultyServlet
 */
@WebServlet("/SortFacultyServlet")
public class SortFacultyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private static final Comparator<Faculty> SORT_FACULTY_BY_NAME = new Comparator<Faculty>() {

		@Override
		public int compare(Faculty o1, Faculty o2) {
			return o1.getNameOfFaculty().compareTo(o2.getNameOfFaculty());
		}
	};
	
	
	private static final Comparator<Faculty> SORT_FACULTY_BY_BUDGET_SEATS = new Comparator<Faculty>() {
		
		@Override
		public int compare(Faculty o1, Faculty o2) {
			return o1.getBudgetSeats() - o2.getBudgetSeats();
		}
	};
	
	
	private static final Comparator<Faculty> SORT_FACULTY_BY_TOTAL_SEATS = new Comparator<Faculty>() {
		@Override
		public int compare(Faculty o1, Faculty o2) {
			return o1.getTotalSeats() - o2.getTotalSeats();
		}
	};
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO : attributes of session
		HttpSession session = request.getSession();
		List<Faculty> faculties =(List<Faculty>) session.getAttribute("");
		
		switch (request.getParameter("sort")) {
		case "alphabetically":
			Collections.sort(faculties, SORT_FACULTY_BY_NAME);
			break;
		case "budget":
			Collections.sort(faculties, SORT_FACULTY_BY_BUDGET_SEATS);
			break;
		case "total":
			Collections.sort(faculties, SORT_FACULTY_BY_TOTAL_SEATS);
			break;
		}
		
		request.setAttribute("", faculties);
		request.getRequestDispatcher("").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
