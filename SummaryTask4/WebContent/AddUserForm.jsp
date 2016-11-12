<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	add user: <br>
	<form action="controller" method="POST"><br>
		<input type="hidden" name = "command" value="addUser"><br>
		first name:<input type = "text" name = "firstName"><br>
		last name:<input type = "text" name = "lastName"><br>
		e-mail:<input type = "text" name = "email"><br>
		password:<input type = "text" name = "password"><br>
		login:<input type = "text" name = "login"><br>
		role:<input type = "text" name = "role"><br>
		<input type = "submit" value="Submit">
	</form>
	
</body>
</html>