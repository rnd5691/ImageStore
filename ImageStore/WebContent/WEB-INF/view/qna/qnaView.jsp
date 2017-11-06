<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/header.css" rel="stylesheet">
<link href="../css/qna/qnaView.css" rel="stylesheet">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
</head>
<body>
<!-- header start -->
<c:import url="../temp/header.jsp"></c:import>
<!-- header finish -->

<%-- ${login eq admin } --%>


<!-- contents start -->
<div class="body">
	<form name="frm" action="${requestScope.board}View.${requestScope.board}" method="post" class="frm">
	<div id="qnatitle">
	<h1>QnA</h1>&nbsp;<h4>View</h4></div>
	<div class="blank"></div>
	<input type="hidden" id="qna_seq" name="qna_seq" value="${view.qna_seq}">
	<table class="table table-hover">
		<tr class="trtable">
			<td class="tdtable1">등록일</td>
			<td class="tdtd"><input type="text" id="reg_date" name="reg_date" value="${view.reg_date}" readonly="readonly"></td>
			<td class="tdtable2">처리상태</td>
			<td class="tdtd"><input type="text" id="reply_check" name="reply_check" value="${view.reply_check}" readonly="readonly"></td>
		</tr>
		<tr class="trtable">
			<td class="tdtable1">제목</td>
			<td class="tdtd"><input type="text" id="title" name="title" value="${view.title}" readonly="readonly"></td>
			<td class="tdtable1">작성자</td>
			<td class="tdtd"><input type="text" id="nickname" name="nickname" value="${view.nickname}" readonly="readonly"></td>
		</tr>
		<tr class="trtable">
			<td class="tdtable1" id="tdtable1_1">내용</td>
			<td colspan="3" class="tdtable3">
				<textarea id="contents" name="contents" class="area1" rows="12" style="width:100%; border:0; resize: none" readonly="readonly">${requestScope.view.contents}</textarea>
			</td>
		</tr>
		</table>
	
		
		<div class="button" id="button1">
			<a href="./${requestScope.board}Delete.${requestScope.board}?qna_seq=${view.qna_seq}" class="btn btn-default">삭제</a>
			<a href="./${requestScope.board}Update.${requestScope.board}?qna_seq=${view.qna_seq}" class="btn btn-default">수정</a>
		</div>
		<!-- <form action="./qnaUpdate.qna" method="post"> -->
		<table class="answer">
			<tr class="trtable9">
				<td class="tdtable7">답변</td>
				<td colspan="3" class="tdtable8">
				<textarea rows="9" style="width:100%; border:0; resize: none"></textarea>
				</td>
			</tr>
		</table>
		<div id="blank1"></div>
		
		<div class="button">
	<a href="./${requestScope.board}Write.${requestScope.board}" class="btn btn-default">답변쓰기</a>
	<a href="./${requestScope.board}Delete.${requestScope.board}?qna_seq=${view.qna_seq}" class="btn btn-default">삭제</a>
	<a href="./${requestScope.board}Update.${requestScope.board}?qna_seq=${view.qna_seq}" class="btn btn-default">수정</a>
	</div>
	<div class="push"></div>
		</form>
</div>

<!-- contents finish -->

<!-- footer start -->
<c:import url="../temp/footer.jsp"></c:import>
<!-- footer finish -->
</body>
</html>