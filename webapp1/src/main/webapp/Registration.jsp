<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<center>
<body Style = "background-color : yellow">
<%@ include file = "Header.jsp"  %>
<form action="RegistrationCtl" method = "POST">
		<h1>Registration Page</h1>
			
		<table>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="fname"></td>
				<td><%String error =(String)request.getAttribute("empty");
		if(error !=null){
	%>
	<font color= "red"><%= error %> </font>
<%} %></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lname"></td>
				<td><%String error1 =(String)request.getAttribute("empty1");
		if(error1 !=null){
	%>
	<font color= "red"><%= error1 %> </font>
<%} %></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="radio" value="male" name="Gender">male
				<input type="radio" value="female" name="Gender">female 
				<input type="radio" value="other" name="Gender">other</td>
				<td><%String error2 =(String)request.getAttribute("empty2");
		if(error2 !=null){
	%>
	<font color= "red"><%= error2 %> </font>
<%} %></td>  
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" name="Email"></td>
				<td><%String error3 =(String)request.getAttribute("empty3");
		if(error3 !=null){
	%>
	<font color= "red"><%= error3 %> </font>
<%} %></td>
			</tr>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="User"></td>
				<td><%String error4 =(String)request.getAttribute("empty4");
		if(error4 !=null){
	%>
	<font color= "red"><%= error4 %> </font>
<%} %></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="Password"></td>
				<td><%String error5 =(String)request.getAttribute("empty5");
		if(error5 !=null){
	%>
	<font color= "red"><%= error5 %> </font>
<%} %></td>

			</tr>
			<tr>
				
				<td><input type="submit" name="submit" value="submit"></td>
				<td><a href="http://localhost:8080/webapp1/Login.jsp" >Go Back To Login</a>
			</tr>
		</table>
	</form>
<%@ include file = "Footer.jsp"  %>
</body>
</center>
</html>