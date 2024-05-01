<%@page import="java.util.List"%>
<%@page import="com.demo.main.beans.User"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get All User Details</title>
</head>
<body>
	<div style="width: 100%; text-align: center;">
		<h3> All User Details </h3>
		<hr/>
		<%
			List<User> users_list = (List) request.getAttribute("model_allusers");
			for(User user : users_list)
			{
				%>
					<b> Name : </b> <% out.println(user.getName()); %> <br/>
					<b> Email : </b> <% out.println(user.getEmail()); %> <br/>
					<b> Gender : </b> <% out.println(user.getGender()); %> <br/>
					<b> City : </b> <% out.println(user.getCity()); %> <br/>
					<hr/>
				<%
			}
		%>
		
	</div>
</body>
</html>