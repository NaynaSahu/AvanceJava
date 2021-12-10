<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
C.jsp
<% request.setAttribute("cold", "maza");
   String f = (String) request.getAttribute("fruit");
   String f1 = (String)request.getAttribute("mithai");
   String f2 = (String)request.getAttribute("cold");
%>
<%= f%>
<%=f1 %>
<%=f2 %>

</body>
</html>