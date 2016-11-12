<%@page import="ua.nure.osmachko.summarytask4.dao.impl.DAOFacultyEnrolleeImpl"%>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
    <%@ page import="ua.nure.osmachko.summarytask4.dao.impl.DAOFactoryImpl"%>
<%@ page import="ua.nure.osmachko.summarytask4.dao.FacultyDAO"%>
<%@ page import="ua.nure.osmachko.summarytask4.core.entity.*"%>
<%@ page session="true" %>
<%@ page import="java.util.List"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>Insert title here</title>

<%@ include file="/WEB-INF/jspf/head.jspf"%>
<%@ include file="/WEB-INF/jspf/LogOut.jspf"%>


</head>
<body>



	<h1 class="text-center">
		<fmt:message key="faculties_page.list_faculties" />
		:
	</h1>

	<%-- 	<% FacultyDAO ud = new DAOFactoryImpl().getFacultyDAO();
   request.getServletContext().setAttribute("faculty_list", ud.getAllFaculty());%> --%>

	<%
		List<?> result = (List<?>) session.getAttribute("faculties");
		request.getServletContext().setAttribute("faculty_list", result);
	%>




	<table class="table table-hover table-striped" title="width:100%">
		<jsp:useBean id="fe"
			class="ua.nure.osmachko.summarytask4.dao.impl.DAOFacultyEnrolleeImpl" />

		<tr>
			<th><c:out value="Id" /></th>
			<th><fmt:message key="faculties_page.name_of_faculty" /></th>
			<th><fmt:message key="faculties_page.total_seats" /></th>
			<th><fmt:message key="faculties_page.budget_seats" /></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<%-- <th><c:out value="Show Result on faculty"/></th> --%>
		</tr>


		<c:forEach items="${applicationScope.faculty_list}" var="faculty">
			<tr>
				<td><c:out value="${faculty.id}" /></td>
				<td><c:out value="${faculty.nameOfFaculty}" /></td>
				<td><c:out value="${faculty.totalSeats}" /></td>
				<td><c:out value="${faculty.budgetSeats}" /></td>


				<td><c:if test="${sessionScope.user.role eq 'admin'}">
						<form action="controller" method="GET">
							<input type="hidden" name="command" value="updateFaculty">
							<input type="hidden" name="facultyId" value="${faculty.id}">
							<input type="hidden" name="nameOfFaculty"
								value="${faculty.nameOfFaculty}"> <input type="hidden"
								name="totalSeats" value="${faculty.totalSeats}"> <input
								type="hidden" name="budgetSeats" value="${faculty.budgetSeats}">
							<input type="submit" class="btn btn-success"
								value="<fmt:message key="faculties_page.update_faculty"/>">
						</form>
					</c:if> <c:if test="${sessionScope.user.role eq 'client'}">
						<form action="controller" method="POST">
							<input type="hidden" name="command" value="registrateOnFaculty">
							<input type="hidden" name="facultyId" value="${faculty.id}">
							<input type="hidden" name="nameOfFaculty"
								value="${faculty.nameOfFaculty}"> <input type="hidden"
								name="totalSeats" value="${faculty.totalSeats}"> <input
								type="hidden" name="budgetSeats" value="${faculty.budgetSeats}">
							<button type="submit" class="btn btn-danger">
								<fmt:message key="faculties_page.registrate_on_faculty" />
							</button>
						</form>
					</c:if></td>

				<td><c:if test="${sessionScope.user.role eq 'admin'}">
						<form action="controller" method="POST">
							<input type="hidden" name="command" value="deleteFaculty">
							<input type="hidden" name="facultyId" value="${faculty.id}">
							<input type="hidden" name="nameOfFaculty"
								value="${faculty.nameOfFaculty}"> <input type="hidden"
								name="totalSeats" value="${faculty.totalSeats}"> <input
								type="hidden" name="budgetSeats" value="${faculty.budgetSeats}">
							<button type="submit" class="btn btn-link">
								<span class="glyphicon glyphicon-trash"></span>
							</button>
						</form>
					</c:if></td>
				<td><c:if
						test="${(sessionScope.user.role eq 'admin' )&& (!faculty.emtpy)}">
						<form action="controller" method="POST">
							<input type="hidden" name="command" value="MakeResultOnFaculty">
							<input type="hidden" name="facultyId" value="${faculty.id}">
							<input type="hidden" name="nameOfFaculty"
								value="${faculty.nameOfFaculty}"> <input type="hidden"
								name="totalSeats" value="${faculty.totalSeats}"> <input
								type="hidden" name="budgetSeats" value="${faculty.budgetSeats}">
							<button type="submit" class="btn btn-danger">
								<fmt:message key="faculties_page.make_result" />
							</button>
						</form>
					</c:if></td>
					<td><c:if
						test="${(sessionScope.user.role eq 'admin' )&& (!faculty.emtpy)}">
						<form action="controller" method="POST">
							<input type="hidden" name="command" value="showResultOnFaculty">
							<input type="hidden" name="facultyId" value="${faculty.id}">
							<input type="hidden" name="nameOfFaculty"
								value="${faculty.nameOfFaculty}"> <input type="hidden"
								name="totalSeats" value="${faculty.totalSeats}"> <input
								type="hidden" name="budgetSeats" value="${faculty.budgetSeats}">
							<button type="submit" class="btn btn-info">
								<fmt:message key="showResult" />
							</button>
						</form>
					</c:if></td>
			</tr>
		</c:forEach>
	</table>

	<form action="controller" method="POST">
		<input type="hidden" name="command" value="sortFacultyByName">
		<input type="submit" class="btn btn-warning"
			value="<fmt:message key="faculties_page.sort_faculty_name"/>">
	</form>
	<form action="controller" method="POST">
		<input type="hidden" name="command" value="sortFacultyByTotalSeats">
		<input type="submit" class="btn btn-warning"
			value="<fmt:message key="faculties_page.sort_faculty_total_seats"/>">
	</form>
	<form action="controller" method="POST">
		<input type="hidden" name="command" value="sortFacultyByBudgetSeats">
		<input type="submit" class="btn btn-warning"
			value="<fmt:message key="faculties_page.sort_faculty_budget_seats"/>">
	</form>



	<%@ include file="/WEB-INF/jspf/header.jspf"%>

</body>
</html>