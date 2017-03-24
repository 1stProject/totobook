<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var = "ctx"	value="${pageContext.request.contextPath }"/>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="content">
		<form action="${ctx }/review/register.do" method="post"
			enctype="multipart/form-data">
			<table border="1">
							<tr>
					<td>상품평</td>
					<td><input type="text" name="comment" value=""
						style="text-align: left; width: 400px; height: 200px;"></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="file1"></td>
				</tr>
			</table>
			<button type="button" onclick="javascript:gotoMain();" class="btn">목록</button>
			<button type="submit" class="btn">등록</button>
		</form>

	</div>
</body>
</html>