<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<c:set var = "ctx" value = "${pageContext.request.contextPath }"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${ctx }/css/layout.css">
<link rel="stylesheet" href="${ctx }/css/sidebarheader.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
<header>
	<%@ include file = "/views/head/header.jspf" %>
</header>
<nav>
	<%@ include file = "/views/left/leftMyPage.jsp" %>
</nav>

<div class="contentsContainer">
<div class="table-responsive col-sm-8 col-lg-8 col-md-offset-2">
<h1>나의 사진 목록</h1>
<table class = "table table-striped table-bordered table-hover">
	<colgroup>
		<col width = "20%"/>
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
	<c:choose>
	<c:when test="${empty list }">
	<tr>
		<td colspan = 5 class = "text-center">사진인화 내역이 없습니다</td>
	</tr>
	</c:when>
	<c:otherwise>
	<c:forEach items = "${list }" var = "print">
		<tr>
			<td><a href = "${ctx }/print/view.do?printId=${print.printId }">${print.printId }</a></td>
			<td>${print.optionDesp }</td>
			<td>${print.product.name }</td>
			<td class="text-center"><a class = "btn btn-primary" href = "${ctx }/order/register.do?printId=${print.printId}">주문하기</a></td>
			<td class="text-center"><a class = "btn btn-default" href = "${ctx }/print/remove.do?printId=${print.printId }">삭제하기</a></td>
		</tr>
	</c:forEach>
	</c:otherwise>
	</c:choose>
	</tbody>
</table>
</div>
</div>
<footer>
		<%@include file="../foot/footer.jspf"%>
	</footer>

</body>
</html>