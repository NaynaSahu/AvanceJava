<%@page import="App.RegistrationBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% RegistrationBean bean = (RegistrationBean)session.getAttribute("bean");
	
	boolean userLogedIn = bean!=null;
	
	String WelcomeMsg="Hi ";
	if(userLogedIn){
	//String fn =	bean.getFname();
	String fname = (String)session.getAttribute("fname");
	WelcomeMsg+=fname;
	}else{
	WelcomeMsg+="Guest";	
	 } %>
	
	<%-- <td  width="90%"><a href="http://localhost:8080/WebApp2/WelcomeIndex.jsp">Welcome</a>|
	<% if(userLogedIn){
	       
	%><a href="http://localhost:8080/WebApp2/LoginView.jsp">Log Out</a><br>
	<br>
	<%}else{
		
		%><a href="http://localhost:8080/WebApp2/LoginView.jsp">Log In</a><br>
	<br>
	<%} %>
	</td> --%>
	  <td ><a href="http://localhost:8080/WebApp2/WelcomeIndex.jsp">Welcome</a>|
	<% if(userLogedIn){
	       
	%><a href="http://localhost:8080/WebApp2/LoginCtl?operation=logout">Log Out</a><br>
	<br>
	<%}else{
		
		%><a href="http://localhost:8080/WebApp2/LoginView.jsp">Log In</a><br>
	<br>
	<%} %>
            
                <img alt="" src=".\img\customLogo.png"><br>
                <h3>&#128516<i>
                <%=WelcomeMsg%></h3></i>
            
       
   <%--  </tr>
     <tr>
        <td >
            <h3>&#128516<i>
                <%=WelcomeMsg%></h3></i>
        </td>
    </tr> --%>
    <%if(userLogedIn){ %>
   
    <a href="">Home</a>|
    <a href="">Contact Us</a>|
    <a href="">Tutorial</a>|
    
    <%} %>
	
	
	
	</table>
	
	<%-- <%
	String fn = (String) session.getAttribute("user");
	if (fn != null) {
	%><a href="http://localhost:8080/WebApp2/WelcomeIndex.jsp">Welcome</a>
	
	<a href="http://localhost:8080/WebApp2/LoginView.jsp">Log Out</a>
	<br>
	<img alt="" src=".\img\customLogo.png"><br>
	&#128516
	<i> Hi <%=fn%> !
	</i>
	<%
	} else if(fn==null){
	%>
	<a href="http://localhost:8080/WebApp2/WelcomeIndex.jsp">Welcome</a>
	
	<a href="http://localhost:8080/WebApp2/LoginView.jsp">Log In</a>
	<br>
	<img alt="" src=".\img\customLogo.png"><br>
	&#128516
	<i> Hi Guest ! </i>
	<%
	}
	%> --%>


	<hr>
	<%-- <table>
		<tr>
			<td><a href="http://localhost:8080/WebApp2/WelcomeIndex.jsp">Welcome</a></td>
			<td><a href="http://localhost:8080/WebApp2/LoginView.jsp">Log In</a> </td><br><br>
		</tr>
		
		<tr>
			<td> </style> <img alt="" src=".\img\customLogo.png" style=float:left>
			<hr></td>
			<%
			String fn = (String) session.getAttribute("user");
			if (fn != null) {
			%>&#128516
			<i> Hi <%=fn%> !
			</i>
			<%
			}
			%>


		</tr>
	</table> --%>

	<%-- <%
	String fname1 = (String) request.getAttribute("fname1");
	if (fname1 != null) {
	%>&#128516<i> Hi
	<%=fname1%> ! </i>

	<%
	}
	%> --%>


</body>
</html>