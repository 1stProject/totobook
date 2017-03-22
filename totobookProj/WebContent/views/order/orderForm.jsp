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
<h1>주문 창</h1>
<form method = "post" action = "${ctx }/order/register.do">
회원 아이디 : ${order.member.memberId } <br>
회원 이름 : ${order.member.name } <br>
배송 주소 : ${order.member.address } <br>
핸드폰번호 : ${order.member.phone } <br>
카테고리 : 사진 <br>
상품이름 : 봄봄봄<br>
<input type = "radio" name = "payment" value = "신용카드"> 시뇽카드
<input type = "radio" name = "payment" value = "무통장입금"> 무통장입금
<input type = "radio" name = "payment" value = "현금"> 현금박치기<br>
가격 : <input type = "text" name = "price" value = "35000" readonly>
<input type = "hidden" value = "${order.member.memberId }" name = "memberId">
<input type = "submit" value = "주문하기!">
</form>
</body>
</html>