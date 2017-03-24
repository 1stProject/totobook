<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
	$(document).ready(function() {/*프로그램 실행시 시행(js의 load와 같음) */
		var postId = $("#postId").val();/*detail.do로 (처음 답글부분 호출위해) */

		$.ajax({
			type : 'get',
			url : 'answer/detail.do',
			data : postId,
			success : function(Answer){
				if(Answer == null){
					 newWin= window.open();
					 newWin.document.write(data);
				}else{
					
				}
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
			<td><input type="hidden" id="postId" value="${question.postId }">
				<table>
					<c:choose>
						<c:when test="${empty answer || answer eq null  }">
								<input type="button" value="답글달기"	onclick="location.href='${ctx }/answer/register.do?answerId=${question.postId }'">
							</form>
						</c:when>
						<c:otherwise>
							<tr>
								<input type="button" value="답글보기"	onclick="location.href='${ctx }/answer/detail.do?answerId=${question.postId }'">
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