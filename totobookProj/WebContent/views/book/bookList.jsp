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
<title>totoBook</title>
</head>
	<header>
		<%@include file="../head/header.jspf" %>
	</header>
	
	<div class="contentsContainer">
		<div class="leftMenu">
			1. 레프트 메뉴 1 <br>
			2. 레프트 메뉴 2		
		</div>

		<div class="contents">
			<h3>나의 포토북 관리</h3>
			
			<table class="blueListTab">
				<colgroup>
					<col width="20px">
					<col width="60px"> 
				
				</colgroup>
				<tr>
					<th>NO</th>
					<th>포토북 이름</th>
					<th>상품상세</th>
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
						<td>${book.product.price}</td>
						<td><button type="button" onclick="window.location.href='${ctx }/book/edit.do?bookId=${book.bookId}'">편집</button></td>
						<td><button type="button" onclick="window.location.href='${ctx }/book/remove.do?bookId=${book.bookId}'">삭제</button></td>
					</tr>
				</c:forEach>
				
					<tr>
						<td>1</td>
						<td>book.bookName</td>
						<td>book.product.name</td>
						<td>book.product.price</td>
						<td><button type="button" >편집</button></td>
						<td><button type="button" >삭제</button></td>
					</tr>
			</table>
		
		</div>
	
	</div>

	<footer>
		<%@include file="../foot/footer.jspf" %>
	</footer>
<body>

</body>
</html>