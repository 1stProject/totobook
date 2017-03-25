<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath }</c:set>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${ctx }/css/layout.css">
<link rel="stylesheet" href="${ctx }/css/sidebarheader.css">
</head>
<title>회원 정보</title>
<body>
<header>
		<%@ include file="../head/header.jspf"%>
</header>
			<div class="mypageTitle">
		<div class="title_left">마이페이지</div>
		<ul class="title_ul">
			<li class="title_li"><a href="${ctx }/views/main.jsp">HOME</a></li>
			<li class="title_li_icon">></li>
			<li class="title_li"><a href="${ctx }/order/list.do">마이페이지</a></li>
		</ul>
	</div>
	<nav>
	<c:choose>
						<c:when test="${loginId eq 'admin'}">
							<%@ include file = "/views/left/leftManagePage.jsp" %>
						</c:when>
						<c:otherwise>
							<%@ include file = "/views/left/leftMyPage.jsp" %>	
							</c:otherwise>
					</c:choose>
	
	</nav>
	<div class="col-md-offset-2 col-sm-6 col-lg-6">
    <h2 class="page-title">정보보기</h2>
	
        <table class = "table table-bordered table-stripped">     
            <thead>
            <tr>
                <th>아이디</th>
                <th>이름</th>
                <th>주소</th>
                <th>휴대폰 번호</th>
                <th>이메일</th>
            </tr>
            </thead>
            <tbody>
            
            <tr>
            	<td>${memberList.memberId }</td>
				<td>${memberList.name }</td>
                <td>${memberList.address }</td>
                <td>${memberList.phone }</td>
                <td>${memberList.receiveEmail }</td>
				<td><a href="${ctx }/views/member/pwCheck.jsp?memberId=${memberList.memberId }" class="btn btn-xs btn-danger">탈퇴</a></td>
					<c:choose>
						<c:when test="${loginId eq 'admin'}">
						</c:when>
						<c:otherwise>
							<td><a href="${ctx }/member/modify.do?memberId=${memberList.memberId }" class="btn btn-xs btn-warning">수정</a></td>	
							</c:otherwise>
					</c:choose>
				
				
             </tr>
           
            </tbody>
        </table>
        
     </div>
	</div>
	<footer>
		<%@include file="../foot/footer.jspf"%>
	</footer>

</body>
</html>








