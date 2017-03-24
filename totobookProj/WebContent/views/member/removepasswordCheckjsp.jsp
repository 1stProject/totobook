<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath }</c:set>
<html>
<head>
	<title>비밀번호체크</title>
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
					url : "${ctx }/member/pwCheck.do",
					data : {
						id : id,
						password : password
					},
					success : function(data) {
						console.log(data);
						$("#result").html(data);
						if ($.trim(data) == 'yes') {
							console.log("로그인 성공");
							$(this).submit;
						} else {
							console.log("로그인 실패");
							return false;
						}

					}

				});
			});
			</script>
			</head>
<body>
<div class="login-wrap">
	<h3>비밀번호체크</h3>
	<form action="${ctx }/member/remove.do" method="post" onsubmit="return loginValidate();">
	  <input type="text" id="password" name="password" placeholder="비밀번호를 입력하세요.">
	 <input type="submit" id="pwCheck" value="확인">
	  <input type="reset" value="취소">
	</form>
</div>
</body>
</html>