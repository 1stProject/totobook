<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="content">
		<c:if test="${product.category }.equals(PRINT) ">

			<table border="1">
				<c:forEach items="${product.options }" var="option">

					<tr>
						<td>제품사진</td>
						<td><img
							src="${ctx }/product/image.do?productId=${product.imageAddress}"
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
					<td>옵션</td>
					<c:forEach items="${product.options }" var="option">
						<td>${option.optionName}</td>
						<td>${option.optionDesp}</td>
						<td>${option.optionPrice}</td>
					</c:forEach>
					<tr>
						<td>사진</td>
						<td><input type="file" name="file1"></td>
					</tr>
					<tr>
						<td>사진</td>
						<td><input type="file" name="file1"></td>
					</tr>
					<tr>
						<td>사진</td>
						<td><input type="file" name="file1"></td>
					</tr>
				</c:forEach>

			</table>
			<button type="button" onclick="javascript:gotoMain();" class="btn">목록</button>
			<a class="btn btn-sm btn-success"
				href="${ctx }/print/register.do?productId=${product.productId}">주문하기</a>
		</c:if>
		<table border="1">
			<tr>
				<td>상품명</td>
				<td>${product.name }</td>
			</tr>
			<tr>
				<td>제품사진</td>
				<td><img
					src="${ctx }/product/image.do?productId=${product.imageAddress}"
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
				<td>옵션</td>
				<c:forEach items="${product.options }" var="option">
					<td>${option.optionName}</td>
					<td>${option.optionDesp}</td>
					<td>${option.optionPrice}</td>
				</c:forEach>
			</tr>
			<tr>
				<td>사진</td>
				<td><input type="file" name="file1"></td>
			</tr>
			<tr>
				<td>사진</td>
				<td><input type="file" name="file1"></td>
			</tr>
			<tr>
				<td>사진</td>
				<td><input type="file" name="file1"></td>
			</tr>
		</table>
		<button type="button" onclick="javascript:gotoMain();" class="btn">목록</button>
		<a class="btn btn-sm btn-success"
			href="${ctx }/book/register.do?productId=${product.productId}">주문하기</a>

	</div>
</body>
</html>