<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="content">
		<form action="/product/productForm.do" method="post"
			enctype="multipart/form-data">
			<table border="1">
				<tr>
					<td>상품카테고리</td>
					<td><select name="category">
							<option value="book">포토북</option>
							<option value="print">사진</option>
					</select></td>
				</tr>
				<tr>
					<td>상품명</td>
					<td><input type="text" name="rpetime" value=""></td>
				</tr>
				<tr>
					<td>상품가격</td>
					<td><input type="text" name="rpedf"></td>
				</tr>
				<tr>
					<td>상품설명</td>
					<td><input type="text" name="rpedf"></td>
				</tr>
				<tr>
					<td>사이즈옵션</td>
					<td>크기<select name="optionName"><option value="">---</option>
							<option value="15*15">15X15</option>
							<option value="20*20">20X20</option>
							<option value="35*35">35X35</option>
							<option value="print">증명사진</option>
							<option value="3*5">3X5</option>
							<option value="4*6">4X6</option>
					</select>
					</td>
				<tr>
					<td>그외</td>
					<td><select name="optionDesp"><option value="unlight">---</option>
							<option value="light">광택</option>
							<option value="unlight">무광택</option>
							<option value="20">20장</option>
							<option value="30">30장</option>
							<option value="40">40장</option>
					</select></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="file1"></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="file1"></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="file1"></td>
				</tr>
			</table>
			<button type="button" onclick="javascript:gotoMain();" class="btn">목록</button>
			<button type="submit" class="btn">등록</button>
		</form>

	</div>
</body>
</html>