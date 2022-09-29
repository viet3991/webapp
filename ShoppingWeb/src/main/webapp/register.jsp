
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>


<link href="<c:url value="/style/login.css" />" type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

<div class="container">
	<div class="header">
		<div class="cancel">
			<a href="home">
				<img src="<c:url value="/pics/cancel.png" />" style="width:15px; heigth:15px;">
			</a>
		</div>
		<div class="avatar register">
			<h4>Register</h4>
		</div>
	
	</div>
	<div class="body">
		<form action="${pageContext.request.contextPath }/register" method="post" onsubmit="return submitFormRegister()">
			<label for="usermail"><b>Username</b><span style="color: red"> (*)</span></label>
			<input id="us" type="text" name="usermail" placeholder="Enter Username">
			<br>
			<label for="password"><b>Password</b><span style="color: red"> (*)</span></label>
			<input id="pw" type="password" name="password" placeholder="Enter Password">
			<br>
			<label for="repass"><b>Repassword</b><span style="color: red"> (*)</span></label>
			<input id="rpw" type="password" name="repass" placeholder="Enter Repassword">
			<br>
			<label for="role"><b>Role</b><span> (1 = admin, 0 = buyer)</span><span style="color: red"> (*)</span></label>
			<input id="role" type="text" name="role" placeholder="Enter role">
			<br>
			<label for="name"><b>Name</b><span style="color: red">(*)</span></label>
			<input id="nameUser" type="text" name="name" placeholder="Enter name">
			<br>
			<label for="address"><b>Address</b></label>
			<input type="text" name="address" placeholder="Enter address">
			<br>
			<label for="phone"><b>Phone number</b></label>
			<input type="text" name="phone" placeholder="Enter phone number">
			<br>
			<div style="color: red;">${error}</div>
			<br>
			<input type="submit" id="login" value="Register">
			<br>
			
		</form>
		<br>
	</div>
	<div class="footer">
		<button id="cancel">Cancel</button>
	</div>
</div>

<script type="text/javascript" src='<c:url value="/style/login.js" />'></script>

</body>
</html>