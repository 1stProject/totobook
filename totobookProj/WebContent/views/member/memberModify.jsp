<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<body>
	<header>
	<%@ include file="../head/header.jspf"%>
	</header>
		<div class="contentsContainer">
		
			<div class="mypageTitle">
		<div class="title_left">마이페이지</div>
		<ul class="title_ul">
			<li class="title_li"><a href="${ctx }/views/main.jsp">HOME</a></li>
			<li class="title_li_icon">></li>
			<li class="title_li"><a href="${ctx }/order/list.do">마이페이지</a></li>
		</ul>
	</div>
			<nav>
			<%@ include file="/views/left/leftMyPage.jsp"%>
		</nav>
	

		<div class="contentsWithLeft">
	<h3>회원정보수정</h3>
	<form action="${ctx }/member/modify.do" method="post">
			<input id="memberId" name="memberId" type="hidden"
			value="${member.memberId}">
		<table class = "table table-bordered table-stripped">
			<tr>
				<th>아이디</th>
				<td><input id="memberId" name="memberId" type="text"
					value=""></td>
			</tr>
						<tr>
				<th>비밀번호</th>
				<td><input id="memberPassword" name = "memberPassword" type="password"
						value=""></td>
						</tr>
						<tr>
				<th>비밀번호 확인</th>
				<td><input id="memberPassword2" name= "memberPassword" type="password"
						value="">
											<button type="button" id="btn">확인</button>
						</td>
			<tr>
				<th>휴대폰번호</th>
				<td><input id="memberPhone" name="memberPhone" 
						value=""></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input id="memberAddress" name="memberAddress" 
						value=""></td>
			</tr>
			<tr>	
				<th>이메일</th>
				<td><div class = "radioc"><input type = "radio" name = "memberEmail" value = "yes"> 유
				<input type = "radio" name = "memberEmail" value = "no"> 무
				</div></td>
			</tr>			
		</table>
		<div align="center">
		<input type="reset" value="취소"> 
		<input type="submit" value="저장"></div>
	</form>
	<br>
	</div>
	</div>
</body>
</html>