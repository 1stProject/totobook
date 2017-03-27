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
<div class="contentsContainer">
	
	<div class="mypageTitle">
		<div class="title_left">마이페이지</div>
		<ul class="title_ul">
			<li class="title_li"><a href="${ctx }/views/main.jsp">HOME</a></li>
			<li class="title_li_icon">></li>
			<li class="title_li"><a href="${ctx }/order/list.do">마이페이지</a></li>
		</ul>
	</div>
	<nav>
		<%@ include file="/views/left/leftMyPage.jsp"%>
	</nav>	
		<!-- <div class="col-sm-7 col-lg-7 col-md-offset-2"> -->
		<div class = "contentsWithLeft">
	<h3>주문 목록</h3>
	<table class = "table table-striped table-bordered table-hover">
		<colgroup>
			<col width="80"/>
			<col width="100"/>
			<col width="100"/>
			<col width="*"/>
			<col width="150"/>
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
		<c:choose>
		<c:when test="${empty orders }">
		<tr>
			<td colspan = 5 class = "text-center">주문 내역이 없습니다</td>
		</tr>
		</c:when>
		<c:otherwise>
	<c:forEach items = "${orders }" var = "order">
			<tr>
				<td>${order.orderId }</td>
				<td>${order.ordDate }</td>
				<td>${order.payment }</td>
				<td>${order.ordWay }</td>
				<td><a href = "${ctx }/review/register.do?orderId=${order.orderId}">상품평 쓰러가기</a></td>
			</tr>
	</c:forEach>
	</c:otherwise>
	</c:choose>
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
	</div>
	</div>
	<footer>
			<%@include file="../foot/footer.jspf"%>
		</footer>
</body>
</html>