<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Update the Role</h2>
	<br><br>
	<s:form modelAttribute="role" method="post" action="updateroledata">
		<h4>Role id = ${role.roleid}</h4>
		RoleId:<s:hidden path="roleid" value="${role.roleid}"/>
		RoleName:<s:input path="rolename" value="${role.rolename}"/>
		
		<br>
		<input type="submit" value="Update Role">


	</s:form>
</body>
</html>