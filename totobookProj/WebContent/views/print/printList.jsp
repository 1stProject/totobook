<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var = "ctx" value = "${pageContext.request.contextPath }"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href = "${ctx }/css/layout.css">
<title></title>
</head>
<body>
<header>
	<%@ include file = "/views/head/header.jspf" %>
</header>
<nav>
	<%@ include file = "/views/left/leftMyPage.jsp" %>
</nav>
<div class = "contents-wrap">
<h2 class="page-title">나의 사진 목록</h2>
<div class="table-responsive col-sm-10 col-lg-10">
<table class = "table table-striped table-bordered table-hover">
	<colgroup>
		<col width = "10%"/>
		<col width = "30%"/>
		<col width = "*"/>
		<col width = "10%"/>
		<col width = "10%"/>
	</colgroup>
	<thead>
		<tr>
			<th>사진 인화 번호</th>
			<th>사진 옵션</th>
			<th>상품 이름</th>
			<th class="text-center">주문하기</th>
			<th class="text-center">삭제하기</th>
		</tr>
	</thead>
	<tbody>
	
	<c:forEach items = "${list }" var = "print">
		<tr>
			<td>${print.printId }</td>
			<td>${print.optionDesp }</td>
			<td>${print.product.name }</td>
			<td class="text-center"><a class = "btn btn-primary" href = "${ctx }/order/register.do?printId=${print.printId}">주문하기</a></td>
			<td class="text-center"><a class = "btn btn-default" href = "${ctx }/print/remove.do?printId=${print.printId }">삭제하기</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</div>
</div>
</body>
</html>