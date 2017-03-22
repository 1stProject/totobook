<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var = "ctx" value = "${pageContext.request.contextPath }"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
</script>
<script>
$(document).ready(function(){
	var i=1;
    $("#add").click(function(){
    	i++;
        $("#upload").append("<br><input type='file'>");
    });
    $("#result").click(function(){
    	i=1;
    	$("#upload").html("<input type = 'file' name = 'file1'>");
    })
});
</script>
<title>Insert title here</title>
<style>
	.image{
		width : 700px;
		height : 500px;
		background-color : yellow;
	}
</style>
</head>
<body>
<h1>사진 업로드</h1>
<h3>상품명 : 봄</h3>
	<div class = "image">
		
	</div>

	<div id = "upload">
		<input type = "file" name = "file1">
	</div>
	<input type = "button" id = "add" value = "사진 추가">
		<input type = "button" id = "result" value ="초기화">
	<input type = "submit" value = "저장!">
</body>
</html>