<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {/*프로그램 실행시 시행(js의 load와 같음) */
		var postId = $("#postId").val();

		$.ajax({
			type : 'get',
			url : 'answer/detail.do',
			data : postId
		});
	});
</script>
</head>
<body>

	<table border="1">
		<tr>
			<td>${question.title }</td>
			<br>
		</tr>
		<tr>
			<td>${question.content }</td>
			<br>
		</tr>
		<tr>

			<td><img src=""></td>
			<br>
		</tr>

		<tr>
			<td>${question.member.memberId }</td>
			<br>
		</tr>
		<tr>
			<td><input type="hidden" id="postId" value="${question.postId }">
				<table>
					<c:choose>
						<c:when test="${empty answer || answer eq null  }">
							<form action="${ctx }/answer/register.do" method="post">
								<input type="text" name=question_content> 
								<input type="hidden" name="${question.postId }"> 
								<input type="submit" value="답글달기">
							</form>
						</c:when>
						<c:otherwise>
							<tr>
								<td>${answer.content }</td>
								<td>관리자</td>
								<td><input type="button" value="수정"
									onclick="location.href='${ctx }/answer/modify.do?answerId=${question.postId }'" />
									<input type="button" value="삭제"
									onclick="location.href='${ctx }/answer/remove.do?answerId=${question.postId }'" />
								</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</table></td>


		</tr>
		<tr>
			<td><input type="button" value="수정"
				onclick="location.href='${ctx }/question/modify.do?questionId=${question.postId }'" />
				<input type="button" value="삭제"
				onclick="location.href='${ctx }/question/remove.do?questionId=${question.postId }'" />
			</td>
		</tr>

	</table>




</body>
</html>