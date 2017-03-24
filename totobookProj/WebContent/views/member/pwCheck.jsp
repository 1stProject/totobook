<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath }</c:set>
<html>
<head>
<%@ include file="header.jspf" %>
</head>
<body>
	<div class="contents-wrap">
		<h2 class="page-title">비밀번호 체크</h2>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script>
			$(document).ready(function() {
				//비밀번호  확인 버튼 클릭
				$("#pwCheck").click(function() {
					var password = $("#password").val();
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
								console.log("확인 성공");
								$('#password').submit;
								return true;
							} else {
								
								console.log("확인 실패");
								$('#password').val("");
								return false;
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
				<button type="submit" id="pwCheck" onsubmit="return loginValidate();">탈퇴</button>
			</div>
		</form>
	</div>
</body>
</html>