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
<%@ include file="/WEB-INF/jspf/LogOut.jspf"%>
</head>
<body>


	<form action="controller" method="POST">
		<h2>
			<fmt:message key="applying_for_faculty.appl" />
		</h2>
		<table class="table table-hover table-striped" title="width:100%">
			<tr>
				<th><fmt:message key="applying_for_faculty.name_subj" /></th>
				<th><fmt:message key="applying_for_faculty.mark" /></th>
			</tr>

			<c:forEach items="${sessionScope.subjects}" var="subject"
				varStatus="loop">
				<tr>
					<td><c:out value="${subject.nameOfSubject}"></c:out></td>

					<td>
						<div class="col-xs-3">
							<input class="form-control" type="text" name="${loop.index}">
						</div>
					</td>
				</tr>
			</c:forEach>

		</table>
		<!-- Upload scan of certificate: <input type="file" name="scan" size="50" /> -->
		<input type="hidden" name="command" value="confirmMarks"> <input
			type="submit" class="btn btn-warning"
			value="<fmt:message key="applying_for_faculty.confirm_marks"/>">
	</form>



	<%@ include file="/WEB-INF/jspf/header.jspf"%>
</body>
</html>