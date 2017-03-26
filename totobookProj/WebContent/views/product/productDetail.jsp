<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
	
</script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${ctx }/css/layout.css">
<script>
	$(function(){
		var optionDesp = new Array();
		var price = new Array();
		
		<c:forEach items = "${product.options}" var = "option" varStatus="status">
		optionDesp.push("${option.optionDesp}");
		price.push("${option.optionPrice}");
		</c:forEach>
		$("#option1").change(function(){
			var index = $("#option1 option").index($("#option1 option:selected"));
			
			$("#option2").html("<input type = 'hidden' name = 'size' value = '"+ optionDesp[index]+"'>" + optionDesp[index]);
			$("#price").html("<input type = 'hidden' name = 'price' value = '"+ price[index] + "'>"+price[index]);
		});
	});
</script>
<title>제품상세</title>
</head>
<body>
	<header>
		<%@ include file="/views/head/header.jspf"%>
	</header>
	<c:choose>
		<c:when test="${product.category  eq 'PRINT' }">
		<h3>사진 주문</h3>
			<div class="col-md-offset-2">
				<form method="get" action="${ctx }/print/register.do?">
					<input type="hidden" name="productId" value="${product.productId}">
					<table class = "table table-bordered">
						<tr>
							<td>제품사진</td>
							<td><img
								src="${ctx }/product/image.do?productId=${product.productId}"
								width="128" height="123"></td>
						</tr>
						<tr>
							<td>상품명</td>
							<td>${product.name }</td>
						</tr>
						<c:if test="${product.category eq 'BOOK'}">
							<tr>
								<td>상품가격</td>
								<td>${product.productprice}</td>
							</tr>
						</c:if>
						<tr>
							<td>상품설명</td>
							<td>${product.descript }</td>
						</tr>
						<tr>
							<td colspan="2">옵션</td>
						<tr>
							<td>사이즈</td>
							<td><div class = "col-sm-6"><select name="option1" id="option1" class = "form-control">
									<c:forEach items="${product.options }" var="option">
										<option value="${option.optionName}">${option.optionName}</option>
									</c:forEach>
							</select>
							</div>
							</td>
							
						</tr>
						<tr>
							<td>규격</td>
							<td><div id = "option2">
									<input type = "hidden" name = "size" value = "8.3cm X 5.2cm">
									8.3cm X 5.2cm
								</div>
						</tr>
						<tr>
							<td>가격</td>
							<td><div id = "price">
									<input type = "hidden" name = "price" value = "500">
									500
								</div>
						</tr>

						<c:choose>
							<c:when test="${review eq null || empty review }">
								<tr>
									<td>
									<td colspan="2" align="center">상품평이 없습니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${review }" var="review">
									<c:if test="${not empty review.imageAddress  }">
										<tr>
											<td colspan="2" align="center"><img
												src="${ctx }/product/reviewimage.do?productId=${review.product.productId}"
												width="128px" height="123px"></td>
										</tr>
									</c:if>
									<tr>
										<td colspan="2" align="center">${review.comment }</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</table>
					<button type="button" onclick="javascript:history.back(-1);"
						class="btn">목록</button>
					<input type="submit" class="btn btn-success" value="주문하기">
				</form>

				</div>
			</c:when>



		<c:otherwise>
			<div class="contentsContainer">
				<form method="post" action="${ctx }/book/register.do">

					<!-- Container ======================================================================================= -->


					<div class="container">
						<div class="row">
							<div class="jumbotron">
								<h2>포토북</h2>
							</div>
						</div>
							<div class="row">
								<div class="col-sm-12">
									<ol class="breadcrumb">
										<li>홈</li>
										<li>포토북</li>
										<li class="active">포토북 상세보기</li>
									</ol>
								</div>

							</div>
						</div>
						<div class="row">
							<div class="col-md-3 col-lg-3" style="width: 450px;">

								<img class="feature"
									src="${ctx }/product/image.do?productId=${product.productId}"
									width="450px" height="auto">
							</div>
							<div class="col-md-1 col-lg-1"></div>
							<div class="col-md-7 col-lg-7">
								<ul class="all-blogs">
									<li class="media">
										<div class="media-body">
											<h4 class="media-heading">${team.name }</h4>
										</div>
									</li>
									<li class="media">
										<div class="media-body">
											<h4 class="media-heading">상품명 : ${product.name }</h4>
										</div>
									</li>
									<li class="media">
										<div class="media-body">
											<h4 class="media-heading">옵션선택</h4>
										</div>
									</li>
									<c:forEach items="${product.options }" var="option">
										<li class="media">
											<div class="media-body">
												<h4 class="media-heading">${option.optionName}
													: <select name="${option.optionName}" id="${option.optionName}"
														style="width: 300px;" class="select_02">
														<option value="${option.optionDesp}">${option.optionDesp}</option>
													</select>
												</h4>
											</div>
										</li>
									</c:forEach>
										<li class="media">
											<div class="media-body">
												<h4 class="media-heading">페이지 수
													: <select name="pageOption" id="pageOption"
														style="width: 300px;" class="select_02">
														<option value="10">10 페이지</option>
														<option value="20">20 페이지</option>
														<option value="30">30 페이지</option>
													</select>
												</h4>
											</div>
										</li>
									<li class="media">
										<div class="media-body text-right">
											<h4 class="media-heading">가격 : ${product.productprice}</h4>
										</div>
									</li>
								</ul>
							</div>
							<div class="text-right">
								<input type="hidden" name="productId" value="${product.productId}">
								<button type="submit" class="btn btn-success">추가</button>
								<button type="button" onclick="javascript:history.back(-1);"
									class="btn btn btn-warning">목록</button>
							</div>

							<div class="row">
								<h3>상품 설명</h3>
								${product.descript }
							</div>
							<div class="row">
								<h3>상품평</h3>
								<table style="width: 100%">
									<c:choose>
										<c:when test="${review eq null || empty review }">
											<tr>
												<td>
												<td colspan="2" align="center">상품평이 없습니다.</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach items="${review }" var="review">
												<c:if test="${not empty review.imageAddress  }">
													<tr>
														<td colspan="2" align="center"><img
															src="${ctx }/product/reviewimage.do?productId=${review.product.productId}"
															width="128" height="123"></td>
													</tr>
												</c:if>
												<tr>
													<td colspan="2" align="center">${review.comment }</td>
												</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</table>
							</div>


						</div>


						<%-- 						<tr>
							<td>가격</td>
							<td><select name="optionPrice" id="optionPrice"
								style="width: 80px;" class="select_02">
									<c:forEach items="${product.options }" var="option">
										<option value="${option.optionPrice}">${option.optionPrice}</option>
									</c:forEach>
							</select>
						</tr> --%>

							</form>
						</div>

				
				</c:otherwise>
				</c:choose>
</body>

<footer>
	<%@ include file="/views/foot/footer.jspf"%>

</footer>


</html>