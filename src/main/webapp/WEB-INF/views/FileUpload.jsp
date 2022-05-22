<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="saveprofile" method="post" enctype="multipart/form-data">
		Title:<input type="text" name="title">
		<br>
		Url:
		<br>
		<input type="file" name="profileurl" >
		<br><br>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>