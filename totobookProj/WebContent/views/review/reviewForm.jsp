<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var = "ctx"	value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<form action="${ctx }/image/imageupload.do" method="post"
			enctype="multipart/form-data">
			<table border="1">


				<tr>
					<td>상품평</td>
					<td><input type="text" name="comment" value="" style="text-align:left; width:400px; height:200px;"></td>
				</tr>

				<tr>
					<td>사진</td>
					<td><input type="file" name="file1"></td>
				</tr>


			</table>
		</form>
					<button type="button" onclick="javascript:gotoMain();" class="btn">뒤로가기</button>
	</div>

</body>
</html>