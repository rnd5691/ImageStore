<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내 작품 판매 승인 현황</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="../css/header.css" rel="stylesheet">
<link href="../css/mypage/mypage.css" rel="stylesheet">
<link href="../css/mypage/salesRequestView.css" rel="stylesheet">
</head>
<body>
<!-- header start -->
<c:import url="../temp/header.jsp"></c:import>
<!-- header finish -->

<!-- contents start -->
<!-- menu는 mypage나 구매목록이 나오는 탭 부분 -->

<div class="body">

<div class="totalbutton">
	<div class="totalbutton">
		<div class="btn-group-vertical">
			<div class="mypage">MY PAGE</div>
			<a href="mypageMyInfo.mypage" class="btn btn-default">내 정보</a>
			<button type="button" class="btn btn-default">구매 목록</button>
			<a id="select" class="btn btn-default" href="mypageSalesRequestList.mypage">내 작품 판매승인 요청 현황</a>
			<button type="button" class="btn btn-default">현재 판매 중인 내 작품</button>
			<button type="button" class="btn btn-default">작품 별 수익 현황</button>
		</div>
	</div>
</div>
<div class="totalbody">
	<div class="title">
		<h1>My Page</h1>&nbsp;&nbsp;<h5>내 작품 판매승인 요청</h5>
	</div>
	<form>
		<input type="hidden" name="work_seq" value="${requestScope.work.work_seq}">
		<table class="table">
			<tr>
				<td rowspan="9" colspan="2">
					<img src="../images/test.jpg">
				</td>
			</tr>
			<tr>
				<td>작품명</td>
				<td><input name="work" type="text" readonly="readonly" value="${requestScope.work.work}"></td>
			</tr>
			<tr>
				<td>승인현황</td>
				<td><input name="upload_check" type="text" readonly="readonly" value="${requestScope.work.upload_check}"></td>
			</tr>
			<tr>
				<td>작가명</td>
				<td><input name="nickname" type="text" readonly="readonly" value="${requestScope.work.nickname}"></td>
			</tr>
			<tr>
				<td>등록 일자</td>
				<td><input name="work_date" type="date" readonly="readonly" value="${requestScope.work.work_date }"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input name="price" type="text" readonly="readonly" value="${requestScope.work.price}"></td>
			</tr>
			<tr>
				<td>파일 사이즈</td>
				<td><input class="size" name="width" type="text" readonly="readonly" value="${requestScope.file.width }"> X <input class="size" name="height" type="text"readonly="readonly" value="${requestScope.file.height}"></td>
			</tr>
			<tr>
				<td>상세 내용</td>
				<td><textarea name="contents" readonly="readonly">${requestScope.work.contents}</textarea></td>
			</tr>
			<tr>
				<td>태그</td>
				<td><textarea name="tag" readonly="readonly">${requestScope.work.tag}</textarea></td>
			</tr>
		</table>
		<c:if test="${requestScope.work.reply ne null}">
			<div class="reply">
				<textarea name="reply" readonly="readonly">${requestScope.work.reply }</textarea>
			</div>		
		</c:if>
	</form>
</div>
<div class="push"></div>
</div>

<!-- contents finish -->

<!-- footer start -->
<c:import url="../temp/footer.jsp"></c:import>
<!-- footer finish -->
</body>
</html>