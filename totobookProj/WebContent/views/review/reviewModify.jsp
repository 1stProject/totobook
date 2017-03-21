<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="content">


		<table class="section">
			<tr>
				<td>사진</td>
				<td><img src="/review/image.do?productId=${review.product_id}"
					width="128" height="123"></td>
				<td><input type="file" name="file1"></td>

			</tr>
			<tr>
				<td><input type="text" name="comment"
					style="text-align: left; width: 400px; height: 200px;" value="">${review.comment}</td>
			</tr>
		</table>

		<input type="button" name="back" value="뒤로가기"
			onClick="javascript:history.go(-1);" /> <input type="button"
			name="modify" value="수정하기"
			onclick="javascript:location.href='/review/modify.do?memebrid=${review.member_id }';"
			value="수정하기">

	</div>




</body>
</html>