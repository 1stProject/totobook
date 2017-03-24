<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.4.4.min.js"></script>
<script>
	$(document).ready(function() {
		/*document.write('<input type="submit" value="클릭하면 대화상자" onclick="alert(s);" />');  */
		var postId = $('#postId').val();
		$.ajax({
			dataType : "json",
			url : "http://localhost:8080/totobookProj/answer/detail.do",
			type : "GET",
			async : false,
			data : {
				postId : postId
			},
			success : function(json) {
				alert("dd");
			},
			error:function(request,status,error){
		        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		       }

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
			<!--${question.postId }  -->
			<td><input type="hidden" id="postId" value="82">
				<table>
					<c:choose>
						<c:when test="${empty answer || answer eq null  }">
							<input type="button" value="답글달기"
								onclick="location.href='${ctx }/answer/register.do?answerId=${question.postId }'">
							</form>
						</c:when>
						<c:otherwise>
							<tr>
								<input type="button" value="답글보기"
									onclick="location.href='${ctx }/answer/detail.do?answerId=${question.postId }'">
							</tr>
						</c:otherwise>
					</c:choose>
				</table></td>


		</tr>
		<tr>
			<td><input type="button" value="수정"
				onclick="location.href='${ctx }/question/modify.do?questionId=${question.postId }'">
				<input type="button" value="삭제"
				onclick="location.href='${ctx }/question/remove.do?questionId=${question.postId }'"></td>

		</tr>

	</table>




</body>
</html>