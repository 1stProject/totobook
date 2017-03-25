<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath }</c:set>

<html>
<head>
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
</head>
<body>


	<header>
	<%@ include file="../head/header.jspf"%>
	</header>

	<div class="contentsContainer">
		<nav>
			<%@ include file="/views/left/leftManagePage.jsp"%>
		</nav>
		<div class="col-md-offset-2 col-sm-6 col-lg-6">
			<h2 class="page-title">회원목록</h2>
			<div class="contents">
				<table class = "table table-bordered table-stripped">
					<colgroup>
						<col width="90">
						<col width="*">
						<col width="*">
						<col width="*">
					</colgroup>

					<thead>
						<tr>
							<th>이름</th>
							<th>휴대폰번호</th>
							<th>아이디</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${memberList }" var="ml">
							<tr>
								<td><a href="${ctx }/member/detail.do?memberId=${ml.memberId }">${ml.name }</a></td>
								<td>${ml.phone }</td>
								<td>${ml.memberId }</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<form action="list.do" method="post">
				<div class = "col-sm-3 col-lg-3">
				<select name="slist" class = "form-control">
					<option value="name">이름</option>
					<option value="phone">핸드폰번호</option>
					<option value="memberId">아이디</option>
				</select> 
				</div>
				<div class = "col-sm-6 col-lg-6">
				<input type="text" name="search" placeholder="입력" class = "form-control"> </div>
				<div class = "col-sm-3 col-lg-3">
				<input class="btn  btn-default" type="submit" value="검색"></div>
			</form>
			</div>
		</div>
	</div>
	<footer>
		<%@include file="../foot/footer.jspf"%>
	</footer>
</body>
</html>








