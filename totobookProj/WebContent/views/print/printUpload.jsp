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
	$(function(){
		$(":file").on('change', function(){
			fileinfo(this);
		});
	});
	function fileinfo(input){
		if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                    $("#image").html('<img src="' + e.target.result + '">');
                }

            reader.readAsDataURL(input.files[0]);
            }
		}
	
	
</script>
<title>Insert title here</title>
<style>
</style>
</head>
<body>
<h1>사진 업로드</h1>
<h3>상품명 : 봄</h3>
	<div id = "image">
		
	</div>
<form action = "${ctx }/print/register.do" method = "post" enctype = "multipart/form-data">
	<div id = "upload">
		<input type = "file" name = "file1"><br>
		<input type = "file" name = "file2"><br>
		<input type = "file" name = "file3"><br>
		<input type = "file" name = "file4"><br>
		<input type = "file" name = "file5">
	</div>
	<input type = "submit" value = "저장!">
</form>
</body>
</html>