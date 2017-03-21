<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<header> </header>
		<form action="${ctx }/question/register.do" method="post">
			title : <input type="text" name="question_title"><br>
			<br> <input type="text" name="content" style="height: 200px; width: 500px"><br>
			<br> <input type="submit" value="등록">
		</form>
		<footer> </footer>
	</div>
</body>
</html>