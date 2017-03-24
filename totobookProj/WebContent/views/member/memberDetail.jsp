<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath }</c:set>
<html>
<head>
<%@ include file="header.jspf" %>
</head>
<title>회원 정보</title>
<body>
<div class="contents-wrap">


    <h2 class="page-title">정보보기</h2>
    <div class="contents">
        <table border="1">     
            <thead>
            <tr>
                <th>이름</th>
                <th>주소</th>
                <th>아이디</th>
                <th>폰번</th>
                <th>이메일</th>
            </tr>
            </thead>
            <tbody>
            
            <tr>
				<td>${memberList.name }</td>
                <td>${memberList.address }</td>
                <td>${memberList.memberId }</td>
                <td>${memberList.phone }</td>
                <td>${memberList.receiveEmail }</td>
               	<td><a href="${ctx }/member/modify.do?memberId=${memberList.memberId }" class="btn btn-xs btn-warning">UPDATE</a></td>
				<td><a href="${ctx }/views/member/pwCheck.jsp?memberId=${memberList.memberId }" class="btn btn-xs btn-danger">DELETE</a></td>
							
             </tr>
           
            </tbody>
        </table>
        
     </div>
</div>

</body>
</html>








