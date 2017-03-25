<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<c:set var = "ctx"	value="${pageContext.request.contextPath }"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${ctx }/css/layout.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href = "${ctx }/css/sidebarheader.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<title>totoBook</title>
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
		<%@ include file = "/views/left/leftMyPage.jsp" %>
	</nav>

		<div class="contentsWithLeft">
			<h3>나의 포토북 관리</h3>
			
			<table class="blueListTab">
				<colgroup>
					<col width="50px">
					<col width="220px"> 
					<col width="150px">
					<col width="80px">
					<col width="100px">
					<col width="50px">
					<col width="50px">
				
				</colgroup>
				<tr>
					<th>NO</th>
					<th>포토북 이름</th>
					<th>옵션</th>
					<th>페이지 수</th>
					<th>가격</th>
					<th>편집</th>
					<th>삭제</th>
				</tr>
				<c:forEach items="${books }" var="book" varStatus="sts">
					<tr>
						<td>${sts.count}</td>
						<td>${book.bookName }</td>
						<td>${book.product.name}</td>
						<td>${fn:length(book.pages)}</td>
						<td>${book.product.productprice}</td>
						<td><button type="button" onclick="window.location.href='${ctx }/book/edit.do?bookId=${book.bookId}'">편집</button></td>
						<td><button type="button" onclick="window.location.href='${ctx }/book/remove.do?bookId=${book.bookId}'">삭제</button></td>
					</tr>
				</c:forEach>
			</table>
		
		</div>
	
	</div>

	<footer>
		<%@include file="../foot/footer.jspf" %>
	</footer>

</body>
</html>