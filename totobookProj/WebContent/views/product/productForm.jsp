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
<title>상품등록</title>
</head>
<body>
	<header>
		<%@ include file="/views/head/header.jspf"%>
	</header>
	<nav>
		<%@ include file="/views/left/leftMyPage.jsp"%>
	</nav>

	<div class="col-md-offset-2">
		<div class="contents-wrap">
			<form action="${ctx }/product/register.do" method="post"
				enctype="multipart/form-data">

				<table border="1">

					<tr>
						<td>상품카테고리</td>
						<td><select name="category">
								<option value="BOOK">포토북</option>
								<option value="PRINT">사진</option>
						</select></td>
					</tr>
					<tr>
						<td>상품명</td>
						<td><input type="text" name="name" value=""></td>
					</tr>
					<tr>
						<td>상품가격</td>
						<td><input type="text" name="productprice"></td>
					</tr>
					<tr>
						<td>상품설명</td>
						<td><input type="text" name="descript"
							style="text-align: left; width: 400px; height: 200px;"></td>
					</tr>
					<tr>
						<td>옵션</td>
						<td>사이즈<input type="text" name="optionname" value="">
							설명<input type="text" name="optiondesp" value=""> 금액<input
							type="text" name="optionprice" value="">
						</td>
					</tr>
					<tr>
						<td>옵션1</td>
						<td>사이즈1<input type="text" name="optionname" value="">
							설명1<input type="text" name="optiondesp" value=""> 금액1<input
							type="text" name="optionprice" value="">
						</td>
					</tr>
					<tr>
						<td>사진</td>
						<td><input type="file" name="file1"></td>
					</tr>
				</table>
				<button type="button" onclick="javascript:history.back(-1);"
					class="btn">목록</button>
				<button type="submit" class="btn">등록</button>
			</form>
		</div>
	</div>
</body>
<footer>
	<%@ include file="/views/foot/footer.jspf"%>
</footer>
</html>