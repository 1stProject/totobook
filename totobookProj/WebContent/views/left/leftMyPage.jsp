<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Sidebar -->
<div id = "sidebar-wrapper">
<ul class = "sidebar-nav">

	<li>
		<a href = "${ctx }/order/list.do">주문내역 보기</a>
	</li>
	<li>
		<a href = "${ctx }/review/list.do">내 상품평 보기</a>
	</li>
	<li>
		<a href = "${ctx }/member/detail.do?memberId=${member.memberId}">내 정보 보기</a>
	</li>
	<li>
		<a href = "${ctx }/member/modify.do?memberId=${member.memberId }">개인정보 수정</a>
	</li>
	<li>
		<a href = "${ctx }/book/list.do">나의 포토북 관리</a>
	</li>
	<li>
		<a href = "${ctx }/print/list.do">나의 사진인화 관리</a>
	</li>


	<li>
		<a href = "${ctx }/question/list.do">문의하기</a>
	</li> 
	<li>
		<a href = "${ctx }/views/member/pwCheck.jsp?memberId=${member.memberId }">회원탈퇴</a>
	</li>
</ul>
</div>
 <!-- /#sidebar-wrapper -->

 
       