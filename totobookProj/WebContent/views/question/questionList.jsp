<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${questionList eq null || empty questionList}">
					<tr>
						<td colspan="6" align="center">등록된 문의가 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${questionList}" var="question" varStatus="sts">
						<tr>
							<td class="ranking">${sts.count}</td>
							<td><a class="detail_btn"
								href="${ctx }/question/detail.do?questionId=${question.postId }">${question.title }</a></td>
							<td>${question.member.memberId }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<td><a class="register_btn"
				href="${ctx }/views/question/questionForm.jsp" />문의글쓰기</td>
		</tbody>
	</table>

</body>
</html>