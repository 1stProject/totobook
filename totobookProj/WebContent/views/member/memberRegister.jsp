<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath }</c:set>
<html>

<body>
<div class="contents-wrap">
    <h2 class="page-title">신규회원등록</h2>

        <form action="${ctx }/member/register.do" method="post">
            <div>
                <label>아이디: </label>
                <input type="text" name="memberId">
            </div>
            <div>
                <label>아이디체크: </label>
                <input type="text" name="memberId2">
            </div>
            <div>
                <label>이름 : </label>
                <input type="text" name="name">
            </div>
                        <div>
                <label>비밀번호 : </label>
                <input type="password" name="password">
            </div>
                        <div>
                <label>주소 : </label>
                <input type="text" name="address">
            </div>
                        <div>
                <label>휴대폰번호 : </label>
                <input type="text" name="phone">
            </div>
                        <div>
                <label>스팸매일받을래? </label>
                <div class = "radio">
                <input type = "radio" name = "receiveEmail" value = "yes"> ㅇㅇ
				<input type = "radio" name = "receiveEmail" value = "no"> ㄴㄴ
				</div>
            </div>
            <div class="alignRight">
                <input type="reset" value="초기화">
                <input type="submit" value="저장">
            </div>
        </form>
    </div>
</body>
</html>