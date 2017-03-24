<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="content">
		<form action="${ctx }/review/modify.do" method="post"
			enctype="multipart/form-data">
			<table border="1">
				<c:forEach items="${review }" var="review">
					<tr>
						<td>사진</td>
						<td><img
							src="${ctx }/review/image.do?orderId=${review.order.orderId}"
							width="128" height="123"></td>
					</tr>
					<tr>
						<td>상품평</td>
						<td><input type="text" name="comment"
							value="${review.comment}"></td>
					</tr>
					<tr>
						<td><input type="file" name="file1"></td>
					</tr>
				</c:forEach>


			</table>
			<input type="button" name="back" value="뒤로가기"
				onClick="javascript:history.go(-1);" />
			<input type="hidden" value="3" name="orderId" >
				
				
			<button type="submit" class="btn">수정</button>

		</form>
	</div>




</body>
</html>