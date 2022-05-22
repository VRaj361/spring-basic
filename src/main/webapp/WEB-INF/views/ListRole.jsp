<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ListRole</title>
</head>
<body>
	<h1>List of Roles</h1>
	<c:if test="${role.size()==0}">
		<h3>No data found</h3>
	</c:if>
	<c:if test="${role.size()!=0}">
	<h3>Search for Role name</h3>
	<br>
	<form action="searchrole" method="post">
		<input type="text" placeholder="Seach for role name" name="searchname">
		<input type="submit" value="submit">
	</form>
	<br>	
	<table>
		<tr>
			<th>Role id</th>
			<th>Role Name</th>
			<th>Update</th>
			<th>Delete</th>
			<th>Roles</th>
		</tr>
		<c:forEach items="${role}" var="r">
			<tr>
				<td>${r.roleid}</td>
				<td>${r.rolename}</td>
				<td><a href="updaterole?roleid=${r.roleid}">Update</a></td>
				<td><a href="deleterole?userid=${r.roleid}">Delete</a></td>
				<td><a href="viewrole?roleid=${r.roleid}">ViewRole</a></td>
			</tr>
		</c:forEach>
	</table>
	</c:if>	
</body>
</html>