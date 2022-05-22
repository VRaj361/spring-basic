<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Role</title>
</head>
<body>
	<s:form modelAttribute="role" method="post" action="saverole">
		RoleName:<s:input path="rolename" />
		<s:errors path="rolename"></s:errors>
		<br>
		<input type="submit" value="Save Role">


	</s:form>
</body>
</html>