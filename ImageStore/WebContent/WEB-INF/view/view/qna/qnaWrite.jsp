<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/header.css" rel="stylesheet">
<link href="../css/qnaWrite.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<!-- header start -->
<c:import url="../temp/header.jsp"></c:import>
<!-- header finish -->

<!-- contents start -->
<body>
<div class="body">
<form action="qnaWrite.qna" method="post">
		<div id="qnatitle">
		<h1>QnA</h1>&nbsp;<h4>Write</h4></div>
		<div class="blank"></div>
		<table>
			<tr class="trtable">
				<td class="tdtable1">제목</td>
				<td class="tdtable2">
				<input type="text" name="title" id="title" value=""
				placeholder="제목을 입력하세요">
				</td>
				<td class="tdtable1">작성자</td>
				<td class="tdtable2">
				<input type="text" name="writer" id="writer" value="${requestScope.list.writer}"
				readonly="readonly">
				</td>
			</tr>
			<tr>
			<td class="tdtable3">내용</td>
			<td colspan="3">
				<textarea name="contents" id="contents" rows="10" style="width:100%; border:0; resize: none"
				placeholder="내용을 입력하세요"></textarea>
			</td>
			</tr>
		</table>
		<button class="btn btn-default">확인</button>
	</form>
	<div class="push"></div>
	</div>
<!-- contents finish -->

<!-- footer start -->
<c:import url="../temp/footer.jsp"></c:import>
<!-- footer finish -->
</body>
</html>