<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="header.jsp">
	<c:param name="title" value="Admin page"></c:param>
</c:import>


<div class="row home admin">
	<h4 class="titleCart">List Products</h4>
	<table id="customers">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Image</th>
			<th>Type</th>
			<th>Brand</th>
			<th colspan="2">Select</th>
			<th>Cart</th>
		</tr>
		<c:forEach items="${list }" var="p">
			<tr>
				<td><c:out value="${p.id }"/></td>
				<td><c:out value="${p.name }"/></td>
				<td><c:out value="${p.description }"/></td>
				<td><c:out value="${p.price }"/></td>
				<td><img src="${p.src }" style="width:40px;"></td>
				<td><c:out value="${p.type }"/></td>
				<td><c:out value="${p.brand }"/></td>
				<td><a href="#">Delete</a></td>
				<td><a href="#">Edit</a></td>
				<td>
					<form class="addCart" action="addToCart?action=addCart&id=${p.id }&name=${acc.name }" method="post">
						<input type="submit" value="Add to cart" name="cart">
					</form>  
				</td>
			</tr>
		</c:forEach>
		
	</table>
	<div class="createP">
		<a href="#">Add new product</a>	
	</div>
	
</div>

<c:import url="footer.jsp"></c:import>