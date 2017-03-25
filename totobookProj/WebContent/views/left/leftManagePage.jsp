<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id = "sidebar-wrapper">
<ul class = "sidebar-nav">
	<li>
		<a href = "${ctx }/member/list.do">회원 검색</a>
	</li>
	<li>
		<a href = "${ctx }/product/list.do">상품 관리</a>
	</li>
	<li>
		<a href = "${ctx }/review/list.do">상품평 관리</a>
	</li>
	<li>
		<a href = "${ctx }/order/list.do">주문 목록/관리</a>
	</li>
</ul>
</div>