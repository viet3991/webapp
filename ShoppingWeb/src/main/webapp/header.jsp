
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
  
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>


<link href="${pageContext.request.contextPath }/style/asm3.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/style/inforProduct.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/style/admin.css" rel="stylesheet" type="text/css">

<title>${param.title }</title>
</head>
<body>

<div class="container">
	<div class="row header">
		<div class="col-lg-1 logo">
			<img src="pics/logo.png" style="width:60px; heigth:60px;">
		</div>
		<div class="col-lg-6 content">
			<a href="home" style="text-decoration: none;"><h1>DI ĐỘNG FX</h1></a>
		</div>

		<div class="search col-lg-5">
		    <form action="SearchController?indexS=1&role=${sessionScope.acc.role }" method="post">
			      <input type="search" placeholder="Tìm kiếm..." name="txtSearch" required value="${txtS }" class="txtSearch">
			      <input type="submit" value="Search" class="btnSearch">
		    </form>
		</div>
	</div>
	

	<div class="topnav">
		<a href="${pageContext.request.contextPath }/ListController" id="home">Home</a>
		<a href="#">Category</a>
		<a href="#">About us</a>
		
		<c:if test="${sessionScope.acc != null }">
			<a href="${pageContext.request.contextPath }/logout" id="logout">Logout</a>
		</c:if>
		
		<c:if test="${sessionScope.acc == null }">
			<a href="${pageContext.request.contextPath }/login?action=login" id="login">Login</a>
			<a href="${pageContext.request.contextPath }/login?action=register" id="register">Register</a>
		</c:if>
		
		
		<a href="admin?role=${acc.role }" id="user">Welcome <span id="userMail">${acc.name }</span></a>
		<a href="cart.jsp" id="cart">Cart</a>
		
	</div>
	
	


