<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="totalbutton">
	<div class="totalbutton">
		<div class="btn-group-vertical">
			<div class="mypage">MY PAGE</div>
			<a id="myinfo" href="mypageMyInfo.mypage" class="btn btn-default">내 정보</a>
			<a id="buyList" class="btn btn-default" href="mypageBuyList.mypage?user_num=${sessionScope.member.user_num}">구매 목록</a>
			<a id="salesRequestList" class="btn btn-default" href="mypageSalesRequestList.mypage">내 작품 판매승인 요청 현황</a>
			<button type="button" class="btn btn-default">현재 판매 중인 내 작품</button>
			<a id="salesRequestMoney" class="btn btn-default" href="mypageSalesRequestMoney.mypage?user_num=${sessionScope.member.user_num}">작품 별 수익 현황</a>
		</div>
	</div>
</div>