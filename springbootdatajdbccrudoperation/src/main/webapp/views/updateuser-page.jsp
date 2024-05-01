<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
</head>
<body>
	<div style="width: 100%; text-align: center;">
	
		<h2> Update User </h2>
	
		<form action="updateUserForm" method="post">
			Name : <input type="text" name="name1" /> <br/> <br/>
			Email : <input type="text" name="email1" /> <br/> <br/>
			Gender : <input type="text" name="gender1" /> <br/> <br/>
			City : <input type="text" name="city1" /> <br/> <br/>
			<input type="submit" value="Update User" />
		</form>
	</div>
</body>
</html>