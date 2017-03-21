<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var = "ctx"	value="${pageContext.request.contextPath }"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${ctx }/css/layout.css">
<title>totoBook</title>
</head>
	<header>
		<%@include file="../head/header.jspf" %>
	</header>
	
	<div class="contents">
	
		<h3>나의 포토북 관리</h3>
	
	</div>

	<footer>
		<%@include file="../foot/footer.jspf" %>
	</footer>
<body>

</body>
</html>