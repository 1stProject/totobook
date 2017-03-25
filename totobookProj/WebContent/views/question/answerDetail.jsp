<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${ctx }/css/layout.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
	<head>
<%@ include file="../head/header.jspf"%>pf"%>
</head>
<header> <%@ include file="/views/head/header.jspf"%>
	</header>
	<input type="button" value="이전페이지"
		onclick="location.href='${ctx }/question/detail.do?questionId=${answer.post.postId }'">
	<table border="1">
		<tr>
			<td>답글 내용 : ${answer.content }</td>
			<td>관리자</td>
			<br>
		</tr>

		<tr>
			<td><input type="button" value="수정"
				onclick="location.href='${ctx }/answer/modify.do?answerId=${answer.post.postId }'">
				<input type="button" value="삭제"
				onclick="location.href='${ctx }/answer/remove.do?answerId=${answer.post.postId }'"></td>
		</tr>

	</table>
	<footer> <%@include file="../foot/footer.jspf"%>
	</footer>
</body>



</html>