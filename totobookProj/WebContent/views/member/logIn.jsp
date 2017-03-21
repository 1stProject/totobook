<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath }</c:set>
<html>
<head>
<title>로그인</title>
</head>
<body>
	<h3>로그인</h3>
	
	<br>
<form action="${ctx }/member/login.do" method="post">
	<table border="1">
		<tr>
		<td>아이디</td>
		<td><input type="text" name="userId" value="${memberId }">
		<label><input type="checkbox" value="Y" name="saveIdYn"<c:if test="${memberId != null }">checked</c:if>>아이디저장</label>
		</td>
		</tr>
		<tr>
		<td>비밀번호</td>
		<td><input type="password" name="password" value=""></td>
	</table>

	<button type = "button" onclick="location.href='${ctx }/views/member/memberRegister.jsp'" class="btn">사용자등록 </button><br>
	<button type="submit" class="btn">로그인</button>
</form>
	<br>
</body>
</html>