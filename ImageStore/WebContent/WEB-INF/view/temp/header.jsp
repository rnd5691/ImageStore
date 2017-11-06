<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- header start -->
	<header>
		<div class="header_wrap">
			<ul class="header_menu">
				<li>이미지</li>
				<li>동영상</li>
				<li>QnA</li>
				<li>무명작가</li>
			</ul>
			<a href="<%=request.getContextPath()%>/index.jsp"><img class="logo" align="middle" alt="logo" src="<%=request.getContextPath()%>/images/logo.png"></a>
			<ul class="header_join">
				<li>Pay Info</li>
				<c:choose>
					<c:when test="${sessionScope.member eq null}">
						<li>
							<div>
							  <!-- Trigger the modal with a button -->
							  <button class="login"data-toggle="modal" data-target="#myModal">로그인</button>
							
							</div>
						</li>
						<li><a href="<%=request.getContextPath() %>/member/memberAgreement.member">JOIN</a></li>
					</c:when>
					<c:when test="${sessionScope.member ne null}">
						<li><a href="<%=request.getContextPath()%>/member/memberLogout.member">로그아웃</a></li>
						<li><a href="<%=request.getContextPath()%>/mypage/mypageMyInfo.mypage">MYPAGE</a></li>
					</c:when>
				</c:choose>
			</ul>
		</div>
		
	</header>
	<!-- Modal -->
					  <div class="modal fade" id="myModal" role="dialog">
					    <div class="modal-dialog modal-sm">
					      <div class="modal-content">
					      	
						    <div class="modal-header">
						        <h4 class="modal-title">로그인</h4>
						    	<button type="button" class="close" data-dismiss="modal">&times;</button>
						    </div>
						    <form action="<%=request.getContextPath() %>/member/memberLogin.member">
						    	<div class="modal-body">
						    		<div class="kind">
							    		<input type="radio" name="kind" value="company" required="required"> 기업
							    		<input type="radio" name="kind" value="person" required="required"> 개인
						    		</div>
						          	<input class="idpw" type="text" name="id" required="required" placeholder="아이디를 입력"><br/>
						         	<input class="idpw" type="password" name="pw" required="required" placeholder="비밀번호를 입력">
						        </div>
						        <div class="modal-footer">
						          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						          <button class="btn btn-default">Login</button>
						        </div>						   
						    </form>
					      </div>
					    </div>
					  </div>
