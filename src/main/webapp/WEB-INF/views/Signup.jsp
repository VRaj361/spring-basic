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
	<h1>Sign up</h1>
	<s:form action="saveuser" method="post" modelAttribute="user">
		Firstname : <s:input path="firstname"/>
					<s:errors path="firstname"></s:errors>
		<br><br>
		Email : <s:input path="email"/>
				<s:errors path="email"></s:errors>
		<br><br>
		Password : <s:password path="password"/>
				   <s:errors path="password"></s:errors>
		<br><br>
		<button type="submit">Submit</button>
	</s:form>
	<%-- <form action="saveuser" method="post">
		<input type="text" name="firstname">
		<input type="text" name="email">
		<input type="password" name="password">
		<button type="submit">Submit</button>
	</form> --%>
	<!-- we need to jar file of tamcat-embed-jaspar for run the jsp in web because boot can return json file  -->
</body>
</html>