<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
	<div style="width: 100%; text-align: center;">
		<h3> User Details </h3>
		Name : ${model_user.getName()} <br/> <br/>
		Email : ${model_user.getEmail()} <br/> <br/>
		Gender : ${model_user.getGender()} <br/> <br/>
		City : ${model_user.getCity()} <br/> <br/>
	</div>
</body>
</html>