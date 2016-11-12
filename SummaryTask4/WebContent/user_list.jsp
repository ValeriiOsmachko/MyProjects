<%--  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  --%>
<%@ page import="ua.nure.osmachko.summarytask4.dao.impl.DAOFactoryImpl"%>
<%@ page import="ua.nure.osmachko.summarytask4.dao.UserDAO"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="title" value="User list" />

<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  -->
<title>Insert title here</title>
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<%@ include file="/WEB-INF/jspf/LogOut.jspf"%>

</head>
<body>

	<h1 class="text-center">
		<fmt:message key="registration_form.input.listUsers" />
		:
	</h1>





	<table class="table table-hover table-striped" title="width:100%">
		<tr>
			<th><c:out value="Id" /></th>
			<th><fmt:message key="registration_form.input.first_name" /></th>
			<th><fmt:message key="registration_form.input.last_name" /></th>
			<th><fmt:message key="registration_form.input.email" /></th>
			<th><fmt:message key="registration_form.input.password" /></th>
			<th><fmt:message key="registration_form.input.login" /></th>
			<th><fmt:message key="registration_form.input.role" /></th>
			<th><fmt:message key="registration_form.input.status" /></th>
			<th><fmt:message key="registration_form.input.block" /></th>
			<th><fmt:message key="registration_form.input.unblock" /></th>


			<th></th>
			<th></th>
		</tr>


		<c:forEach items="${sessionScope.userses}" var="user">
			<tr>
				<td><c:out value="${user.id}" /></td>
				<td><c:out value="${user.firstName}" /></td>
				<td><c:out value="${user.lastName}" /></td>
				<td><c:out value="${user.email}" /></td>
				<td><c:out value="${user.password}" /></td>
				<td><c:out value="${user.login}" /></td>
				<td><c:out value="${user.role}" /></td>
				<td><c:choose>
						<c:when test="${user.blocked eq true}">
							<c:out value="YES" />
						</c:when>
						<c:when test="${user.role eq 'admin'}">
							<c:out value="   " />
						</c:when>
						<c:when test="${user.isEnrolleeExist() eq false }">
							<c:out value="Still isn't Enrollee" />
						</c:when>
						<c:otherwise>
							<c:out value="NO" />
						</c:otherwise>
					</c:choose></td>
				<td><c:if test="${user.role == 'client'}">
						<form action="controller" method="post">
							<input type="hidden" name="command" value="blockEnrolee">
							<input type="hidden" name="userId" value="${user.id}"> <input
								type="hidden" name="userFirstName" value="${user.firstName}">
							<input type="hidden" name="userLastName" value="${user.lastName}">
							<input type="hidden" name="userEmail" value="${user.email}">
							<input type="hidden" name="userPassword" value="${user.password}">
							<input type="hidden" name="userLogin" value="${user.login}">
							<input type="hidden" name="userRole" value="${user.role}">
							<input type="submit" class="btn btn-warning"
								value="Block Enrollee">
						</form>
					</c:if></td>
				<td><c:if test="${user.role == 'client'}">
						<form action="controller" method="post">
							<input type="hidden" name="command" value="unblockEnrolee">
							<input type="hidden" name="userId" value="${user.id}"> <input
								type="hidden" name="userFirstName" value="${user.firstName}">
							<input type="hidden" name="userLastName" value="${user.lastName}">
							<input type="hidden" name="userEmail" value="${user.email}">
							<input type="hidden" name="userPassword" value="${user.password}">
							<input type="hidden" name="userLogin" value="${user.login}">
							<input type="hidden" name="userRole" value="${user.role}">
							<input type="submit" class="btn btn-success"
								value="Unblock Enrollee">
						</form>
					</c:if></td>
			</tr>
		</c:forEach>

	</table>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>

</body>
</html>