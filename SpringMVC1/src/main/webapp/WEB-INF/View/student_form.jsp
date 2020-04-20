<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Form</title>
</head>
<body>
<h4>Student Form</h4>
<form:form action="processForm" method="post" modelAttribute="student"><br>
<label>First Name:</label><form:input path="firstName"/><br>
<label>Last Name:</label><form:input path="lastName"/><br>


<label>Country: </label> <form:select path="country">
<form:options items="${student.countryNames }"/>
</form:select>

<br>
<label>Favorite Language:</label>
Java<form:radiobutton path="favoriteLanguage" value="java"/>
Python<form:radiobutton path="favoriteLanguage" value="Python"/>
PHP<form:radiobutton path="favoriteLanguage" value="PHP"/>
Ruby<form:radiobutton path="favoriteLanguage" value="Ruby"/>
<br>

<input type = "submit">
</form:form>
</body>
</html>