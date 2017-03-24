<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${ctx }/css/layout.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
	<%@ include file = "/views/head/header.jspf" %>
	</header>
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
				<c:when test="${NoticeList eq null || empty NoticeList}">
					<tr>
						<td colspan="6" align="center">등록된 공지가 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${NoticeList}" var="notice" varStatus="sts">
						<tr>
							<td class="ranking">${sts.count}</td>
							<td><a class="detail_btn"
								href="${ctx }/notice/detail.do?noticeId=${notice.postId }">${notice.title }</a></td>
							<td>${notice.member.memberId }</td>
							<td><a class="remove_btn"
								href="${ctx }/notice/remove.do?noticeId=${notice.postId }">삭제</a></td>
						</tr>
					</c:forEach>

				</c:otherwise>
			</c:choose>
			<td><a class="register_btn"
				href="${ctx }/views/notice/noticeForm.jsp" />글쓰기</td>
		</tbody>
	</table>
	<footer>
		<%@include file="../foot/footer.jspf" %>
	</footer>

</body>
</html>