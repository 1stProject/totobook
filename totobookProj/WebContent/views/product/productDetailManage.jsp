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
<title>제품상세</title>
</head>
<body>
	<header>
		<%@ include file="/views/head/header.jspf"%>
	</header>
	<div class="contents-wrap">
		<div class="col-md-offset-2">
			<c:choose>
				<c:when test="${product.category  eq 'PRINT' }">
						<input type="hidden" name="productId" value="${product.productId}">
						<table border="1">
							<tr>
								<td>제품사진</td>
								<td><img
									src="${ctx }/product/image.do?productId=${product.productId}"
									width="128" height="123"></td>
							</tr>
							<tr>
								<td>상품명</td>
								<td>${product.name }</td>
							</tr>
							<tr>
								<td>상품가격</td>
								<td>${product.productprice}</td>
							</tr>
							<tr>
								<td>상품설명</td>
								<td>${product.descript }</td>
							</tr>
							<tr>
								<td colspan="2">옵션</td>
							<tr>
								<td>사이즈</td>
								<td><select name="option1" id="option1"
									style="width: 80px;" class="select_02">
										<c:forEach items="${product.options }" var="option">
											<option value="${option.optionName}">${option.optionName}</option>
										</c:forEach>
								</select>
							</tr>
							<tr>
								<td>규격</td>
								<td><select name="option2" id="option2"
									style="width: 80px;" class="select_02">
										<c:forEach items="${product.options }" var="option">
											<option value="${option.optionDesp}">${option.optionDesp}</option>
										</c:forEach>
								</select>
							</tr>
							<tr>
								<td>가격</td>
								<td><select name="optionPrice" id="optionPrice"
									style="width: 80px;" class="select_02">
										<c:forEach items="${product.options }" var="option">
											<option value="${option.optionPrice}">${option.optionPrice}</option>
										</c:forEach>
								</select>
							</tr>
						</table>
						<button type="button" onclick="javascript:history.back(-1);"
							class="btn">목록</button>
				</c:when>
				<c:otherwise>
					<table border="1">
						<tr>
							<td>상품명</td>
							<td>${product.name }</td>
						</tr>
						<tr>
							<td>제품사진</td>
							<td><img
								src="${ctx }/product/image.do?productId=${product.productId}"
								width="128" height="123"></td>
						</tr>
						<tr>
							<td>상품가격</td>
							<td>${product.productprice}</td>
						</tr>
						<tr>
							<td>상품설명</td>
							<td>${product.descript }</td>
						</tr>

						<tr>
							<td colspan="2">옵션</td>
						<tr>
							<td>사이즈</td>
							<td><select name="optionName" id="optionName"
								style="width: 80px;" class="select_02">
									<c:forEach items="${product.options }" var="option">
										<option value="${option.optionName}">${option.optionName}</option>
									</c:forEach>
							</select>
						</tr>
						<tr>
							<td>설정값</td>
							<td><select name="optionName" id="optionName"
								style="width: 80px;" class="select_02">
									<c:forEach items="${product.options }" var="option">
										<option value="${option.optionDesp}">${option.optionDesp}</option>
									</c:forEach>
							</select>
						</tr>
						<tr>
							<td>가격</td>
							<td><select name="optionPrice" id="optionPrice"
								style="width: 80px;" class="select_02">
									<c:forEach items="${product.options }" var="option">
										<option value="${option.optionPrice}">${option.optionPrice}</option>
									</c:forEach>
							</select>
						</tr>
					</table>
					<button type="button" onclick="javascript:history.back(-1);"
						class="btn">목록</button>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>

<footer>
	<%@ include file="/views/foot/footer.jspf"%>

</footer>


</html>