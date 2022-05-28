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
<!-- image list without database -->
	<h2>All Images</h2>
	<table border=1>
		<tr>
			<th>File name</th>
			<th>File Link</th>
		</tr>
		<c:forEach items="${files}" var="f">
			<tr>
				<td>${f}</td>
				<td><a href="viewimage?image=${f}">${f}</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>