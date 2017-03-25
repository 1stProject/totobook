<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE>
<html>
<head>

<link rel="stylesheet" type="text/css" href="${ctx }/css/layout.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
	
</script>
<script>
	
</script>
<title>Insert title here</title>
</head>
<body>
	<header>
		<%@ include file="/views/head/header.jspf"%>
	</header>
 	<div class="mypageTitle">
		<div class="title_left">공지글작성</div>
		
	</div>
	<div class="table table-boardered" > 
		<header> </header>
		<form action="${ctx }/notice/register.do" method="post"
			enctype="multipart/form-data">
			제목 : <input type="text" name="notice_title"><br> <br>내용
			: <input type="text" name="content"><br>
			<td>사진 첨부 : <input type="file" name="file1"></td> <br>
			 <input	type="submit" value="등록">
		</form>
		<footer> </footer>
	</div>
	<footer>
		<%@include file="../foot/footer.jspf"%>
	</footer>
</body>
</html>