<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내 작품 승인 요청 작성</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="../css/header.css" rel="stylesheet">
<link href="../css/mypage/mypage.css" rel="stylesheet">
<link href="../css/mypage/salesRequestWrite.css" rel="stylesheet">
<script type="text/javascript">
	$(function(){
		$("#salesRequestList").css('color', 'white');
		$("#salesRequestList").css('background-color', '#83b14e');
		
		$("#file").change(function(){
			if($(this).val() != ""){
				var file = this.files[0]; // files 를 사용하면 파일의 정보를 알 수 있음
				// file 은 배열 형태이므로 file[0] 처럼 접근해야함
				var _URL = window.URL || window.webkitURL;
				var img = new Image();
					
				img.src = _URL.createObjectURL(file);
				img.onload = function(){
				 	$("#fileWidth").val(img.naturalWidth);
					$("#fileHeight").val(img.naturalHeight);
				}
			}
		});
	});
</script>
</head>
<body>
<!-- header start -->
<c:import url="../temp/header.jsp"></c:import>
<!-- header finish -->

<!-- contents start -->
<div class="body">
	<c:import url="./menu.jsp"></c:import>
	<div class="totalbody">
		<div class="title">
			<h1>My Page</h1>&nbsp;&nbsp;<h5>내 작품 판매승인 요청 작성</h5>
		</div>
		<form action="mypageSalesRequestWrite.mypage" method="post" enctype="multipart/form-data">
			<input type="hidden" name="nickname" value="${requestScope.nickname}">
			<table class="table table-hover">
				<tr>
					<td>작품명</td>
					<td class="input_info"><input type="text" required="required" name="work"></td>
				</tr>
				<tr>
					<td>파일</td>
					<td class="input_info"><input type="file" required="required" id="file" name="file"></td>
					<input type="hidden" id="fileWidth" name="width"><!-- width 값 -->
					<input type="hidden" id="fileHeight" name="height"><!-- height 값  -->
				</tr>
				<tr>
					<td>가격</td>
					<td class="input_info"><input type="number" required="required" name="price"></td>
				</tr>
				<tr>
					<td>태그</td>
					<td class="input_info"><textarea placeholder="예시)강아지,하늘,풀" name="tag"></textarea></td>
				</tr>
				<tr>
					<td>상세 내용</td>
					<td class="input_info"><textarea name="contents"></textarea></td>
				</tr>
			</table>
			<div class="button">
				<button class="btn btn-default">등록</button>
			</div>
		</form>
	</div>
<div class="push"></div>
</div>
<!-- contents finish -->

<!-- footer start -->
<c:import url="../temp/footer.jsp"></c:import>
<!-- footer finish -->
</body>
</html>