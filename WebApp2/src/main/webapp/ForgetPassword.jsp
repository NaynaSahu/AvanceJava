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
	<%@ include file="Header.jsp"%>
	<center>
		<h1>
			<b><i>You are Welcomed to Gajni Family !</i></b>
		</h1>
	</center>
	<form action="ForgetPassword" method="post">
		<center>
			<table>
				<%
				String NotFound = (String) request.getAttribute("NotFound");
				if (NotFound != null) {
				%>
				<font color="red"><%=NotFound%></font>
				<%
				}
				%>

				<tr>
					<td>Enter Email Address :<input type="Email" name="Email"
						placeholder="Email Address"></td>
				</tr>
				<tr>
					<td>
						<%
						String pass = (String) request.getAttribute("pass");
						if (pass != null) {
						%><font>Here is your Password &#128521 - <%=pass%></font> <%
 }
 %>
					</td>

				</tr>
				<tr>
					<td><input type="submit" value="View Password"></td>
				</tr>

				<tr>
					<td>Go Back to <a
						href="http://localhost:8080/WebApp2/LoginView.jsp">Log In</a> Page
					</td>
				</tr>
			</table>
		</center>
	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>