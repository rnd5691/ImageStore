<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="totalbutton">
	<div class="totalbutton">
		<div class="btn-group-vertical">
			<div class="mypage">MY PAGE</div>
			<a id="myinfo" href="mypageMyInfo.mypage" class="btn btn-default">내 정보</a>
			<button id="byList" type="button" class="btn btn-default">구매 목록</button>
			<c:if test="${sessionScope.artist eq 'artist' }">
				<a id="salesRequestList" class="btn btn-default" href="mypageSalesRequestList.mypage">내 작품 판매승인 요청 현황</a>
				<button type="button" class="btn btn-default">현재 판매 중인 내 작품</button>
				<button type="button" class="btn btn-default">작품 별 수익 현황</button>
			</c:if>
		</div>
	</div>
</div>