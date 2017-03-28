<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${ctx }/css/layout.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<header>
		<%@ include file="/views/head/header.jspf"%>
	</header>
	<<<<<<< HEAD
	<div class="mypageTitle">
		<div class="title_left">문의사항</div>

		=======
		<!-- <div class="mypageTitle">
		<div class="title_left">문의게시판</div>
		
	</div> -->
		<div class="contentsContainer">

			<div class="mypageTitle">
				<div class="title_left">문의 게시판</div>
				>>>>>>> branch 'development' of
				https://github.com/1stProject/totobook.git
			</div>
			<div class="contentsWithLeft">
				<table class="table table-boardered">
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
								<c:forEach items="${questionList}" var="question"
									varStatus="sts">
									<tr>
										<td class="ranking">${sts.count}</td>
										<td><a class="detail_btn"
											href="${ctx }/question/detail.do?questionId=${question.postId }">${question.title }</a></td>
										<td>${question.member.memberId }</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
						<c:if test="${member.memberId != '' }">
							<td><a class="register_btn"
								href="${ctx }/views/question/questionForm.jsp">문의글쓰기</a></td>
						</c:if>

					</tbody>
				</table>
			</div>
		</div>
		<footer>
			<%@include file="../foot/footer.jspf"%>
		</footer>
</body>
</html>