<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var = "ctx"	value="${pageContext.request.contextPath }"/>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${ctx }/css/layout.css">
<link rel="stylesheet" href="${ctx }/css/sidebarheader.css">
<title>상품평 등록</title>
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
		<div class = "contentsWithLeft">
		<h3>상품평 작성</h3>
		<form action="${ctx }/review/register.do" method="post"
			enctype="multipart/form-data">
			<input type="hidden" value="${order.orderId}" name="orderId">
			<table border="1">
			
							<tr>
					<td>상품평</td>
					<td><input type="text" name="comment" value=""
						style="text-align: left; width: 400px; height: 200px;"></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="file1" accept="image/*"></td>
				</tr>
			</table>	
			<button type="button" onclick="javascript:history.back(-1);" class="btn">목록</button>
			
			<button type="submit" class="btn">등록</button>
		</form>
</div>
	</div>
	
</body>

<footer>
	<%@ include file = "/views/foot/footer.jspf" %>
</footer>


</html>