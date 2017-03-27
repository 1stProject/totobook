<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${ctx }/css/layout.css">
<link rel="stylesheet" href="${ctx }/css/sidebarheader.css">
<head>
<title>상품리스트</title>
</head>
<body>
	<header>
		<%@ include file="/views/head/header.jspf"%>
	</header>
	<c:forEach items="${product }" var = "product" varStatus="status">
	<c:choose>
	<c:when test="${status.count mod 3 eq 1 }">
	<div class="col-md-offset-2 col-md-12" style="display:inline-block">
		<div class = "col-sm-3" >
		<table class="section table table-bordered">
			<colgroup>
				<col width = "*%"/>
				<col width = "40%"/>
			</colgroup>
				<tr>
				<td><img src="${ctx }/product/image.do?productId=${product.productId}" width="128" height="123"></td>
				<td style="vertical-align: middle;"><a href="detail.do?productId=${product.productId}">${product.name}</a>
					<br><c:if test="${product.category eq 'BOOK' }"> ${product.productprice }원</c:if>
					</td>
			</table>
				</div>
		</c:when>
		<c:otherwise>
			<div class = "col-sm-3" >
		<table class="section table table-bordered">
			<colgroup>
				<col width = "*%"/>
				<col width = "40%"/>
			</colgroup>
				<tr>
				<td><img src="${ctx }/product/image.do?productId=${product.productId}" width="128" height="123"></td>
				<td style="vertical-align: middle;"><a href="detail.do?productId=${product.productId}">${product.name}</a>
					<br><c:if test="${product.category eq 'BOOK' }"> ${product.productprice }원</c:if>
					</td>
			</table>
				</div>
				<c:if test="${status.count mod 3 eq 0}">
					</div>
				</c:if>
		</c:otherwise>
		</c:choose>
	</c:forEach>

</body>

<footer>
	<%@ include file = "/views/foot/footer.jspf" %>
</footer>


</html>