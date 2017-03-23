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
				//비밀번호  확인 버튼 클릭
				$("#pwCheck").click(function() {
					var id = $("#ps").val();
					$.ajax({
						type : 'POST',
						url : "${ctx }/member/pwCheck.do",
						data : {
							id : ps
						},
						success : function(data) {
							console.log(data);
							$("#result").html(data);
							if ($.trim(data) == 'yes') {
								$('#idmessage').html("비밀번호가 일치하지않습니다.");
							} else {
								$('#idmessage').html("삭제완료.");

							}

						}

					});
				});
			});
		</script>
		<form action="${ctx }/member/memberList.do" method="post">
			<div>
				<label>아이디: </label> <input id="ps" type="password" name="password">
			</div>
			<div class="alignRight">
				<button type="reset" >취소</button>
				<button type="button" id="pwCheck">탈퇴</button>
			</div>
		</form>
	</div>
</body>
</html>