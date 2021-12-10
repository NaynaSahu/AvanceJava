<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-image: url('bg12.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
}
</style>
</head>
<body>
<center>
		<h1>Student Management</h1>
		<form action="/StudentCtl" method="post">
			
			<table>
				<tr>
					<td><input type="text" name="roll" placeholder="Roll Number"></td>
					
				</tr>
				<tr>
					<td><input type="text" name="fname" placeholder="First Name"></td>
				</tr>
				<tr>
					<td><input type="text" name="lname" placeholder="Last Name"></td>
				</tr>
				<tr>
					<td><input type="text" name="session" placeholder="Session"></td>
				</tr>
				
				
				<tr>
					<td><center> <input type="submit" value="Add" name = "operation">
					<input type="submit" value="Delete" name = "operation">
					<input type="submit" value="Modify" name = "operation"></center></td>
				</tr>
				
			</table>
			
		</form>
	</center>
</body>
</html>