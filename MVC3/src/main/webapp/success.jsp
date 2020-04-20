<%@page import="com.example.model.Todo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

Todo todo = (Todo)request.getAttribute("todo");
out.println("TodoID: "+todo.getId()+" TodoName: "+todo.getName()+" CompletedBy: "+todo.getCompletedBy());
%>

</body>
</html>