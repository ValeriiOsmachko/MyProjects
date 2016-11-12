<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>Insert title here</title>
<%@ include file="/WEB-INF/jspf/head.jspf"%>
</head>
<body>


	<form action="controller" method="POST">
		<h2>
			<fmt:message key="becoming_enrollee" />
		</h2>
		<input type="hidden" name="command" value="addEnrollee"><br>
		<div class="col-xs-3">
			<label for="ex2"><fmt:message
					key="become_enrollee_form.become_enrollee.city" /></label> <input
				class="form-control" type="text" name="city">
		</div>
		<div class="col-xs-3">
			<label for="ex2"><fmt:message
					key="become_enrollee_form.become_enrollee.region" /></label> <input
				class="form-control" type="text" name="region">
		</div>
		<input class="btn btn-large btn-primary" type="submit"
			value="Become Enrollee">
	</form>


	<%@ include file="/WEB-INF/jspf/header.jspf"%>
	
	<%@ include file="/WEB-INF/jspf/LogOut.jspf"%>
</body>
</html>