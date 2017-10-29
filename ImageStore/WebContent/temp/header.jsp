<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script></head>
    
<!-- header start -->
	<header>
		<div class="header_wrap">
			<ul class="header_menu">
				<li>이미지</li>
				<li>동영상</li>
				<li>QnA</li>
				<li>무명작가</li>
			</ul>
			<ul class="header_join">
				<li>Pay Info</li>
				<li>LOGIN</li>
				<li><a href="<%=request.getContextPath() %>/join/joinForm_kind.jsp">JOIN</a></li>
			</ul>
		</div>
	</header>