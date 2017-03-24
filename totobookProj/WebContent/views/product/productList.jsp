<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
	
</script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${ctx }/css/layout.css">
<head>
<title>상품리스트</title>
</head>
<body>
	<header>
		<%@ include file="/views/head/header.jspf"%>
	</header>
	<div class="contents-wrap">


		<c:forEach items="${product }" var="product">
			<table class="section">
				<tr>
				<td>상품</td>
					<td><img
					src="${ctx }/product/image.do?productId=${product.productId}"
					width="128" height="123">
						</td>
				</tr>
				<tr>
					<td><a href="detail.do?productId=${product.productId}">${product.name}</a> 
					<br> ${product.productprice }원</td>
				</tr>
			</table>

		</c:forEach>
	</div>





</body>
</html>