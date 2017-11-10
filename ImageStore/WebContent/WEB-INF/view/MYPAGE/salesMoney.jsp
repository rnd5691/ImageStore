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
<link href="../css/sales/salesMoney.css" rel="stylesheet">
</head>
<body>
<!-- header start -->
<c:import url="../temp/header.jsp"></c:import>
<!-- header finish -->

<!-- contents start -->
<!-- menu는 mypage나 구매목록이 나오는 탭 부분 -->

<div class="body">
	<div class="totalbutton">
		<div class="btn-group-vertical">
			<div class="mypage">MY PAGE</div>
			<a href="${pageContext.request.contextPath}/mypage/mypageMyInfo.mypage" class="btn btn-default">내 정보</a>
			<a class="btn btn-default" href="${pageContext.request.contextPath}/buy/buyList.buy">구매 목록</a>
			<a class="btn btn-default" href="${pageContext.request.contextPath}/sales/salesRequestList.sales">내 작품 판매승인 요청 현황</a>
			<a class="btn btn-default" href="${pageContext.request.contextPath}/sales/salesRequestNow.sales">현재 판매 중인 내 작품</a>
			<a id="select" class="btn btn-default" href="${pageContext.request.contextPath}/sales/salesRequestMoney.sales">작품 별 수익 현황</a>
		</div>
	</div>
<div class="totalbody">
	<div class="title">
		<h1>My Page</h1>&nbsp;&nbsp;<h5>작품 별 수익 현황</h5>
	</div>
	<div class="moneytable">
	<input type="hidden" id="user_num" name="user_num" value="${sessionScope.member.user_num}">
			<table id="table1" class="table table-hover">
				<tr>
					<td class="tdtable1" colspan="2">총 내 작품</td>
					<td>
					<input type="text" id="totalfile" name="totalfile" value="">개
					</td>
					<td class="tdtable1" colspan="2">총 판매 금액</td>
					<td>
					<input type="text" id="totalmoney" name="totalmoney" value="">원
					</td>
				</tr>
			</table>
			<table class="table table-hober">
				<tr>
					<td class="tdtable1">번호</td>
					<td class="tdtable1">작품명</td>
					<td class="tdtable1">작가명</td>
					<td class="tdtable1">등록일자</td>
					<td class="tdtable1">판매금액</td>
					<td class="tdtable1">수익금액</td>
				</tr>
				
				<c:forEach items="${requestScope.list}" var="dto">
				<tr>
					<td class="tdtable2">${dto.work_seq}</td>
					<td class="tdtable2">${dto.work}</td>
					<td class="tdtable2">${dto.nickname}</td>
					<td class="tdtable2">${dto.work_date}</td>
					<td class="tdtable2">${dto.price}</td>
					<td class="tdtable2"></td>
				</tr>
				</c:forEach>
			</table>
			<div class="paging">
				<ul class="pagination">
					<c:if test="${makePage.curBlock>1}">
						<li><a href="./mypageSalesMoney.mypage?curPage=1">&lt;&lt;</a></li>
						<li><a href="./mypageSalesMoney.mypage?curPage=${makePage.startNum-1}">[이전]</a></li>
					</c:if>
					<c:forEach begin="${makePage.startNum}" end="${makePage.lastNum}" var="i">
						<li><a href="./mypageSalesMoney.mypage?curPage=${i}">${i}</a></li>
					</c:forEach>
					<c:if test="${makePage.curBlock < makePage.totalBlock}">
						<li><a href="./mypageSalesMoney.mypage?curPage=${makePage.getLastNum()+1}">[다음]</a></li>
						<li><a href="./mypageSalesMoney.mypage?curPage=${makePage.totalPage}">&gt;&gt;</a></li>
					</c:if>
				</ul>
			</div>
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