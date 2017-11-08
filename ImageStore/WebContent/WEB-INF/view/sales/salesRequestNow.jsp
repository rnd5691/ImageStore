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
<link href="../css/sales/salesRequestNow.css" rel="stylesheet">
</head>
<body>
<!-- header start -->
<c:import url="../temp/header.jsp"></c:import>
<!-- header finish -->

<!-- contents start -->
<!-- menu는 mypage나 구매목록이 나오는 탭 부분 -->

<div class="body">
<form action="">

	<div class="totalbutton">
		<div class="btn-group-vertical">
			<div class="btn-group-vertical">
			<div class="mypage">MY PAGE</div>
			<a href="mypageMyInfo.mypage" class="btn btn-default">내 정보</a>
			<a class="btn btn-default" href="${pageContext.request.contextPath}/buy/buyList.buy">구매 목록</a>
			<a class="btn btn-default" href="${pageContext.request.contextPath}/sales/salesRequestList.sales">내 작품 판매승인 요청 현황</a>
			<a id="select" class="btn btn-default" href="${pageContext.request.contextPath}/sales/salesRequestNow.sales">현재 판매 중인 내 작품</a>
			<a class="btn btn-default" href="${pageContext.request.contextPath}/sales/salesRequestMoney.sales">작품 별 수익 현황</a>
			</div>
		</div>
	</div>
<div class="totalbody">
	<div class="title">
		<h1>My Page</h1>&nbsp;&nbsp;<h5>현재 판매 중인 내 작품</h5>
	</div>
	<div class="imagebody">
		<input type="hidden" id="user_num" name="user_num" value="${sessionScope.member.user_num}">
			<table>
				<tr>
					<td class="tdtable1">
					<input type="checkbox">
					<div class="images1"></div></td>
					<td class="tdtable1">
					<input type="checkbox">
					<div class="images1"></div></td>						<td class="tdtable1">
					<input type="checkbox">
					<div class="images1"></div></td>
				</tr>
				<tr>
					<td class="tdtable1">
					<input type="checkbox">
					<div class="images1"></div></td>
					<td class="tdtable1">
					<input type="checkbox">
					<div class="images1"></div></td>
					<td class="tdtable1">
					<input type="checkbox">
					<div class="images1"></div></td>
				</tr>
			</table>
			</div>
		</div>
</form>
<div class="push"></div>
</div>

<!-- contents finish -->

<!-- footer start -->
<c:import url="../temp/footer.jsp"></c:import>
<!-- footer finish -->
</body>
</html>