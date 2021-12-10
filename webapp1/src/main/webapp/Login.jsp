
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<center>
	<body Style="background-color: yellow">
		<%@ include file="Header.jsp"%>

		<form action="LoginCtl" method="Post">
			<h1>
				<i>Login page</i>
			</h1>
			<%
			String error = (String) request.getAttribute("error");
			if (error != null) {
			%>
			<font color="red"><%=error%> </font>
			<%
			}
			%>
			<table>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="Username"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="Password"></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="Login"
						style="font-size: 20px"><br> <br>
					<a href="http://localhost:8080/webapp1/Registration.jsp">
							Create an Account </a></td>
				</tr>
			</table>

		</form>
		<%@ include file="Footer.jsp"%>
	</body>
</center>
</html>