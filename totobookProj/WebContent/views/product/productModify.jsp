<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var = "ctx"	value="${pageContext.request.contextPath }"/>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="content">
		<form action="${ctx }/product/modify.do" method="post"
			enctype="multipart/form-data">

			<input type="hidden" value="${product.productId}" name="productId">
			<table border="1">
				<tr>
					<td>상품카테고리</td>
					<td><select name="category">
							<option value="book">포토북</option>
							<option value="print">사진</option>
					</select></td>
				</tr>
				<tr>
					<td>상품명</td>
					<td><input type="text" name="name" value="${product.name }"></td>
				</tr>
				<tr>
					<td>상품가격</td>
					<td><input type="text" name="productprice" value="${product.productprice}"></td>
				</tr>
				<tr>
					<td>상품설명</td>
					<td><input type="text" name="descript" style="text-align:left; width:400px; height:200px;" value="${product.descript}"></td>
				</tr>
				<tr>
					<td>옵션</td>
					<td>사이즈<input type="text" name="optionname" value="">
					설명<input type="text" name="optiondesp" value="">
					금액<input type="text" name="optionprice" value="">
					</td>
				</tr>
				<tr>
					<td>옵션1</td>
					<td>사이즈1<input type="text" name="optionname" value="">
					설명1<input type="text" name="optiondesp" value="">
					금액1<input type="text" name="optionprice" value="">
					</td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="file1"></td>
				</tr>
			</table>
			<button type="button" onclick="javascript:gotoMain();" class="btn">목록</button>
			<button type="submit" class="btn">수정</button>
		</form>

	</div>
</body>
</html>