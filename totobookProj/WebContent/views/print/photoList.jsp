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

<div class="contentsContainer">
	<c:choose>
	<c:when test="${member.memberId eq 'admin' }">
	<div class="mypageTitle">
		<div class="title_left">관리자 페이지</div>
		<ul class="title_ul">
			<li class="title_li"><a href="${ctx }/views/main.jsp">HOME</a></li>
			<li class="title_li_icon">></li>
			<li class="title_li"><a href="${ctx }/order/list.do">관리자 페이지</a></li>
		</ul>
	</div>
	</c:when>
	<c:otherwise>
	<div class="mypageTitle">
		<div class="title_left">마이페이지</div>
		<ul class="title_ul">
			<li class="title_li"><a href="${ctx }/views/main.jsp">HOME</a></li>
			<li class="title_li_icon">></li>
			<li class="title_li"><a href="${ctx }/order/list.do">마이페이지</a></li>
		</ul>
	</div>
	</c:otherwise>
	</c:choose>
	
<nav>
	<c:choose>
	<c:when test="${member.memberId eq 'admin' }">
	<%@ include file = "/views/left/leftManagePage.jsp" %>
	</c:when>
	<c:otherwise>
	<%@ include file = "/views/left/leftMyPage.jsp" %>
	</c:otherwise>
	</c:choose>
</nav>
		<div class = "contentsWithLeft">
<h1>사진인화 사진</h1>
	<div style = "display:block;padding:20px;">
	<c:forEach items="${photos }" var = "photo">
	
	<div style="display:inline-block;">
		<img src = "${ctx }/print/image.do?photoId=${photo.photoId}" width ="200" height="200">
		<br>${photo.amount }개 주문
	</div>
	</c:forEach>
	</div>
	<input type = "button" onclick = "javascript:history.back(-1);" class = "btn btn-default" value = "돌아가기">
	
</div>
</div>
<footer>
		<%@include file="../foot/footer.jspf"%>
	</footer>

</body>
</html>