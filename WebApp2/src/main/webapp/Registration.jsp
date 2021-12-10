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
<%@ include file = "Header.jsp"  %>
	<center>
	
		<h1>
			<b><i>RAYS TECH</i></b>
		</h1>
		<form action="RegistrationCtl" method="post">
		<tr>
					<td>
						<%
						String success1 = (String) request.getAttribute("success");
						if (success1 != null) {
						%><font color="green"><%=success1%></font> <%
 }
 %>
					</td>
				</tr>
	

			
				<table>
					<tr>
						<td><input type="text" name="fname" placeholder="First Name">
						<%
						String empty = (String) request.getAttribute("empty");
						if(empty!=null){
						%><font color="red"><%=empty %></font>
						<%} %>
						<%String Reg2 = (String)request.getAttribute("reg2");
						if(Reg2 != null){
						%>
						<font color="red"><%=Reg2 %></font>
						<%}
						%>
						</td>
						
						

					</tr>
					<tr>
						<td><input type="text" name="lname" placeholder="Last Name">
						<% String empty1 = (String) request.getAttribute("empty1");
						if(empty1 != null){
						%>
						<font color="red"><%=empty1 %></font>
						<%} %>
						<%String Reg3 = (String)request.getAttribute("Reg3");
						if(Reg3 != null){
						%>
						<font color="red"><%=Reg3 %></font>
						<%}
						%>
						</td>
						
					</tr>
					<tr>
						<td><input type="text" name="User" placeholder="User Name">
						<% String empty2 = (String) request.getAttribute("empty2");
						if(empty2 != null){
						%>
						<font color="red"><%=empty2 %></font>
						<%} %>
						<%String Reg4 = (String)request.getAttribute("Reg4");
						if(Reg4 != null){
						%>
						<font color="red"><%=Reg4 %></font>
						<%}
						%>
						</td>
					</tr>
					<tr>
						<td><input type="Email" name="Email"
							placeholder="Email Address">
							<% String empty3 = (String) request.getAttribute("empty3");
						if(empty3 != null){
						%>
						<font color="red"><%=empty3 %></font>
						<%} %>
						<%String Reg5 = (String)request.getAttribute("Reg5");
						if(Reg5 != null){
						%>
						<font color="red"><%=Reg5 %></font>
						<%}
						%>
							</td>
					</tr>
					<tr>
						<td><input type="Password" name="Password"
							placeholder="New Password">
							<% String empty4 = (String) request.getAttribute("empty4");
						if(empty4 != null){
						%>
						<font color="red"><%=empty4 %></font>
						<%} %>
						<%String Reg1 = (String)request.getAttribute("Reg1");
						if(Reg1 != null){
						%>
						<font color="red"><%=Reg1 %></font>
						<%}
						%>
							</td>
					</tr>
					<tr>

						<td>DATE OF BIRTH<input type="Date" name="dob">
						<% String empty5 = (String) request.getAttribute("empty5");
						if(empty5 != null){
						%>
						<font color="red"><%=empty5 %></font>
						<%} %>
						</td>

					</tr>
					<tr>
						<td>Gender<input type="radio" name="Gender" value="Male">Male
							<input type="radio" name="Gender" value="Female">Female <input
							type="radio" name="Gender" value="Other">Other
							<% String empty6 = (String) request.getAttribute("empty6");
						if(empty6 != null){
						%>
						<font color="red"><%=empty6 %></font>
						<%} %>
						</td>
					</tr>

					<tr>
						<td><center>
								<input type="submit" value="Sign In" name="operation">
							<input type="submit" value="Reset" name="operation"></center> </td>
					</tr>
					<tr>
					<td> <center>
					Have an Account ?<a href="http://localhost:8080/WebApp2/LoginView.jsp" >Log In</a>
					</center></td> </tr>

				</table>
			
		</form>
	</center>
	
<center><%@ include file = "Footer.jsp"  %>
</body>
</html>