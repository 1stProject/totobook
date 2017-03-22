<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var = "ctx"	value="${pageContext.request.contextPath }"/>


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
				<td><img src="$image.do?productId=${product.productId}"
					width="128" height="123"></td>
			</tr>
			<tr>
				<td><a href="detail.do?productId=${product.productId}">

						${product.name}</a> <br> ${product.productprice }원</td>
			</tr>
		</table>

		</c:forEach>

	<input type="button" value="왕">
	</div>





</body>
</html>