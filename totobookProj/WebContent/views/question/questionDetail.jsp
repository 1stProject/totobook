<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<td>${question.title }</td>
			<br>
		</tr>
		<tr>
			<td>${question.content }</td>
			<br>
		</tr>
		<tr>

			<td><img src=""></td>
			<br>
		</tr>

		<tr>
			<td>${question.member.memberId }</td>
			<br>
		</tr>
		<tr>
			<td>답글란</td>
		</tr>
		<tr>
			<td><input type="button" value="수정"
				onclick="location.href='${ctx }/question/modify.do?questionId=${question.postId }'" />
				<input type="button" value="삭제"
				onclick="location.href='${ctx }/question/remove.do?questionId=${question.postId }'" />
			</td>
		</tr>

	</table>




</body>
</html>