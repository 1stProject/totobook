<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var = "ctx" value = "${pageContext.request.contextPath }"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<h1>나의 사진 관리</h1>
<c:forEach items = "${list }" var = "print">
${print.printId } || ${print.member.memberId } || ${print.optionDesp } 
<a href = "${ctx }/order/register.do?printId=${print.printId}">주문하기</a>
<a href = "${ctx }/print/remove.do?printId=${print.printId }">삭제하기</a><br>
</c:forEach>
</body>
</html>