<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath }</c:set>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${ctx }/css/layout.css">
<link rel="stylesheet" href="${ctx }/css/sidebarheader.css">
</head>
<title>회원 정보</title>
<body>
<header>
		<%@ include file="../head/header.jspf"%>
</header>
<nav>
	<%@ include file = "/views/left/leftMyPage.jsp" %>
	</nav>
	
		<h2 class="page-title">비밀번호 체크</h2>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script>
			$(document).ready(function() {
				//비밀번호  확인 버튼 클릭
				$("#pwCheck").click(function() {
					var password = $("#password").val();
					console.log(password);
					$.ajax({
						type : 'POST',
						url : "${ctx }/member/pwCheck.do",
						data : {
							password : password
						},
						success : function(data) {
							console.log(data);
							$("#result").html(data);
							if ($.trim(data) == 'yes') {
								console.log("삭제 완료");
								$("form").submit();
							} else if($.trim(data) == 'no') {
								console.log("삭제 실패");
								$("#loginResult").html("비밀번호가 일치하지않습니다");

							}

						}

					});
				});
			});
		</script>
		<form action="${ctx }/member/remove.do" method="post">
			<div>
				<label>비밀번호 </label> <input id="password" type="password" name="password">
			</div>
			<div class="alignRight">
				<button type="reset" >취소</button>
				<button type="button" id="pwCheck" onsubmit="return loginValidate();">탈퇴</button>
			</div>
		</form>
	<footer>
		<%@include file="../foot/footer.jspf"%>
	</footer>
</body>
</html>