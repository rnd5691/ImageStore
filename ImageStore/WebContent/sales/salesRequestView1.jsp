<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/header.css" rel="stylesheet">
<link href="../css/sales/salesRequestView1.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<!-- header start -->
<c:import url="../temp/header.jsp"></c:import>
<!-- header finish -->

<!-- contents start -->
<div class="body">
<form action="" method="post">
<div class="allbody">
<div class="totalbutton">
	<div class="btn-group-vertical">
		<button type="button" class="btn btn-default">MY PAGE</button>
		<button type="button" class="btn btn-default">내 정보</button>
		<button type="button" class="btn btn-default">내 작품 판매승인 요청 현황</button>
		<button type="button" class="btn btn-default">현재 판매 중인 내 작품</button>
		<button type="button" class="btn btn-default">작품 별 수익 현황</button>
	</div>
</div>
<div class="viewbody">
	<div class="bodytable">
		<div class="viewtitle">
			<h1>My Page</h1>&nbsp;&nbsp;<h4>내 작품 판매승인 요청 View</h4>
		</div>
		<div class="viewtable">
			<table class="table table-hover">
				<tr>
					<td class="tdtable1" rowspan="9" colspan="2">
					
					</td>
				</tr>
				<tr>
					<td class="tdtable2">작품명</td>
					<td  class="tdtable3">
					<input type="text" id="work" name="work" value="">
					</td>
				</tr>
				<tr>
					<td class="tdtable2">작가명</td>
					<td class="tdtable3">
					<input type="text" id="nickname" name="nickname" value="">
					</td>
				</tr>
				<tr>
					<td class="tdtable2">등록일자</td>
					<td class="tdtable3">
					<input type="text" id="work_date" name="work_date" value="">
					</td>
				</tr>
				<tr>
					<td class="tdtable2">가격</td>
					<td class="tdtable3">
					<input type="text" id="price" name="price" value="">
					</td>
				</tr>
				<tr>
					<td class="tdtable2">상세내용</td>
					<td class="tdtable3">
					<input type="text" id="contents" name="contents" value="">
					</td>
				</tr>
				<tr>
					<td class="tdtable2">태그</td>
					<td class="tdtable3">
					<input type="text" id="tag" name="tag" value="">
					</td>
				</tr>
				<tr>
					<td class="tdtable2">파일사이즈</td>
					<td class="tdtable3">
					<input type="text" id="size" name="size" value="">
					</td>
				</tr>
				<tr>
					<td class="tdtable2">승인유무</td>
					<td class="tdtable3">
					Y &nbsp;<input type="radio" id="upload_check" name="upload_check" value="">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					N &nbsp;<input type="radio" id="upload_check" name="upload_check" value="">
					</td>
				</tr>
			</table>
			<button type="button" class="btn btn-default" id="btn">확인</button>
		</div>
	</div>
</div>
</div>
<div class="push"></div>
</form>
</div>
<!-- contents finish -->

<!-- footer start -->
<c:import url="../temp/footer.jsp"></c:import>
<!-- footer finish -->
</body>
</html>