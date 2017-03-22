<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath }</c:set>
<html>
<head>
<title>회원정보수정</title>
</head>
<body>
	<a href="list.do">회원리스트</a>
	<h3>회원정보수정</h3>
	<form action="${ctx }/member/modify.do" method="post">
			<input id="memberId" name="memberId" type="hidden"
			value="${member.memberId}">
		<table class="table">
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
				<th>폰번</th>
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
</body>
</html>