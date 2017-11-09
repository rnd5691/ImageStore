<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- header start -->
	<header>
		<div class="header_wrap">
			<a href="<%=request.getContextPath()%>/qna/qnaList.qna"><img class="logo" align="middle" alt="logo" src="<%=request.getContextPath()%>/images/logo.png"></a>
			<ul class="header_join">
				<li><a href="#">Q&A</a></li>
				<li><a href="#">작품 승인 관리</a></li>
				<li><a href="<%=request.getContextPath()%>/member/memberLogout.member">로그아웃</a></li>
			</ul>
		</div>
		
	</header>