<!-- 회원가입 시 이용약관 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String kind = request.getParameter("kind");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입</title>
<link href="../css/header.css" rel="stylesheet">
<link href="../css/join/joinForm_agreement.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script></head>
<body>
<%@ include file="../temp/header.jsp" %>
<!-- Contents -->
<section class="body">
	<article class="contents">
		<article class="title">
			<h1>회원 가입</h1> <h5>이용약관</h5>
		</article>
		<article class="agreement">
			<article class="whole">
				<b>
					이용약관, 개인정보 수집 및 이용, 위치정보 이용약관 (선택),<br/>
					프로모션 안내 메일 수신(선택)에 모두 동의합니다.
				</b>
				<input id="checkbox" type="checkbox">
			</article>
		</article>
	</article>
</section>
<!-- Contents 끝 -->
<%@ include file="../temp/footer.jsp" %>
</body>
</html>