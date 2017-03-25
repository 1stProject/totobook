<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

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
<title>나의 상품평</title>
</head>
<body>
	<header>
		<%@ include file="/views/head/header.jspf"%>
	</header>
	<nav>
		<%@ include file="/views/left/leftMyPage.jsp"%>
	</nav>
	<div class="col-md-offset-2">

		<div class="content">
			<form action="${ctx }/review/modify.do" method="post"
				enctype="multipart/form-data">
				<table border="1">
					<c:forEach items="${review }" var="review">
						<input type="hidden" value="${review.order.orderId }"
							name="orderId" id="orderId">

						<tr>
							<td>사진</td>
							<td><img
								src="${ctx }/review/image.do?orderId=${review.order.orderId}"
								width="128" height="123"></td>
						</tr>
						<tr>
							<td>상품평</td>
							<td><input type="text" name="comment"
								value="${review.comment}"></td>
						</tr>
						<tr>
							<td><input type="file" name="file1"></td>
						</tr>
					</c:forEach>


				</table>
				<input type="button" name="back" value="뒤로가기"
					onClick="javascript:history.go(-1);" />



				<button type="submit" class="btn">수정</button>

			</form>
		</div>
	</div>
</body>
<footer>
	<%@ include file="/views/foot/footer.jspf"%>

</footer>


</html>