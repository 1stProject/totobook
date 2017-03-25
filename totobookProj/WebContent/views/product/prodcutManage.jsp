<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var = "ctx"	value="${pageContext.request.contextPath }"/>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.gooㅣㄷㄽgleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href = "${ctx }/css/layout.css">
<title>상품관리창</title>
</head>
<body>
<header>
	<%@ include file = "/views/head/header.jspf" %>
</header>
<nav>
	<%@ include file = "/views/left/leftManagePage.jsp" %>
</nav>
<div class = "contents-wrap">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-offset-2">
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
										<td><a href="${ctx }/product/detail.do?productId=${product.productId }">${product.name }</a></td>
										<td>${product.productprice }</td>
										<td>${product.category }</td>
										<td><a href="${ctx }/product/modify.do?productId=${product.productId}"
												class="btn btn-xs btn-warning">수정하기</a></td>
											<td><a href="${ctx }/product/remove.do?productId=${product.productId}"
												class="btn btn-xs btn-danger">삭제하기</a></td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
					<a class="btn btn-sm btn-success" href="${ctx }/views/product/productForm.jsp">상품추가</a>

			</div>
		</div>
	</div>
</div>	
</body>

<footer>
	<%@ include file = "/views/foot/footer.jspf" %>

</footer>



</html>