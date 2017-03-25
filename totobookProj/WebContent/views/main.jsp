<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
	
</script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${ctx }/css/layout.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${ctx }/css/sidebarheader.css">
<title>totoBook</title>
</head>
<body>
	<header>
		<%@ include file="/views/head/header.jspf"%>
	</header>

	<!-- First Container -->
	<div class="contentsContainer">
		<div class="col-md-offset-2"></div>
		<div
			class="container-fluid bg-2 text-center col col-sm-8 col-md-offset-2"
			style="padding: 20px;">
			<img src="${ctx }/views/main.jpg" class="img-responsive"
				style="display: inline" alt="main1" width="100%">
		</div>
		<div
			class="container-fluid bg-3 text-center col col-sm-8 col-md-offset-2"
			style="padding: 20px;">
			<img src="${ctx }/views/main.jpg" class="img-responsive"
				style="display: inline" alt="main1" width="100%">
		</div>
		<div
			class="container-fluid bg-4 text-center col col-sm-8 col-md-offset-2"
			style="padding: 20px;">
			<h1>최고의 사진 사이트를 만들기 위해...</h1>
			<p>오늘도 열심히 노력을 하며 한땀한땀 장인의 손길로 포토북 만들고 있습니다. 항상 열심히 하는 토토북이
				되겠습니다. 고객님들 감사합니다.</p>
		</div>
		<div class="container-fluid col-sm-8 col-md-offset-2"
			style="padding: 20px;">
			<div class="col-sm-6">
				<h1>
					<a href="${ctx }/notice/list.do">공지 게시판</a>
				</h1>
				<ul>
					<c:forEach items="${noticeList }" var = "post">
						<li><a href="#">${post.title }</a>
					</c:forEach>
				</ul>

			</div>
			<div class="col-sm-6">
				<h1>
					<a href="#" class="a">문의 게시판</a>
				</h1>
				<ul>
					<li><a href="#" class="a">문의 게시판</a>
					<li><a href="#" class="a">문의 게시판</a>
				</ul>
			</div>
		</div>
	</div>
	<footer>
		<%@include file="foot/footer.jspf"%>
	</footer>
</body>
</html>
