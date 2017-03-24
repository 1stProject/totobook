<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var = "ctx"	value="${pageContext.request.contextPath }"/>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href = "${ctx }/css/layout.css">
<title>상품평 등록</title>
</head>
<body>
<header>
	<%@ include file = "/views/head/header.jspf" %>
</header>
<nav>
	<%@ include file = "/views/left/leftMyPage.jsp" %>
</nav>
<div class = "contents-wrap">

		<form action="${ctx }/review/register.do" method="post"
			enctype="multipart/form-data">
			<table border="1">
			
							<tr>
					<td>상품평</td>
					<td><input type="text" name="comment" value=""
						style="text-align: left; width: 400px; height: 200px;"></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="file1"></td>
				</tr>
			</table>	
			<button type="button" onclick="javascript:history.back(-1);" class="btn">목록</button>
<input type="hidden" value="${orderId}" name="orderId">
			
			<button type="submit" class="btn">등록</button>
		</form>

	</div>
</body>
</html>