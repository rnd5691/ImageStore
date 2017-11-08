<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/css/mypage/mypage.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/header.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/sales/salesRequestWrite.css" rel="stylesheet">
</head>
<body>
<!-- header start -->
<c:import url="../temp/header.jsp"></c:import>
<!-- header finish -->

<!-- contents start -->
<div class="body">
<form action="" method="post" id="frm">
	
		<div class="totalbutton">
			<div class="btn-group-vertical">
				<button type="button" class="btn btn-default">MY PAGE</button>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/mypage/mypageMyInfo.mypage">내 정보</a>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/buy/buyList.buy">구매 목록</a>
				<a id="select" class="btn btn-default" href="${pageContext.request.contextPath}/sales/salesRequestList.sales">내 작품 판매승인 요청 현황</a>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/sales/salesRequestNow.sales">현재 판매중이 내 작품</a>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/sales/salesRequestMoney.sales">작품 별 수익 현황</a>
			</div>
		</div>
		<div class="writebody">
			<div class="writetitle">
				<h1>판매승인 요청</h1>&nbsp;&nbsp;<h4>write</h4>
			</div>
			<div class="writetable">
				<table class="table table-hover">
					<tr>
						<td class="tdtable1">작품명</td>
						<td>
						<input type="text" id="work" name="work" value="">
						</td>
					</tr>
					<tr>
						<td class="tdtable1">파일</td>
						<td>
						<input type="text" id="file_name" name="file_name" value="">
						<input type="file" id="file_route" name="file_route" value="">
						</td>
					</tr>
					<tr>
						<td class="tdtable1">가격</td>
						<td>
						<input type="text" id="price" name="price" value="">원
						</td>
					</tr>
					<tr>
						<td class="tdtable1">태그</td>
						<td>
						<input type="text" id="tag" name="tag" value="">
						</td>
					</tr>
					<tr>
						<td class="tdtable1">상세내용</td>
						<td>
						<input type="text" id="contents" name="contents" value="">
						</td>
					</tr>
				</table>
				<button id="btn" type="button" class="btn btn-default">등록 하기</button>
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