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
	
	<%-- <%
	String fname1 = (String) request.getAttribute("fname1");
	if (fname1 != null) {
	%>&#128516<i> Hi
	<%=fname1%> ! </i>

	<%
	}
	%> --%>

	<center>
		<h1>
			<b><i> Welcome To Rays Family !</i></b>
		</h1>
	</center>

	<%@ include file="Footer.jsp"%>
</body>
</html>