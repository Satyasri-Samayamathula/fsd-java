<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h3>${message}</h3>
	<h1>Flight Application</h1>
	<br>
	<a href="addflight.jsp">Add New Flights</a>
	<br>
	<a href="showflights.do">Show All Flights</a>
	<br>
	<form action="carrier.do">
		Carrier: <select name="carrier">
			<option value = "Indigo">Indigo</option>
			<option value = "JetAirways">JetAirways</option>
			<option value = "AirIndia">AirIndia</option>
		</select> <input type="submit" value="Find">
	</form>
</body>
</html>