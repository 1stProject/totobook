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
			<c:forEach items="${questionList}" var="question" varStatus="sts">
				<tr>
					<td class="ranking">${sts.count}</td>
					<td>${question.title }</td>
					<td>${question.member.memberId }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action="${ctx }/question/list.do" method="post">
	<input type="submit"></form>
</body>
</html>