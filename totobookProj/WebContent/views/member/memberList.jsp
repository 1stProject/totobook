<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath }</c:set>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<head>
<%@ include file="header.jspf" %>
</head>
<nav>
	<%@ include file = "/views/left/leftManagePage.jsp" %>
</nav>
<body>
<div class="col-md-offset-2">
<form action="list.do" method="post">
	<select name="slist">
		<option value="name" >이름</option>
		<option value="phone" >폰번</option>
		<option value="memberId" >아이디</option>
	</select>
	<input type="text" name="search" placeholder="입력ㄱ">
	<input class="btn btn-xs btn-default" type="submit" value="검색">
</form>
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
                <th>폰번</th>
                <th>아이디</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${memberList }" var ="ml">
            
            <tr>
				<td><a href="${ctx }/member/detail.do?memberId=${ml.memberId }">${ml.name }</a></td>
                <td>${ml.phone }</td>
                <td>${ml.memberId }</td>
             </tr>
	</c:forEach>
           
            </tbody>
        </table>
    </div>
</div>
</div>
</body>
</html>








