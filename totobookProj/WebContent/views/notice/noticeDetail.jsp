<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE>
<html>
<head>

<link rel="stylesheet" type="text/css" href="${ctx }/css/layout.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<%@ include file="/views/head/header.jspf"%>
	</header>
	<table border="1">
		<tr>
			<<<<<<< HEAD
			<td>제목 : ${notice.title }</td>
			<br> =======
			<td>${notice.title }</td> >>>>>>> branch 'development' of
			https://github.com/1stProject/totobook.git
		</tr>
		<tr>
			<<<<<<< HEAD
			<td>내용 : ${notice.content }</td>
			<br> =======
			<td>${notice.content }</td> >>>>>>> branch 'development' of
			https://github.com/1stProject/totobook.git
		</tr>
		<tr>

			<td><img src=""></td>
		</tr>

		<tr>
			<<<<<<< HEAD
			<td>작성자 : ${notice.member.memberId }</td>
			<br> =======
			<td>${notice.member.memberId }</td> >>>>>>> branch 'development' of
			https://github.com/1stProject/totobook.git
		</tr>
		<tr>
			<c:if test="${member.memberId eq 'admin' }">
				<td><input type="button" value="수정"
					onclick="location.href='${ctx }/notice/modify.do?noticeId=${notice.postId }'">
					<input type="button" value="삭제"
					onclick="location.href='${ctx }/notice/remove.do?noticeId=${notice.postId }'"></td>
			</c:if>
		</tr>

	</table>

	<footer>
		<%@include file="../foot/footer.jspf"%>
	</footer>

</body>
</html>