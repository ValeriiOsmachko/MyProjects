<%--  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  --%>
    <%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>Insert title here</title>
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<c:set var="title" scope="request" value="Login"/>
</head>
<body>
<center>


	<form action="controller" method="post">
		<h2>
			<fmt:message key="login.welcome" />
		</h2>
		<input type="hidden" name="command" value="login"/>
		<div class="form-group">
			<label for="usr"><fmt:message key="login.login" /></label> <input
				type="text" class="form-control" name="login">
		</div>

		<div class="form-group">
			<label for="pwd"><fmt:message key="login.password" /></label> <input
				type="password" class="form-control" name="password">
		</div>


		<input type="submit" class="btn btn-large btn-primary"
			value="<fmt:message key ="login.submit"/>">



	</form>
	

	<form action="controller" method="GET">
		<input type="hidden" name="command" value="showRegistrationPage" /> <input
			type="submit" class="btn btn-large btn-primary" value="Registrate">
	</form>


	<%@ include file="/WEB-INF/jspf/header.jspf"%>
</center>
</body>
</html>