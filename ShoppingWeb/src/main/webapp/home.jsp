<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="header.jsp">
	<c:param name="title" value="Home page"></c:param>
</c:import>


<div class="row home">
	<c:forEach items="${listP }" var="p">
		<div class="col-lg-4 col-md-6">
			<a href="InforProductController?id=${p.id }">
				<div class="card"> 
					<div class="img"><img src="${p.src }" style="width: 200px; height: auto;"></div>
					<div class="type">${p.type }</div>
					<div class="name">${p.name }</div>
					<div class="price">$${p.price }</div>
					<form class="addCart" action="addToCart?action=addCart&id=${p.id }&name=${acc.name }" method="post">
						<input type="submit" value="Add to cart" name="cart">
					</form> 
				</div>	
			</a>
		</div>
	</c:forEach>
		
</div>

<div class="paging">
	<c:forEach var="i" begin="1" end="${endPage }">
		<a class="pag ${tag == i ? 'active' : '' }" href="ListController?indexP=${i }">${i }</a>
	</c:forEach>
	
</div>


<c:import url="footer.jsp"></c:import>