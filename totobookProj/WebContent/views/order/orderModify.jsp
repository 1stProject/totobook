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
<form action = "${ctx }/order/modify.do" method = "post">
<h3>배송지 수정</h3>
<div style = "display:block;">
<table class = "table table-striped table-bordered table-hover">
	<tr>
		<th>주문번호</th>
		<td>${order.orderId }</td>
	</tr>
	<tr>
		<th>회원 아이디</th>
		<td>${order.member.memberId }</td>
	</tr>
	<tr>
		<th>기존 주소</th>
		<td>${order.ordWay}</td>
	</tr>
	<tr>
		<th>수정 될 주소</th>
		<td><input type = "text" name = "addr" placeholder = "사용자 정보에서 바뀌지 않습니다." size = 50 class = "form-control"></td>
	</tr>
	<input type = "hidden" name = "orderId" value = "${order.orderId }">
</table>
</div>
<input type = "submit" value = "수정완료" class = "btn btn-success" style="float:right;">
</form>
</div>


</div>
<footer>
		<%@include file="../foot/footer.jspf"%>
	</footer>
</body>
</html>