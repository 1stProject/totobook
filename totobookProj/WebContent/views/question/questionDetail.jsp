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
	$(document).ready(function() {
						var postId = $('#postId').val();
						
						$.ajax({async : false,
								url : 'http://localhost:8080/totobookProj/answer/detail.do?postId='+ postId,
								dataType : "json",
								type : "GET",
								success : function(data) {
									if(data==null){
										var test = document.getElementById("btn-reg");
										test.innerHTML = "<a href='${ctx }/answer/register.do?answerId="+ postId +" '><button type='button'>버튼</button></a>";
									}else{
										alert("nn");
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
	<header> <%@ include file="/views/head/header.jspf"%>
	</header>

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
			<!--${question.postId }  -->
			<td><input type="hidden" id="postId" value="${question.postId }">

				<div id="btn-reg">
				
				</div>
		</tr>
		<tr>
			<td><input type="button" value="수정"
				onclick="location.href='${ctx }/question/modify.do?questionId=${question.postId }'">
				<input type="button" value="삭제"
				onclick="location.href='${ctx }/question/remove.do?questionId=${question.postId }'"></td>

		</tr>

	</table>


	<footer> <%@include file="../foot/footer.jspf"%>
	</footer>


</body>
</html>