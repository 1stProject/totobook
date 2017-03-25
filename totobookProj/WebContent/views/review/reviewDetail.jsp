<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${ctx }/css/layout.css">
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
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<table class="table table-hover table-condensed">
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
								<td>작성내용</td>
								<td>${review.comment}"></td>
							</tr>
							<tr>
								<td><a
									href="${ctx }/review/modify.do?orderId=${review.order.orderId}"
									class="btn btn-xs btn-warning">수정하기</a></td>
								<td><a
									href="${ctx }/review/list.do?orderId=${review.order.orderId}"
									class="btn btn-xs btn-warning">목록으로</a></td>
							</tr>
						</c:forEach>
					</table>


				</div>
			</div>
		</div>
	</div>

</body>
<footer>
	<%@ include file="/views/foot/footer.jspf"%>

</footer>


</html>