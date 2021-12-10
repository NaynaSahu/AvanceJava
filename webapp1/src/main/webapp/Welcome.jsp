<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title action = "WelcomeCtl" method="Post">Welcome Page</title>
</head>
<center>
<body Style = "background-color : yellow">
<%@ include file = "Header.jsp"  %>
<h1>Welcome To Rays</h1>
<h2>HI<% String name = (String) request.getAttribute("fna"); %><%= name %></h2>
<hr>
<%@ include file = "Footer.jsp"  %>
</body>
</center>
</html>