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
<body>
	<header>
		<%@include file="../head/header.jspf" %>
	</header>
	
	<div class="photoBookDiv">
			<h3>포토북 편집</h3>
	<form action="${ctx }/book/edit.do" method="post">
		포토북명 : <input type ="text" value="" name="bookName" placeholder="${book.bookName}">
		전체 페이지 수 : ${fn:length(book.pages)}" 장
		선택한 상품명 : ${book.product.name}
		선택된 옵션 : ${book.option }
		
			<div id="bookPageLeft">
				음?
			</div>
			<div id="bookPageRight">
				뭐지
			</div>
		
		<button type="submit" >편집저장</button>
		<button type="reset">취소</button>
	</form>
	</div>

	<footer>
		<%@include file="../foot/footer.jspf" %>
	</footer>
</body>
</html>