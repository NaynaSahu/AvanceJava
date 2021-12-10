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
			<b><i>RAYS TECH</i></b>
		</h1>
		<%
		String error = (String) request.getAttribute("error");
		if (error != null) {
		%>
		<font color="red"><%=error%> </font>
		<%
		}
		%>
		<form action="LoginCtl" method="post">
			<table>
				<tr>

					<td><input type="text" name="User"
						placeholder="Enter User Name"> <%
 String empty = (String) request.getAttribute("empty");
 if (empty != null) {
 %><font color="red"><%=empty%></font> <%
 }
 %></td>
				</tr>
				<tr>

					<td><input type="Password" name="Password"
						placeholder="Enter Password"> <%
 String empty1 = (String) request.getAttribute("empty1");
 if (empty1 != null) {
 %><font color="red"><%=empty1%></font> <%
 }
 %></td>
				</tr>
				<tr>
					<td><input type="submit" value="Log In"></td>

				</tr>
				<tr>
					<td>Dont have an Account ?<a
						href="http://localhost:8080/WebApp2/Registration.jsp">Sign UP</a></td>
				</tr>
				<tr>
					<td><a href="http://localhost:8080/WebApp2/ForgetPassword.jsp">Forgot
							Password</a></td>
				</tr>
						</table>
		</form>
	</center>
	<%@ include file="Footer.jsp"%>
</body>
</html>