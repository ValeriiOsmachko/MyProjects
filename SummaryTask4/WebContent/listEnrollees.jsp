<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="ua.nure.osmachko.summarytask4.dao.impl.DAOFactoryImpl"%>
<%@ page import="ua.nure.osmachko.summarytask4.dao.EnrolleeDAO"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% EnrolleeDAO ud = new DAOFactoryImpl().getEnrolleeDAO();
   request.getServletContext().setAttribute("enrolee_list", ud.getAllEnrollees());%>


	<table>
		<tr>
			<th><c:out value="Id" /></th>
			<th><c:out value="City" /></th>
			<th><c:out value="Region" /></th>
			<th><c:out value="IdUser" /></th>
			<th><c:out value="IsBlocked" /></th>
			<th></th>
			<th></th>
		</tr>


		<c:forEach items="${applicationScope.enrolee_list}" var="enrolee">
			<tr>
				<td><c:out value="${enrolee.id}" /></td>
				<td><c:out value="${enrolee.city}" /></td>
				<td><c:out value="${enrolee.region}" /></td>
				<td><c:out value="${enrolee.userId}" /></td>
				<td><c:out value="${enrolee.blockedStatus}" /></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>