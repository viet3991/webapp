<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="header.jsp">
	<c:param name="title" value="Cart page"></c:param>
</c:import>


<div class="row home">
	<form action="pay?usermail=${acc.usr }&adr=${acc.address }" method="post">
		<h4 class="titleCart">Order Details</h4>
		<table id="customers">
			<tr>
				<th>Image</th>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Amount</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${sessionScope.cart.items}" var="p">
				<tr>
					<td><img src="${p.src }" style="width:60px;"></td>
					<td>${p.name }<br>ID: ${p.id }</td>
					<td>${p.price }</td>				
					<td>
						<a href="addToCart?action=sub&id=${p.id }"><span class="addsub">-</span></a>
						<span class="quantity">${p.number }</span>
						<a href="addToCart?action=add&id=${p.id }"><span class="addsub">+</span></a>
					</td>
					<c:set var="amount" value=" ${ Math.round((p.price * p.number ) * 100.0) / 100.0 }"></c:set>
					<td>${amount }</td>
					<td><a href="addToCart?action=remove&id=${p.id }"><span class="remove">x</span></a></td>
				</tr>
			</c:forEach>
			<tr><td colspan="6" style="text-align: center;">-------------------------------------</td></tr>
			<tr>
				<td colspan="4"><b>Total</b></td>
				<td colspan="2">${total }</td>
			</tr>
			<tr>
				<td colspan="4"><b>Discount code</b></td>
				<td colspan="2"><input type="text" name="discount"></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="Submit" id="saveDB">
	</form>		
</div>

<c:import url="footer.jsp"></c:import>