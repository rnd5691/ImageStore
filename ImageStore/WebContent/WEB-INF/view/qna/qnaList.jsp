<%@page import="com.imagestore.util.MakePage"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.imagestore.qna.QnaDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/header.css" rel="stylesheet">
<link href="../css/qna/qna.css" rel="stylesheet">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
</head>
<body>
<!-- header start -->
<c:import url="../temp/header.jsp"></c:import>
<!-- header finish -->

<!-- contents start -->
<div class="body">
	<div class="allbody">
	<div class="listbody">
	<form name="frm" action="${requestScope.board}List.${requestScope.board}" method="post" class="frm">
		<div id="qnatitle">
		<h1>QnA</h1></div>
		<div class="blank"></div>
		<div>
			<div class="search_kind">
				<input type="hidden" name="curPage">
				<input type="hidden" name="perPage">
				<select name="kind" id="kind" class="kind">
					<option value="title">title</option>
					<option value="writer">writer</option>
					<option value="contents">contents</option>
				</select>
				<input type="text" class="search" id="search"
								placeholder="Enter Search" name="search">
				<input type="button" id="btn" class="btn btn-default"
								value="Search">
			</div>
		</div>
		<div class="form-group">

						<div>
							
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<!-- <button type="submit" class="btn btn-default">Submit</button> -->
							
						</div>
					</div>
		<table class="table table-hover">
			<tr>
				<td class="td1">번호</td>
				<td class="td2">제목</td>
				<td class="td1">작성자</td>
				<td class="td1">내용</td>
				<td class="td1">등록날짜</td>
				
			</tr>
			<c:forEach items="${requestScope.list}" var="dto">
			<tr>
				<td>${dto.qna_seq}</td>
				<td>
				<a href="./${requestScope.board}View.${requestScope.board}?qna_seq=${dto.qna_seq}">${dto.title}</a></td>
				<td>${dto.nickname}</td>
				<td>${dto.contents}</td>
				<td>${dto.reg_date}</td>
			</tr>
			</c:forEach>
			
		</table>
		<c:if test="${not empty member}">
		<div class="writer">
			<a href="./${requestScope.board}Write.${requestScope.board}" class="btn btn-default">글쓰기</a>
		</div>
		</c:if>
		<div class="text-center">
		<ul class="pagination">
			<li><a href="./${requestScope.board}List.${requestScope.board}?curPage=${1}">[맨 처음으로]</a></li>
			<c:if test="${page.curBlock>1}">
			<li><a href="./${requestScope.board}List.${requestScope.board}?curPage=${page.startNum-1}">[이전]</a></li>
			</c:if>
			<c:forEach begin="${page.startNum}" end="${page.lastNum}" var="i">
			<li><a href="./${requestScope.board}List.${requestScope.board}?curPage=${i}">${i}</a></li>
			</c:forEach>
			<c:if test="${page.curBlock<page.totalBlock}">
			<li><a href="./${requestScope.board}List.${requestScope.board}?curPage="${requestScope.page.lastNum+1}">[다음]</a></li>
			</c:if>
			<li><a href="./${requestScope.board}List.${requestScope.board}?curPage=${page.totalPage}">[맨 마지막]</a></li>
		</ul>
		</div>
	</form>
		</div>
	<div class="push"></div>
	</div>
</div>
<!-- contents finish -->

<!-- footer start -->
<c:import url="../temp/footer.jsp"></c:import>
<!-- footer finish -->
</body>
</html>