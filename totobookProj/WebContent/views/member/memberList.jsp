<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath }</c:set>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원목록</title>
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
            <c:forEach items="${memberList }" var ="ml">
            <tr>
                <td>${ml.name }</td>
                <td>${ml.address }</td>
                <td>${ml.phone }</td>
             </tr>
	</c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>








