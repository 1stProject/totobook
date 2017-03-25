<%@page import="totoBook.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script src="http://code.jquery.com/jquery-1.4.4.min.js"></script>
<script>
	$(document)
			.ready(
					function() {
						var postId = $('#postId').val();

						$
								.ajax({
									async : false,
									url : 'http://localhost:8080/totobookProj/answer/detail.do?postId='
											+ postId,
									dataType : "json",
									type : "GET",
									success : function(data) {
										if (data == null) {
											var test = document
													.getElementById("btn1");
											test.innerHTML = "<a href='${ctx }/answer/register.do?answerId="
													+ postId
													+ " '><button type='button' >답글달기</button></a>";
										} else {
											var test = document
													.getElementById("content");
											test.innerHTML = data.content;
											var test2 = document
													.getElementById("btn1");
											test2.innerHTML = "<a href='${ctx }/answer/remove.do?answerId="
													+ postId
													+ " '><button type='button'>삭제</button></a>";
											var test3 = document
													.getElementById("btn2");
											test3.innerHTML = "<a href='${ctx }/answer/modify.do?answerId="
													+ postId
													+ " '><button type='button'>수정</button></a>";
										}

									},
									error : function(data) {
										alert("error");

									}
								});

					});
</script>
</head>
<body>
<head>
<%@ include file="../member/header.jspf"%>
</head>
	<header> <%@ include file="/views/head/header.jspf"%>
	</header>

	<table border="1">
		<tr>
			<td>제목 : ${question.title }</td>
			<br>
		</tr>
		<tr>
			<td>내용 : ${question.content }</td>
			<br>
		</tr>
		<tr>

			<td><img src=""></td>
			<br>
		</tr>

		<tr>
			<td>작성자 : ${question.member.memberId }</td>
			<br>
		</tr>
		<tr>
			<!--${question.postId }  -->
			<td><input type="hidden" id="postId" value="${question.postId }"></td>
			<c:if test="${member.memberId eq 'admin'}">
				<tr>
					<td><span id="content" /></td>
					<td>
						<div id="btn1"></div>
						<div id="btn2"></div>
					</td>
				</tr>
			</c:if>
		
		<tr>
			<c:if test="${question.member.memberId eq member.memberId  }">
				<td><input type="button" value="수정"
					onclick="location.href='${ctx }/question/modify.do?questionId=${question.postId }'">
					<input type="button" value="삭제"
					onclick="location.href='${ctx }/question/remove.do?questionId=${question.postId }'"></td>
			</c:if>
		</tr>

	</table>


	<footer> <%@include file="../foot/footer.jspf"%>
	</footer>
</body>
</html>