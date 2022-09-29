
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

<%
	String uname = "", pword = "", remem = "";
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie ck : cookies) {
			if (ck.getName().equals("cookieUser")) {
				uname = ck.getValue();
			} else if (ck.getName().equals("cookiePass")) {
				pword = ck.getValue();
			} else if (ck.getName().equals("cookieCheck")) {
				remem = ck.getValue();
			}
		}
	}
%>

<div class="container">
	<div class="header">
		<div class="cancel">
			<a href="home">
				<img src="<c:url value="/pics/cancel.png" />" style="width:15px; heigth:15px;">
			</a>
		</div>
		<div class="avatar">
			<img src="<c:url value="/pics/login.png" />" style="width:200px; heigth:200px;">
		</div>
	
	</div>
	<div class="body">
		<form action="${pageContext.request.contextPath }/login" method="post" onsubmit="return submitForm()">
			<label for="usermail"><b>Username</b></label>
			<input id="us" type="text" name="usermail" placeholder="Enter Username" value="<%= uname%>">
			<br><br>
			<label for="password"><b>Password</b></label>
			<input id="pw" type="password" name="password" placeholder="Enter Password" value="<%= pword%>">
			<br><br>
			<div style="color: red;">${error}</div>
			<br>
			<input type="submit" id="login" value="Login">
			<br>
			<input type="checkbox" name="remember" value="1" 
			<%= "1".equals(remem) ? "checked='/checked'" : ""%>
			>Remember me
		</form>
		<br>
	</div>
	<div class="footer">
		<button id="cancel">Cancel</button>
		<p style="float:right">Forgot <a href="#">password?</a></p>
	</div>
</div>

<script type="text/javascript" src='<c:url value="/style/login.js" />'></script>

</body>
</html>