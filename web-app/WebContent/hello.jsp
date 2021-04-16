<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello</h1>
	<h2>Welcome Java Server</h2>
	<%! int counter=100; %>
	<h3>your no:<%= ++counter %></h3>
	<% Date d=new Date(); %>
	<h3>log: <%= d %></h3>
	
</body>
</html>