<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath} </c:set>
<html>
<head>
    <meta charset="utf-8">
    <title>로그인</title>
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
							} else {
								console.log("로그인 실패");
								
							}

						}

					});
				});
			});
		</script>
</head>
<body>
<div class="login-wrap">
    <h3>로그인</h3>
    <form action="${ctx }/member/login.do" method="post" onsubmit="return loginValidate();">
        <label>아이디</label>
        <input type="text" id="memberId" name="memberId" placeholder="아이디를 입력하세요.">
        <label>비밀번호</label>
        <input type="password" id= "password" name="password" placeholder="패스워드를 입력하세요.">
        <div class="login-btn">
            <button type="button" onclick="location.href='${ctx }/member/list.do'">취소</button>
            <input type="button" id="loginCheck" value="로그인">
            <button type="button" onclick="location.href='memberRegister.jsp'">회원가입</button>
        </div>
    </form>
</div>
</body>
</html>

