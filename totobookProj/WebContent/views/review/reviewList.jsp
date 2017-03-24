<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<h3>나의 상품평</h3>
					<table class="table table-hover table-condensed">
						<colgroup>
							<col width="80" align="center">
							<col width="100">
							<col width="30%">
							<col width="*">
							<col width="100">
							<col width="100">
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
										<tr>
											<td>${review.product.name }</td>
											<td><a
												href="${ctx }/review/detail.do?id=${review.member.memberId }">${review.comment }</a></td>
											<td><a
												href="${ctx }/review/modify.do?productId=${review.product.productId}"
												class="btn btn-xs btn-warning">수정하기</a></td>
											<td><a
												href="${ctx }/review/remove.do?productId=${review.product.productId}"
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

</body>
</html>