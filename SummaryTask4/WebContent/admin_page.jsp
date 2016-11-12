<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
    <%@ page import="ua.nure.osmachko.summarytask4.dao.impl.DAOFactoryImpl"%>
<%@ page import="ua.nure.osmachko.summarytask4.core.entity.*"%>
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


	
	 <div>
		<form action="controller" method="GET">
			<h2>
				<fmt:message key="admin.page.page" />
			</h2>
			<input type="hidden" name="command" value="listUsers"> <input
				type="submit" class="btn btn-info"
				value="<fmt:message key="admin_page.all_users"/>">
		</form>
	</div>
	<div>
		<form action="controller" method="GET">
			<input type="hidden" name="command" value="listFaculties"> <input
				type="submit" class="btn btn-info"
				value="<fmt:message key="admin_page.all_faculties"/>">
		</form>
	</div>

	<div>
		<form action="controller" method="GET">
			<!-- <input type="hidden" name="command" value="addFaculty">	
				<input type="submit" class="btn btn-success" value="ADD DACULTY"> -->
			<button type="submit" class="btn btn-link" name="command"
				value="addFaculty">
				<span class="glyphicon glyphicon-plus"></span>
				<fmt:message key="admin_page.add_faculty" />
			</button>
		</form>
	</div>
 


	



	<div>
		<%@ include file="/WEB-INF/jspf/header.jspf"%>
	</div>
</body>
</html>