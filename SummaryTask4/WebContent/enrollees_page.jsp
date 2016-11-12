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



	<form action="controller" method="GET">
		<h2>
			<fmt:message key="become_enrollee.messege" />
		</h2>
		<input type="hidden" name="command" value="addEnrollee"> <input
			type="submit" class="btn btn-success"
			value="<fmt:message key="become_enrollee_form.become_enrollee"/>">
	</form>


	<%@ include file="/WEB-INF/jspf/header.jspf"%>
</body>
</html>