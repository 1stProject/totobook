<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath }</c:set>
<html>
<head>
<title>회원정보</title>
</head>
<body>
	<a href="list.do">목록화면으로</a>
	<h3>회원정보</h3>
	<form action="modify.do" method="post">
		<table class="table">
			<tr>
				<th>아이디</th>
				<td><input id="memberId" name="memberId" type="text"
					value="${member.memberId}"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input id="memberPassword" name="memberPassword"  
					type="text" value="${member.password}"></td>
			</tr>
			<tr>
				<th>폰번</th>
				<td><input id="memberPhone" name="memberPhone" 
						value="${member.phone}"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input id="memberAddress" name="memberAddress" 
						value="${member.address}"></td>
			</tr>
			<tr>	
				<th>이메일</th>
				<td><input id="memberEmail" name="memberEmail"  
						value="${member.receiveEmail}"></td>
			</tr>			
		</table>
		<div align="center">
		<input class="btn" type="reset" value="취소"> 
		<input class="btn" type="submit"
			value="저장"></div>
	</form>
	<br>
</body>
</html>