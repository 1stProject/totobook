<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
</script>
<script>

</script>
<title>Insert title here</title>
</head>
<body>
	<div>
		<header> </header>
		<form action="${ctx }/notice/register.do" method="post">
			title : <input type="text" name="notice_title"><br>
			<br> <input type="text" name="content" ><br>
			<!-- <td><input type="file" name="file1"></td> -->
			
			<br> <input type="submit" value="등록">
		</form>
		<footer> </footer>
	</div>
</body>
</html>