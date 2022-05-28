<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${userinfo[0].email }</h1>
	<h2>All Images</h2>
	<table border=1>
		<tr>
			<th>File name</th>
			<th>File Link</th>
		</tr>
		<c:forEach items="${userinfo}" var="f">
			<tr>
				<td>${f.profileurl}</td>
				<td><a href="viewimage?image=${f.profileurl}">${f.profileurl}</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<h3>Choose default image</h3>
	<table border=1>
		<tr>
			
			<th>File Link</th>
			<th>Default</th>
		</tr>
		<c:forEach items="${userinfo}" var="f">
			<tr>
				<td><a href="defaultpicdb?image=${f.profileurl}">${f.profileurl}</a></td>
				<td>${f.defaultpic=="t" }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>