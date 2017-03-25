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
<link rel="stylesheet" href = "${ctx }/css/sidebarheader.css">
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
<div class="table-responsive col-sm-9 col-lg-9 col-md-offset-2">
<h1>주문 목록</h1>
<table class = "table table-striped table-bordered table-hover">
	<colgroup>
		<col width="100"/>
		<col width="200"/>
		<col width="200"/>
		<col width="*"/>
		<col width="200"/>
	</colgroup>
	<thead>
		<tr>
			<th>주문 번호</th>
			<th>주문 날짜</th>
			<th>결제 수단</th>
			<th>배송 주소</th>
			<th>상품평 쓰러가기 </th>
		</tr>
	</thead>
	<tbody>
	
<c:forEach items = "${orders }" var = "order">
		<tr>
			<td>${order.orderId }</td>
			<td>${order.ordDate }</td>
			<td>${order.payment }</td>
			<td>${order.ordWay }</td>
			<td><a href = "${ctx }/review/register.do?orderId=${order.orderId}">상품평 쓰러가기</a></td>
		</tr>
</c:forEach>
	</tbody>
</table>
<div class = "text-right">
			총 ${arraysize}건<br>
			</div>
			<div class = "text-center">
			<c:forEach begin="1" end="${maxBorder }" step="1" varStatus="status">
				<a href="${ctx }/order/list.do?borderId=${status.count}">${status.count }</a>
			</c:forEach>
			<br>
</div>
</div>
<footer>
		<%@include file="../foot/footer.jspf"%>
	</footer>
</body>
</html>