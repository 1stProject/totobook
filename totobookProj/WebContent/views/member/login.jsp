
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath} </c:set>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${ctx }/css/layout.css">
<link rel="stylesheet" href="${ctx }/css/sidebarheader.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
	<header>
		<%@ include file="../head/header.jspf"%>
	</header>

	<div class="contentsContainer">
		<h3>로그인</h3>
		<div class="login-wrap">
			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
			<script>
				$(document).ready(function() {
					//아이디  중복 확인 버튼 클릭
					$("#loginCheck").click(function() {
						var id = $("#memberId").val();
						var password = $("#password").val();
						console.log(password);

						$.ajax({
							type : 'POST',
							url : "${ctx }/member/loginCheck.do",
							data : {
								id : id,
								password : password
							},
							success : function(data) {
								console.log(data);
								$("#result").html(data);
								if ($.trim(data) == 'yes') {
									console.log("로그인 성공");
									alert("★☆★☆★☆환영합니다☆★☆★☆★")
									return true;
								} else if ($.trim(data) == 'no') {
									console.log("로그인 실패");
									alert("로그인에 실패하였습니다.")
									return false;

								}
							}
						});
					});
				});
			</script>
			<form action="${ctx }/member/login.do" method="post"
				onsubmit="return loginValidate();">
				<label>아이디</label> <input type="text" id="memberId" name="memberId"
					placeholder="아이디를 입력하세요."> <label>비밀번호</label> <input
					type="password" id="password" name="password"
					placeholder="패스워드를 입력하세요.">
				<div class="login-btn">
					<button type="button"
						onclick="location.href='${ctx }/member/list.do'">취소</button>
					<button type="submit" id="loginCheck"
						onsubmit="return loginValidate();">로그인</button>
					<button type="button" onclick="location.href='memberRegister.jsp'">회원가입</button>
				</div>
			</form>
		</div>
	</div>
	<footer>
		<%@include file="../foot/footer.jspf"%>
	</footer>
</body>
</html>
