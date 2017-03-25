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
	<div class="contents-wrap">
		<div class="col-md-offset-2">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<h3>나의 상품평</h3>
<table class = "table table-striped table-bordered table-hover">
							<colgroup>
								<col width="20%">
								<col width="*">
								<col width="10%">
								<col width="10%">
							</colgroup>
							<thead>

								<tr>
									<th>상품명</th>
									<th>내용</th>
									<th>수정</th>
									<th>삭제</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${review eq null || empty review }">
										<tr>
											<td>
											<td colspan="6" align="center">등록하신 상품평이 없습니다.</td>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach items="${review }" var="review" varStatus="status">
											<input type="hidden" name="memberId"
												value="${review.member.memberId }">
											<tr>
												<td>${review.product.name }</td>
												<td><a
													href="${ctx }/review/detail.do?orderId=${review.order.orderId}">${review.comment }</a></td>
												<td><a
													href="${ctx }/review/modify.do?orderId=${review.order.orderId}"
													class="btn btn-xs btn-warning">수정하기</a></td>
												<td><a
													href="${ctx }/review/remove.do?orderId=${review.order.orderId}"
													class="btn btn-xs btn-danger">삭제하기</a></td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

<footer>
	<%@ include file="/views/foot/footer.jspf"%>
</footer>

</html>