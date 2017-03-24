<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<c:set var = "ctx"	value="${pageContext.request.contextPath }"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${ctx }/css/layout.css">
<link rel="stylesheet" type="text/css" href="${ctx }/css/cropper.css">
<title>totoBook</title>
		<script src="${ctx }/views/book/js/cropper.js"></script>
      	<script src="${ctx }/views/book/js/jquery-3.1.1.js"></script>
  		<script src="${ctx }/views/book/js/bookEdit.js"></script>
        <script src="${ctx }/views/book/js/html2canvas.js"></script>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="https://fengyuanchen.github.io/js/common.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
</head>
<body>
	<header>
		<%@include file="../head/header.jspf" %>
	</header>
	
	<div class="photoBookContainer">
		<h3>포토북 편집</h3>
		<form action="${ctx }/book/edit.do" method="post" enctype="multipart/form-data">
        	<div id="photoBookDesciption">
				포토북명 : <input type ="text" value="" name="bookName" placeholder="${book.bookName}">
				전체 페이지 수 : ${fn:length(book.pages)}" 장
				선택한 상품명 : ${book.product.name}
				선택된 옵션 : ${book.option }      

			</div>

			<div class="photoBookContent" style="display:block">           
			  <img src="${ctx }/views/book/toLeft.png" id="toBeforePage" class="leftRightBtnImg" style="visibility: hidden">
				<div id="bookPageLeft" class="pageDiv" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
				<div class="bookPaging1"></div>
				<div class="bookPaging2"></div>
				<div id="bookPageRight" class="pageDiv" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

			  <img src="${ctx }/views/book/toRight.png" class="leftRightBtnImg" id="toNextPage">
				<div id="layoutDiv">레이아웃선택
					<img class="layoutIcon1" src="${ctx }/views/book/A3_layout_1.jpg" draggable="false">
					<img class="layoutIcon1" src="${ctx }/views/book/A3_layout_2.jpg" draggable="false">
					<img class="layoutIcon1" src="${ctx }/views/book/A3_layout_3.jpg" draggable="false">

						<div class="btn-group">
							<button type="button" class="btn btn-primary" data-method="rotate" data-option="-45" title="Rotate Left">
								<span class="docs-tooltip" data-toggle="tooltip" title="cropper.rotate(-45)">
									<span class="fa fa-rotate-left">좌로 회전</span>
								</span>
							</button>
							<button type="button" class="btn btn-primary" data-method="rotate" data-option="45" title="Rotate Right">
								<span class="docs-tooltip" data-toggle="tooltip" title="cropper.rotate(45)">
									<span class="fa fa-rotate-right">우로 회전</span>
								</span>
							</button>
							    <input id="btn-Preview-Image" type="button" value="Preview"/>
								<a id="btn-Convert-Html2Image" href="#">Download</a>
						</div>
				</div>
			</div>
			<div id="photoListDiv">사진목록
				<input type="file" name="photofile" style="width:250px;" accept="image/*" multiple onchange="fileInfo(this)" >
				<div id="img_box"></div>
			</div>

			<div class="btnDiv">
				<button type="submit" >편집저장</button>
				<button type="reset">취소</button>
			</div>
		</form>
	</div>
	<div id="previewImage">
	</div>

  <script src="${ctx }/views/book/cropper/dist/cropper.js"></script>
  <script>

  </script>
	
	<footer>
		<%@include file="../foot/footer.jspf" %>
	</footer>
</body>
</html>