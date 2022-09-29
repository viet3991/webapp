<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="header.jsp">
	<c:param name="title" value="${product.name }"></c:param>
</c:import>


<div class="row home image">
	<div class="col-12 nameP">
		<h4>${product.name }</h4>
		<hr>
	</div>

	<div class="col-lg-5 imgP">
		<img alt="" src="${product.src }" style="width: 300px; height: auto;">
	</div>
	
	<div class="col-lg-5 desP">
		<div class="priceP">$ ${product.price }</div>
		<div class="des">${product.description }</div>
		<div class="add">
			<form action="addToCart?action=addCart&id=${product.id }&name=${acc.name }" method="post">
				<input type="submit" value="Add to cart" name="cart">
			</form> 
		</div>
		
	</div>	
</div>

<c:import url="footer.jsp"></c:import>