<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link href="index.css" rel="stylesheet" type="text/css">
</head>
<body>



<div class="topnav">
	<a id="home" href="${pageContext.request.contextPath }/ListController">Home</a>
	<a>Phone</a>
	<a>Tablet</a>
	<a>Laptop</a>
	<a href="${pageContext.request.contextPath }/logout" Style="float: right;" id="logout">Logout</a>
	<a id="admin" Style="float: right;">Welcom, <b><%= request.getAttribute("userLogin") %></b></a>
</div>


<div class="leftnav">
	<a>Dashboard</a>
	<a>Staff Manager</a>	
	<a>Chart</a>
	<a>User</a>
	<a>Product</a>
</div>

<div class="content">
	<div class="table1">
		<table>
			<tr>
				<th colspan="4">Members of the team</th>
			</tr>
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Student ID</td>
				<td>Class</td>
			</tr>
			<tr>
				<td>1</td>
				<td>Member 1</td>
				<td>Member Code 1</td>
				<td>Class 1</td>
			</tr>
			<tr>
				<td>2</td>
				<td>Member 2</td>
				<td>Member Code 2</td>
				<td>Class 2</td>
			</tr>
			
		</table>
	</div>
		
</div>






</body>
</html>