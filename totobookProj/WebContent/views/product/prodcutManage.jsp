<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
				<h3>상품관리</h3>
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
							<th>No</th>
							<th>상품이름</th>
							<th>상품가격</th>
							<th>카테고리</th>
							<th>수정하기</th>
							<th>삭제하기</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${product eq null || empty product }">
								<tr>
									<td>
									<td colspan="6" align="center">등록된 상품이 없습니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${product}" var="product" varStatus="status">
									<tr>
										<td>${status.count }</td>
										<td>${product.product_id }</td>
										<td><a href="product/detail.do?id=${product.product_id }">${product.product_name }</a></td>
										<td>${product.price }</td>
										<td><a href="product/modify.do?id=${product.product_id}"
												class="btn btn-xs btn-warning">수정하기</a></td>
											<td><a href="product/remove.do?id=${product.product_id}"
												class="btn btn-xs btn-danger">삭제하기</a></td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
					<a class="btn btn-sm btn-success" href="product/registerForm.jsp">상품추가</a>

			</div>
		</div>
	</div>
	
	</div>

</body>
</html>