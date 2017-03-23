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
		<form action="${ctx }/question/modify.do" method="post">

			<tr>
				<td><input type="text" name="question_title"
					value="${question.title }"></td>
				<br>
				<input type="hidden" name="postId" value="${question.postId }">
			</tr>
			<tr>
				<td><input type="text" name="content"
					value="${question.content }"></td>
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

				<td><input type="submit" value="수정완료">
		</form>
		</tr>

	</table>
</body>
</html>