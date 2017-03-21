<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="content">

		<c:forEach items="${product }" var="product">

		<table class="section">
			<tr>
				<td><img src="/product/image.do?productId=${product.product_id}"
					width="128" height="123"></td>
			</tr>
			<tr>
				<td><a href="/recipe/detail.do?rproductId=${product.product_id}">

						${product.name}</a> <br> ${product.price }원</td>
			</tr>
		</table>

		</c:forEach>

	
	</div>





</body>
</html>