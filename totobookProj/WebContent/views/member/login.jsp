
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
	
	<div class="mypageTitle">
		<div class="title_left">로그인</div>
		<ul class="title_ul">
			<li class="title_li"><a href="${ctx }/views/main.jsp">HOME</a></li>
			<li class="title_li_icon">></li>
			<li class="title_li"><a href="${ctx }/views/member/login.jsp">로그인</a></li>
		</ul>
	</div>
			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
			<script>
				$(document).ready(function() {
					
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
									alert("★☆★☆★☆환영합니다☆★☆★☆★");
									$("form").submit();
									return true;
								} else if ($.trim(data) == 'no') {
									$("#loginResult").html("로그인에 실패하였습니다. 아이디 혹은 비밀번호를 확인하세요.");

								}
							}
						});
					});
				});
			</script>
			<%-- <form action="${ctx }/member/login.do" method="post" >
				<label>아이디</label> <input type="text" id="memberId" name="memberId"
					placeholder="아이디를 입력하세요."><Br> <label>비밀번호</label> <input
					type="password" id="password" name="password"
					placeholder="패스워드를 입력하세요.">
					
				<p id="loginResult"></p>	
				<div class="login-btn">
					<button type="button" id="loginCheck">로그인</button>
					<button type="button"
						onclick="location.href='${ctx }/main/main.do'">취소</button>
				</div>
			</form>
			<div>
					<button type="button" onclick="location.href='memberRegister.jsp'">회원가입</button>
			</div> --%>
	<div class="col col-md-6 col-md-offset-3">
      <form class="form-signin" action="${ctx }/member/login.do" method="post">
       <br>
        <label for="inputEmail" class="sr-only">아이디를 입력하세요</label>
        <input type="text" id="memberId" name = "memberId" class="form-control" placeholder="아이디를 입력하세요"><br>
        <label for="inputPassword" class="sr-only">비밀번호를 입력하세요.</label>
        <input type="password" id="password" name = "password" class="form-control" placeholder="비밀번호를 입력하세요.">
        <div class = "col col-sm-6" style = "padding:20px">
        <button class="btn btn-lg btn-primary btn-block" id="loginCheck" type="button">로그인</button>
        </div>
         <div class = "col col-sm-6" style = "padding:20px">
        <button class="btn btn-lg btn-primary btn-block" type="button" onclick="location.href='memberRegister.jsp'">회원가입</button>
        </div>
      </form>
		<p id = "loginResult"></p>
    </div>
		</div>
	<footer>
		<%@include file="../foot/footer.jspf"%>
	</footer>
</body>
</html>
