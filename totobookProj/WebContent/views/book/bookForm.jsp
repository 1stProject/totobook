<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${ctx }/css/layout.css">
<link rel="stylesheet" type="text/css" href="${ctx }/css/cropper.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>totoBook</title>
<script src="${ctx }/js/cropper.js"></script>
<script src="${ctx }/js/jquery-3.1.1.js"></script>
<script src="${ctx }/js/bookEdit.js"></script>
<script src="${ctx }/js/html2canvas.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://fengyuanchen.github.io/js/common.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
</head>
<body>
	<header>
		<%@include file="../head/header.jspf"%>
	</header>

	<div class="photoBookContainer">
		<h3>포토북 편집</h3>
		<%-- 		<form action="${ctx }/book/list.do" method="post" enctype="multipart/form-data" id="photoForm"> --%>
		<form action="${ctx }/book/edit.do" method="post"
			enctype="multipart/form-data" id="photoForm">
			<div id="photoBookDesciption">
				포토북명 : <input type="text" value="${book.bookName}" name="bookName"
					placeholder="${book.bookName}"> 전체 페이지 수 :
				${fn:length(book.pages)} 장 선택한 상품명 : ${book.product.name} 선택된 옵션 :
				${book.option}

			</div>

			<input type="hidden" name="bookId" value="${book.bookId}">
			<div class="photoBookContent" style="display: block">
				<img src="${ctx }/views/book/toLeft.png" id="toBeforePage"
					class="leftRightBtnImg" style="visibility: hidden">

				<c:forEach items="${book.pages }" var="page" varStatus="sts">
					<c:if test="${(sts.count mod 2) eq 0 }">
						<c:choose>
							<c:when test="${fn:substring(page.imageAddress, 0, 6) eq '/images' }">
							<div id="bookPage${sts.count }" class="LeftPageDiv"
							ondrop="drop(event)" ondragover="allowDrop(event)"
							style="display: none;">
							</c:when>
							<c:otherwise>
							<div id="bookPage${sts.count }" class="LeftPageDiv"
							ondrop="drop(event)" ondragover="allowDrop(event)"
							style="display: none; background-image:url('${page.imageAddress}')">							
							</c:otherwise>
						</c:choose>
							<input type="hidden" id="pageInput${sts.count }"
								name="pageInput${sts.count }" value="${page.imageAddress }">
							<input type="hidden" name="imgSrc${sts.count }"
								id="imgSrc${sts.count }" value="">
						</div>

						<%-- 			<div id="bookPage${sts.count }" class="LeftPageDiv" ondrop="drop(event)" ondragover="allowDrop(event)" style="display:none;background-image:'C:/Users/kosta/Downloads/수업자료/144기_김주희/03.Tomcat/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/totobookProj/upload\book/${book.bookId}_page${sts.count }'">
			 			
			 			<input type="hidden" id="bookPage${sts.count }Input" name="${page.pageId}" value="${page.imageAddress }">
	 					<input type="hidden" name="imgSrc${sts.count }" id="imgSrc${sts.count }" value=""></div>
			 --%>
					</c:if>
				</c:forEach>

				<div class="bookPaging1"></div>
				<div class="bookPaging2"></div>
				<c:forEach items="${book.pages }" var="page" varStatus="sts">
					<c:if test="${(sts.count mod 2) != 0 }">
						<input type="hidden" id="pageInput${sts.count }"
							name="pageInput${sts.count }" value="${page.imageAddress }">
						<input type="hidden" name="imgSrc${sts.count }"
							id="imgSrc${sts.count }" value="">
						<div id="bookPage${sts.count }" class="RightPageDiv"
							ondrop="drop(event)" ondragover="allowDrop(event)"
							style="display: none;"></div>
					</c:if>
				</c:forEach>

				<img src="${ctx }/views/book/toRight.png" class="leftRightBtnImg"
					id="toNextPage">
				<div id="layoutDiv">
					레이아웃선택 <br>
					<br> <img class="layoutIcon1"
						src="${ctx }/views/book/A3_layout_1.jpg" draggable="false">
					<img class="layoutIcon1" src="${ctx }/views/book/A3_layout_2.jpg"
						draggable="false"> <img class="layoutIcon1"
						src="${ctx }/views/book/A3_layout_3.jpg" draggable="false">

					<div class="btn-group">
						<!-- 							<button type="button" class="btn btn-primary" data-method="rotate" data-option="-45" title="Rotate Left">
								<span class="docs-tooltip" data-toggle="tooltip" title="cropper.rotate(-45)">
									<span class="fa fa-rotate-left">좌로 회전</span>
								</span>
							</button>
							<button type="button" class="btn btn-primary" data-method="rotate" data-option="45" title="Rotate Right">
								<span class="docs-tooltip" data-toggle="tooltip" title="cropper.rotate(45)">
									<span class="fa fa-rotate-right">우로 회전</span>
								</span>
							</button> -->
						<Br>
						<Br>
						<Br>
						<br> 현재 페이지<br> <span id="currentRightPage"
							style="font-weight: bold"></span>/${fn:length(book.pages)}

					</div>
				</div>
			</div>
			<div id="photoListDiv">
				<h4>사진목록</h4>
				<input type="file" name="photofile" style="width: 250px;"
					accept="image/*" multiple onchange="fileInfo(this)">
				<div id="img_box"></div>
			</div>

			<div class="btnDiv">
				<button type="button" id="saveBook">편집저장</button>
				<button type="reset">취소</button>
			</div>

			<input type="hidden" id="pageCount" value="${fn:length(book.pages)}">
			<input type="hidden" id="curPage" name="curPage">

		</form>
	</div>
	<div id="previewImage"></div>


	<footer>
		<%@include file="../foot/footer.jspf"%>
	</footer>
</body>
</html>