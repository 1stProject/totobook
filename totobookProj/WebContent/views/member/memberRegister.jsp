<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath }</c:set>
<html>

<body>
	<div class="contents-wrap">
		<h2 class="page-title">신규회원등록</h2>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script>
			$(document).ready(function() {
				//아이디  중복 확인 버튼 클릭
				$("#idCheck").click(function() {
					var id = $("#id").val();
					$.ajax({
						type : 'POST',
						url : "${ctx }/member/idCheck.do",
						data : {
							id : id
						},
						success : function(data) {
							console.log(data);
							$("#result").html(data);
							if ($.trim(data) == 'yes') {
								$('#idmessage').html("사용 가능한 ID 입니다.");
							} else {
								$('#idmessage').html("사용중인 ID 입니다.");

							}

						}

					});
				});
			});
		</script>
		<form action="${ctx }/member/register.do" method="post">
			<div>
				<label>아이디: </label> <input id="id" type="text" name="memberId">
				<button type="button" id="idCheck">중복확인</button>
				<div id="idmessage"></div>
			</div>
			<div>
				<label>이름 : </label> <input type="text" name="name">
			</div>
			<div>
				<label>비밀번호 : </label> <input type="password" name="password">
			</div>
			<div>
				<label>주소 : </label> <input type="text" name="address">
			</div>
			<div>
				<label>휴대폰번호 : </label> <input type="text" name="phone" size="11"
					maxlength="13">

			</div>
			<div>
				<label>스팸매일받을래? </label>
				<div class="radio">
					<input type="radio" name="receiveEmail" value="yes"> ㅇㅇ <input
						type="radio" name="receiveEmail" value="no"> ㄴㄴ
				</div>
			</div>
			<div class="alignRight">
				<input type="reset" value="초기화"> <input type="submit"
					value="가입">
			</div>
		</form>
	</div>
</body>
</html>