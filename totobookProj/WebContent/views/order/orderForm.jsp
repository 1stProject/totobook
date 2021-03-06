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
		<div class="title_left">마이페이지</div>
		<ul class="title_ul">
			<li class="title_li"><a href="${ctx }/views/main.jsp">HOME</a></li>
			<li class="title_li_icon">></li>
			<li class="title_li"><a href="${ctx }/order/list.do">마이페이지</a></li>
		</ul>
	</div>
	
	<nav>
		<%@ include file = "/views/left/leftMyPage.jsp" %>
	</nav>

		<div class="contentsWithLeft">
		<h3>주문 창</h3>
		<form method="post" action="${ctx }/order/register.do">
		<div style="display:block;">
			<div class="table-responsive col-sm-9 col-lg-9">
				<table class="table table-striped table-bordered table-hover">
					<colgroup>
						<col width="20%" />
						<col width="%" />
					</colgroup>
					<tr>
						<th>회원 아이디</th>
						<td>${order.member.memberId }</td>
					</tr>
					<tr>
						<th>회원 이름</th>
						<td>${order.member.name }</td>
					</tr>
					<tr>
						<th>배송주소</th>
						<td>${order.member.address }</td>
					</tr>
					<tr>
						<th>핸드폰번호</th>
						<td>${order.member.phone }</td>
					</tr>
					<tr>
						<th>카테고리</th>
						<td>${order.category }</td>
					</tr>
					<tr>
						<th>번호</th>
						<td>${order.bookPhotoId }</td>
					</tr>
					<tr>
						<th>결제 수단</th>
						<td><input type="radio" name="payment" value="신용카드">
							신용카드 <input type="radio" name="payment" value="무통장입금">
							무통장입금 <input type="radio" name="payment" value="계좌이체">
							계좌이체 </td>
					</tr>
					<tr>
						<th>가격</th>
						<td><input type="text" class="ui-corner-all form-control"
							name="price" value="${order.ordPrice }" readonly></td>
					</tr>

				</table>
				<input type="hidden" value="${order.member.memberId }" name="memberId">
				<input type="hidden" value ="${order.bookPhotoId }" name = "bookPhotoId">
				<input type="hidden" value = "${order.category }" name = "category">
			</div>
			</div>
		
			<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
			<br><br>&nbsp;&nbsp;&nbsp; <input type="submit" value="주문하기!"
				class="btn btn-success">
		</form>
	</div>
</div>
	<footer>
		<%@include file="../foot/footer.jspf"%>
	</footer>

</body>
</html>