<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>Insert title here</title>
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<%@ include file="/WEB-INF/jspf/LogOut.jspf"%>
</head>
<body>

	<div class="container">
		<p class="text-left">
		<h2 class="text-primary">
			<fmt:message key="faculty_add.message" />
		</h2>
	</div>
	<form action="controller" method="POST">
		<input type="hidden" name="command" value="addFaculty"><br>
		<div class="form-group has-success has-feedback">
			<label class="col-sm-2 control-label" for="inputSuccess"><fmt:message
					key="faculties_page.name_of_faculty" /></label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputSuccess"
					name="nameOfFaculty"> <span
					class="glyphicon glyphicon-ok form-control-feedback"></span>
			</div>
		</div>
		<div class="form-group has-success has-feedback">
			<label class="col-sm-2 control-label" for="inputSuccess"><fmt:message
					key="faculties_page.total_seats" /></label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputSuccess"
					name="totalSeats"> <span
					class="glyphicon glyphicon-ok form-control-feedback"></span>
			</div>
		</div>
		<div class="form-group has-success has-feedback">
			<label class="col-sm-2 control-label" for="inputSuccess"><fmt:message
					key="faculties_page.budget_seats" /></label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputSuccess"
					name="budgetSeats"> <span
					class="glyphicon glyphicon-ok form-control-feedback"></span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label"><fmt:message
					key="faculty_add.fistSubj" />:</label>
			<div class="col-sm-2">
				<select class="form-control" id="FirstSubject" name="FirstSubject">
					<option>Mathimatics</option>
					<option>Physics</option>
					<option>English</option>
					<option>Biology</option>
					<option>Chemistry</option>
					<option>History</option>
					<option>Geography</option>
					<option>Ukrainian</option>
				</select>

			</div>
		</div>
		<br>

		<div class="form-group">
			<label class="col-sm-2 control-label"><fmt:message
					key="faculty_add.secondSubj" />:</label>
			<div class="col-sm-2">
				<select class="form-control" id="SecondSubject" name="SecondSubject">
					<option>Mathimatics</option>
					<option>Physics</option>
					<option>English</option>
					<option>Biology</option>
					<option>Chemistry</option>
					<option>History</option>
					<option>Geography</option>
					<option>Ukrainian</option>
				</select>

			</div>
		</div>
		<br>

		<div class="form-group">
			<label class="col-sm-2 control-label"><fmt:message
					key="faculty_add.thirdSubj" />:</label>
			<div class="col-sm-2">
				<select class="form-control" id="ThirdSubject" name="ThirdSubject">
					<option>Mathimatics</option>
					<option>Physics</option>
					<option>English</option>
					<option>Biology</option>
					<option>Chemistry</option>
					<option>History</option>
					<option>Geography</option>
					<option>Ukrainian</option>
				</select>

			</div>
		</div>
		<br>


		<!-- Name of Faculty:<input type = "text" name = "nameOfFaculty"><br>
		Total seats:<input type = "text" name = "totalSeats"><br>
		Budget seats:<input type = "text" name = "budgetSeats"><br> -->
		<input type="submit" class="btn btn-info" value="Add">
	</form>

	<%@ include file="/WEB-INF/jspf/header.jspf"%>
</body>
</html>