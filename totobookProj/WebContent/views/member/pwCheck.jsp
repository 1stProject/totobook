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
			<div class="mypageTitle">
		<div class="title_left">마이페이지</div>
		<ul class="title_ul">
			<li class="title_li"><a href="${ctx }/views/main.jsp">HOME</a></li>
			<li class="title_li_icon">></li>
			<li class="title_li"><a href="${ctx }/order/list.do">마이페이지</a></li>
		</ul>
	</div>
<nav>
	<%@ include file = "/views/left/leftMyPage.jsp" %>
	</nav>
	
	<h3>회원탈퇴</h3>
	<p>탈퇴 후 회원정보 및 개인형 서비스 이용기록은 모두 삭제됩니다.<p>
	<p>회원정보 및 메일,주소록 등 개인형 서비스 이용기록은 모두 삭제되며,삭제된 데이터는 복구되지 않습니다.</p>
	<p>삭제되는 내용을 확인하시고 필요한 데이터는 미리 백업을 해주세요.</p>
	
		<h2 class="page-title">본인확인</h2>
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
								alert("★☆★☆★☆안녕히가십쇼☆★☆★☆★");
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
				<button type="reset" >취소</button>
				<button type="button" id="pwCheck" onsubmit="return loginValidate();">탈퇴</button>
		</form>
	<footer>
		<%@include file="../foot/footer.jspf"%>
	</footer>
</body>
</html>