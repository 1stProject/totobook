<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var = "ctx" value = "${pageContext.request.contextPath }"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>배송지 수정</h1>
<form action = "${ctx }/order/modify.do" method = "post">
<table>
	<tr>
		<th>주문번호</th>
		<td>${order.orderId }</td>
	</tr>
	<tr>
		<th>회원 아이디</th>
		<td>${order.member.memberId }</td>
	</tr>
	<tr>
		<th>기존 주소</th>
		<td>${order.ordWay}</td>
	</tr>
	<tr>
		<th>수정 될 주소</th>
		<td><input type = "text" name = "addr" placeholder = "사용자 정보에서 바뀌지 않습니다." size = 50></td>
	</tr>	
	<input type = "hidden" name = "orderId" value = "${order.orderId }">
</table>
<input type = "submit" value = "수정완료">
</form>
</body>
</html>