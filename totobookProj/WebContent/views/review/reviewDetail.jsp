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
<title>상품평보기</title>
</head>
<body>
<header>
	<%@ include file = "/views/head/header.jspf" %>
</header>
<nav>
	<%@ include file = "/views/left/leftMyPage.jsp" %>
</nav>
<div class = "contents-wrap">


		<table class="section">
			<tr>
				<td><img src="/review/image.do?productId=${review.product_id}"
					width="128" height="123"></td>
			</tr>
			<tr>
				<td style="text-align:left; width:400px; height:200px;">${review.comment}</td>
			</tr>
		</table>

		<input type="button" name="back" value="뒤로가기" onClick="javascript:history.go(-1);" /> 
		<input type="button" name="modify" value="수정하기"
			onclick="javascript:location.href='${ctx }/review/modify.do?memebrid=${review.member_id }';"
			value="수정하기">

	</div>




</body>
</html>