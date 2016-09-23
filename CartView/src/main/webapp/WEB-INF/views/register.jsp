<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		${info }
<form:form action="registerUser" commandName="reg">
<center>
UserName:<form:input path="username"/> <form:errors=path="username"></form:errors><br><br>
Email:<form:input path="emailId"/> <form:errors=path="emailId"></form:errors><br><br>
Password:<form:password path="password"/> <form:errors=path="password"></form:errors><br><br>
<input type="submit" value="Register">
</form:form>
</ceter>
</body>
</html>