<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../../../css/header.css" rel="stylesheet">
<link href="../../../css/sales/salesRequestView.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<!-- header start -->
<c:import url="../WEB-INF/view/temp/header.jsp"></c:import>
<!-- header finish -->

<!-- contents start -->
<div class="body">
<form action="">
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
				<td class="tdtable1">작품명</td>
				<td>
				<input type="text" id="work" name="work" value="" readonly="readonly"></td>
				<td class="tdtable1">승인 현황</td>
				<td class="tdtable2">
				<input  type="text" id="upload_check" name="upload_check" value="">
				</td>
			</tr>
			<tr>
				<td class="tdtable1">작가명</td>
				<td>
				<input type="text" id="nickname" name="nickname" value="" readonly="readonly"></td>
				<td class="tdtable1">등록날짜</td>
				<td class="tdtable2">
				<input style="border:none" type="text" id=work_date" name="work_date" value="" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td class="trtable" rowspan="5" colspan="2">
				<div class="images"></div>
				</td>				
			</tr>
			
			<tr>
			<td class="tdtable1">가격</td>
			<td>
			<input type="text" id="price" name="price" value="">
			</td>
			</tr>
			<tr>
			<td class="tdtable1">상세 내용</td>
			<td>
			<input type="text" id="contents" name="contents" value="">
			</td>
			</tr>
			<tr>
			<td class="tdtable1">태그</td>
			<td>
			<input type="text" id="tag" name="tag" value="">
			</td>
			</tr>
			<tr>
			<td class="tdtable1">파일 사이즈</td>
			<td>
			<input type="text" id="size" name="size" value="">
			</td>
			</tr>
		</table>
		<button class="btn btn-default" id="btn1">확인</button>
		<button class="btn btn-default" id="btn2">삭제</button>
		<button class="btn btn-default" id="btn3">수정</button>
	</div>
</div>
</div>
</div>
<div class="push"></div>
</form>
</div>
<!-- contents finish -->

<!-- footer start -->
<c:import url="../WEB-INF/view/temp/footer.jsp"></c:import>
<!-- footer finish -->
</body>
</html>