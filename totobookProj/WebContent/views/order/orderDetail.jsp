<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href = "${ctx }/css/layout.css">
<link rel="stylesheet" href = "${ctx }/css/sidebarheader.css">
<title>Insert title here</title>
</head>
<body>
	<header>
		<%@ include file="/views/head/header.jspf"%>
	</header>
	<div class="contentsContainer">
	
	<div class="mypageTitle">
		<div class="title_left">관리자 페이지</div>
		<ul class="title_ul">
			<li class="title_li"><a href="${ctx }/views/main.jsp">HOME</a></li>
			<li class="title_li_icon">></li>
			<li class="title_li"><a href="${ctx }/order/list.do">관리자 페이지</a></li>
		</ul>
	</div>
	<nav>
		<%@ include file="/views/left/leftManagePage.jsp"%>
	</nav>	
		<div class = "contentsWithLeft">
	<h3>주문 상세</h3>
		<div class="table-responsive col-sm-7 col-lg-7">
				<table class="table table-striped table-bordered table-hover">
					<colgroup>
						<col width="30%" />
						<col width="*" />
					</colgroup>
					<tr>
						<th>주문번호</th>
						<td>${order.orderId }</td>
					</tr>
					<tr>
						<th>가격</th>
						<td>${order.ordPrice }</td>
					</tr>
					<tr>
						<th>배송주소</th>
						<td>${order.ordWay }</td>
					</tr>
					<tr>
						<th>지불수단</th>
						<td>${order.payment }</td>
					</tr>
					<tr>
						<th>회원아이디</th>
						<td>${order.member.memberId }</td>
					</tr>
					<tr>
						<th>휴대폰번호</th>
						<td>${order.member.phone }</td>
					</tr>
					<tr>
						<th>주문날짜</th>
						<td>${order.ordDate }</td>
					</tr>
					
					<c:choose>
						<c:when test="${order.category eq '사진' }">
						<tr>
							<th>상품명</th>
							<td>${print.product.name }</td>
						</tr>
						<tr>
							<th>옵션</th>
							<td>${print.optionDesp }</td>
						</tr>
						<tr>
							<th>사진보기</th>
							<td><a href="${ctx }/print/view.do?printId=${order.bookPhotoId}">사진보기</a></td>
						</tr>
						</c:when>
						<c:otherwise>
						<tr>
							<th>상품명</th>
							<td>${book.product.name }${category }</td>
						</tr>
						<tr>
							<th>옵션</th>
							<td>${book.option }사실포토북임</td>
						</tr>
						</c:otherwise>
					</c:choose>
				</table>
				<a href="${ctx }/order/modify.do?orderId=${order.orderId}"
					class="btn btn-default">배송지 수정</a>
		</div>
	</div>
	</div>
	<footer>
		<%@include file="../foot/footer.jspf"%>
	</footer>
</body>
</html>