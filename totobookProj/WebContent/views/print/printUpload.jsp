<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var = "ctx" value = "${pageContext.request.contextPath }"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${ctx }/css/layout.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">

</script>


<script>
	$(function(){
		for(var s = 1;s <= 10; s++){
			$("<option value = '"+s+"'>"+s+"</option>").appendTo("#amount1");
		}
		var i=1;
		$("#add").click(function(){
			i++;
			var selectname = "amount"+i;
			var filename = "file"+i;
			$("<input type = 'file' name = '"+filename+"' id = '"+filename+"' accept=image/* onchange='fileinfo(this)'>").appendTo("#upload");
			$("<select name = '"+selectname+"' id = '"+selectname+"'></select> 개 구매<br>").appendTo("#upload");
			var sel = "#amount" + i;
			for(var s = 1;s <= 10; s++){
				$("<option value = '"+s+"'>"+s+"</option>").appendTo(sel);
			}
		});
	});
	function fileinfo(input){
		if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                    $("#image").append('<img src="' + e.target.result + '" style="width:200px; height: 200px;">');
                }
            reader.readAsDataURL(input.files[0]);
            }
		}
</script>

<title>Insert title here</title>
</head>
<body>
<header>
	<%@ include file = "/views/head/header.jspf" %>
</header>
<div class=" col-md-offset-2">
<h1>사진 업로드</h1>
<h3>${product.name }</h3>
	<div id = "image">
		
	</div>
<form action = "${ctx }/print/register.do" method = "post" enctype = "multipart/form-data">
	<div id = "upload">
		<input type = "file" name = "file1" id = "file1" onchange="fileinfo(this)" accept="image/*">
		<select name = "amount1" id = "amount1"></select> 개 구매
		<br>
	</div>
	<input type = "hidden" name = "optionDesp" value = ${optionDesp }">
	<input type = "hidden" name = "productId" value = "${product.productId }">
	<input type = "button" id = "add" value = "사진 추가!">
	<input type = "submit" value = "저장!">
</form>
</div>
<footer>
		<%@include file="../foot/footer.jspf"%>
	</footer>
</body>
</html>