<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
B.jsp
<% request.setAttribute("mithai", "gulab jamun"); %>
<%response.sendRedirect("C.jsp"); %>
</body>
</html>