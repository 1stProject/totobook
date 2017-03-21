<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath }</c:set>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원목록</title>
    <link rel="stylesheet" href="${ctx }/style/css/reset.css">
    <link rel="stylesheet" href="${ctx }/style/css/style.css">
</head>
<body>
<div class="contents-wrap">
    <h2 class="page-title">회원목록</h2>
    <div class="contents">
        <table border="1">
            <colgroup>
                <col width="90">
                <col width="*">
                <col width="*">
                <col width="*">
            </colgroup>
            <thead>
            <tr>
                <th>이름</th>
                <th>주소</th>
                <th>폰번호</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${employees }" var ="emp" varStatus="sts">
            <tr>
                <td>${sts.count }</td>
                <td>${emp.no }</td>
                <td>${emp.name }</td>
                <c:choose>
            
                <c:when test="${emp.deptNo ne null }">
                <td>${emp.deptNo }</td>
                </c:when>
				<c:otherwise>
				<td><a href="${ctx }/dept/assign.do?empNo=${emp.no }">부서배정</a></td>    
				         
            	</c:otherwise>
            	</c:choose>
            </tr>
	</c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>








