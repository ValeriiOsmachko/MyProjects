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

	<h2>
		<fmt:message key="registrate.messege" />
	</h2>
<div class="container">
	<form action="controller" method="POST">
		
		<input type="hidden" name="command" value="registrateUser">
		
		<div class="form-group row">
		<!-- <div class="col-xs-3"> -->
			<label for="inputEmail3" class="col-sm-2 col-form-label"><fmt:message
					key="registration_form.input.first_name" /></label>
					<div class="col-sm-10">
					<input
				class="form-control" type="text" name="firstName" id="inputEmail3"/>
				</div>
		<!-- </div> -->
		</div>
		
		
		<div class="form-group row">
		<!-- <div class="col-xs-3"> -->
			<label for="inputEmail3" class="col-sm-2 col-form-label"><fmt:message
					key="registration_form.input.last_name" /></label>
					 <div class="col-sm-10">
					 <input
				class="form-control" type="text" name="lastName"/>
					</div>
		<!-- </div> -->
		</div>
		
		<div class="form-group row">
		<!-- <div class="col-xs-3"> -->
			<label for="inputEmail3" class="col-sm-2 col-form-label"><fmt:message
					key="registration_form.input.email" /></label>
					<div class="col-sm-10">
					<input class="form-control"
				type="text" name="email"/>
				</div>

		<!-- </div> -->
		</div>
		
		
		<div class="form-group row">
		<!-- <div class="col-xs-3"> -->
			<label for="inputLogin3" class="col-sm-2 col-form-label"><fmt:message
					key="registration_form.input.login" /></label>
					<div class="col-sm-10">
					<input class="form-control"
				type="text" name="login"/>
				</div>

		<!-- </div> -->
		</div>
		
		<div class="form-group row">
		<!-- <div class="col-xs-3"> -->
			<label for="inputPassword3" class="col-sm-2 col-form-label"><fmt:message
					key="registration_form.input.password" /></label>
					 <div class="col-sm-10">
					 <input
				class="form-control" type="password" name="password"/>
					</div>
		<!-- </div> -->
		</div>
		
		 <div>
		<input class="btn btn-info" type="submit"
			value="<fmt:message key="registrate"/>"/>
		</div> 
	</form>
	</div>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>

</body>
</html>