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
			<a href="${pageContext.request.contextPath}/mypage/mypageMyInfo.mypage" class="btn btn-default">내 정보</a>
			<a class="btn btn-default" href="${pageContext.request.contextPath}/buy/buyList.buy">구매 목록</a>
			<a id="select" class="btn btn-default" href="${pageContext.request.contextPath}/sales/salesRequestList.sales">내 작품 판매승인 요청 현황</a>
			<a class="btn btn-default" href="${pageContext.request.contextPath}/sales/salesRequestNow.sales">현재 판매 중인 내 작품</a>
			<a class="btn btn-default" href="${pageContext.request.contextPath}/sales/salesRequestMoney.sales">작품 별 수익 현황</a>
		</div>
	</div>
</div>
<div class="totalbody">
	<div class="title">
		<h1>My Page</h1>&nbsp;&nbsp;<h5>내 작품 판매승인 요청 List</h5>
	</div>
	<table class="table table-hover">
		<tr>
			<td class="tdtable1">번호</td>
			<td class="tdtable2">작품명</td>
			<td class="tdtable1">작가명</td>
			<td class="tdtable1">등록일자</td>
			<td class="tdtable1">승인현황</td>
		</tr>
		<c:forEach items="${requestScope.list}" var="dto"> --%>
		<tr>
			<td class="tdtable3">${dto.work_seq}</td>
			<td>${dto.work}</td>
			<td class="tdtable3">${dto.nickname}</td>
			<td class="tdtable3">${dto.work_date}</td>
			<td class="tdtable3">${dto.upload_check}</td>
		</tr>		
		</c:forEach> 
	</table>
	<!-- <button id= "btn" class="btn btn-default">내 작품 올리기</button> -->
	<a class="btn btn-default" href="../sales/salesRequestWrite.sales">내 작품 올리기</a>
	<div class="text-center">
	<ul class="pagination">
		<li><a href="./${requestScope.board}RequestList.${requestScope.board}?curPage=${1}">[맨 처음으로]</a></li>
		<c:if test="${page.curBlock>1}">
		<li><a href="./${requestScope.board}RequestList.${requestScope.board}?curPage=${page.startNum-1}">[이전]</a></li>
		</c:if>
		<c:forEach begin="${page.startNum}" end="${page.lastNum}" var="i">
		<li><a href="./${requestScope.board}RequestList.${requestScope.board}?curPage=${i}">${i}</a></li>
		</c:forEach>
		<c:if test="${page.curBlock<page.totalBlock}">
		<li><a href="./${requestScope.board}RequestList.${requestScope.board}?curPage="${requestScope.page.lastNum+1}">[다음]</a></li>
		</c:if>
		<li><a href="./${requestScope.board}RequestList.${requestScope.board}?curPage="${page.totlaPage}">[맨 마지막]</a></li>
	</ul>
	</div>
</div>
<div class="push"></div>
</div>

<!-- contents finish -->

<!-- footer start -->
<c:import url="../temp/footer.jsp"></c:import>
<!-- footer finish -->
</body>
</html>