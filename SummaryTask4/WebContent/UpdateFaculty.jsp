<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
    <%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>Insert title here</title>
<%@ include file="/WEB-INF/jspf/head.jspf"%>
</head>
<body>

	<%@ include file="/WEB-INF/jspf/head.jspf"%>
	<%@ include file="/WEB-INF/jspf/LogOut.jspf"%>

	<h2>
		<fmt:message key="update_faculty.message" />
	</h2>
	<form action="controller" method="POST">
		<input type="hidden" name="command" value="updateFaculty"><br>
		<h4>
			<fmt:message key="update_faculty.name" />
			:
		</h4>
		<input class="form-control" type="text" name="nameOfFaculty"><br>
		<h4>
			<fmt:message key="update_faculty.total_seats" />
			:
		</h4>
		<input class="form-control" type="text" name="totalSeats"><br>
		<h4>
			<fmt:message key="update_faculty.budget_seats" />
			:
		</h4>
		<input class="form-control" type="text" name="budgetSeats"><br>
		<input class="btn btn-large btn-primary" type="submit" value="Submit">
	</form>

	<%@ include file="/WEB-INF/jspf/header.jspf"%>
</body>
</html>