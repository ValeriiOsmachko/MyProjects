<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<%@ include file="/WEB-INF/jspf/LogOut.jspf"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<c:choose>
		<c:when test="${sessionScope.finalResult eq null}">
				<h2>No Results On Faculty</h2>
		</c:when>
		<c:otherwise>
			<h2>Results of <c:out value="${sessionScope.currentFaculty}"/> </h2>
			
			<table class="table table-hover table-striped" title="width:100%">
		<tr>
			<th><fmt:message key="registration_form.input.first_name" /></th>
			<th><fmt:message key="registration_form.input.last_name" /></th>
			<th><fmt:message key="city" /></th>
			<th><fmt:message key="region" /></th>
			<th><fmt:message key="statusOfStudent" /></th>
			<th><fmt:message key="sumpoints" /></th>


		</tr>


		<c:forEach items="${sessionScope.finalResult}" var="user">
			<tr>
				<td><c:out value="${user.firstName}" /></td>
				<td><c:out value="${user.lastName}" /></td>
				<td><c:out value="${user.city}" /></td>
				<td><c:out value="${user.region}" /></td>
				<td><c:out value="${user.statusOfeducation}" /></td>
				<td><c:out value="${user.summaryPionts}" /></td>
				
			</tr>
		</c:forEach>

	</table>
			
		</c:otherwise>
	</c:choose>
		
		<%@ include file="/WEB-INF/jspf/header.jspf"%>
		
		</body>
</html>