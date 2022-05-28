<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- file upload using database with validation -->
	<s:form  action="saveuserdb" method="post" enctype="multipart/form-data" modelAttribute="filedb">
		User Name: <s:input path="name"/><s:errors path="name"></s:errors><br><br>
		Email: <s:input  path="email"/><s:errors path="email"></s:errors><br><br>
		Password: <s:password  path="password"/><s:errors path="password"></s:errors><br><br>
		Upload File: <input type="file" name="profilePic"/>${fileerror}<br><br>
		<input type="submit" value="Submit"> 
	</s:form>
</body>
</html>