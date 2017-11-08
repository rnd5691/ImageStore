<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Q&A View</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="../css/header.css" rel="stylesheet">
<link href="../css/qna/qnaWrite.css" rel="stylesheet">
<link href="../css/qna/qnaView.css" rel="stylesheet">
<script type="text/javascript">
	$(function(){
		if($(".reply_check").val()=='답변 미완료'){
		$(".reply_check").css('color', 'red');
		}else{
		$(".reply_check").css('color', 'blue');
		}
	});
</script>
</head>
<!-- header start -->
<c:import url="../temp/header.jsp"></c:import>
<!-- header finish -->

<!-- contents start -->
<body>
<div class="body">
	<div class="qnaTitle">
		<h1>Q&A</h1> <h4>View</h4>
	</div>
	<form action="./qnaUpdate.qna">
		<article>
			<input type="hidden" name="qna_seq" value="${requestScope.qna.qna_seq}">
			<div id="view_title">
				<input class="view_title" type="text" name="title" readonly="readonly" value="${requestScope.qna.title}">
			</div>
			<div id="second_title">
				작성자 : <input class="writer" type="text" name="writer" readonly="readonly" value="${requestScope.qna.writer}">
				<input class="reply_check" type="text" name="reply_check" readonly="readonly" value="${requestScope.qna.reply_check}">
				<input id="date" type="text" name="write_date" readonly="readonly" value="${requestScope.qna.reg_date}">
			</div>
			<div id="contents">
				<textarea name="contents" readonly="readonly">${requestScope.qna.contents}</textarea>
			</div>
			<c:if test="${requestScope.qna.reply ne null }">
				<div class="reply">
					<textarea readonly="readonly">${requestScope.qna.reply}</textarea>
				</div>
			</c:if>
			<c:if test="${sessionScope.writer eq requestScope.qna.writer }">
				<div class="button">
					<button class="btn btn-default">수정</button>
					<a href="./qnaDelete.qna?qna_seq=${requestScope.qna.qna_seq}"class="btn btn-default">삭제</a>
				</div>	
			</c:if>
				
		</article>
	</form>
	<div class="push"></div>
</div>
<!-- contents finish -->

<!-- footer start -->
<c:import url="../temp/footer.jsp"></c:import>
<!-- footer finish -->
</body>
</html>