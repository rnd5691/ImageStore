<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="../css/header.css" rel="stylesheet">
<link href="../css/mypage/mypage.css" rel="stylesheet">
<link href="../css/mypage/salesRequestView.css" rel="stylesheet">
<script>
$(function(){
	$("#salesRequestList").css('color', 'white');
	$("#salesRequestList").css('background-color', '#83b14e');
	
	
	
	//���� ������ üũ
	$("#file").change(function(){
		if($(this).val() != ""){
			var file = this.files[0]; // files �� ����ϸ� ������ ������ �� �� ����
			// file �� �迭 �����̹Ƿ� file[0] ó�� �����ؾ���
			var _URL = window.URL || window.webkitURL;
			var img = new Image();
				
			var reader = new FileReader();
			reader.onload = function(rst){
				$("#imagebox").prop("src", rst.target.result);
			}
			reader.readAsDataURL(file);
			
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
<!-- menu�� mypage�� ���Ÿ���� ������ �� �κ� -->

<div class="body">

<c:import url="./menu.jsp"></c:import>
<div class="totalbody">
	<div class="title">
		<h1>My Page</h1>&nbsp;&nbsp;<h5>�� ��ǰ �ǸŽ��� ��û</h5>
	</div>
	<form action="mypageSalesRequestViewUpdate.mypage" method="post" id="frm" enctype="multipart/form-data">
		<input type="hidden" name="work_seq" value="${requestScope.work.work_seq}">
		<table class="table">
			<tr>
				<td rowspan="9" colspan="2">
					<img id="imagebox" src="${pageContext.request.contextPath}/upload/${requestScope.file.file_name}">
				</td>
			</tr>
			<tr>
				<td>��ǰ��</td>
				<td><input name="work" type="text" value="${requestScope.work.work}"></td>
			</tr>
			<tr>
				<td>������Ȳ</td>
				<td><input name="upload_check" type="text" readonly="readonly" value="${requestScope.work.upload_check}"></td>
			</tr>
			<tr>
				<td>�۰���</td>
				<td><input name="nickname" type="text" readonly="readonly" value="${requestScope.work.nickname}"></td>
			</tr>
			<tr>
				<td>��� ����</td>
				<td><input name="work_date" type="date" readonly="readonly" value="${requestScope.work.work_date }"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><input name="price" type="text" value="${requestScope.work.price}"></td>
			</tr>
			<tr>
				<td>���� ���ε�</td>
				<td><input type="file" id="file" name="file"></td>
			</tr>
			<tr>
				<td>���� ������</td>
				<td><input class="size" id="fileWidth" name="width" type="text" readonly="readonly" value="${requestScope.file.width }"> X <input class="size" id="fileHeight" name="height" type="text"readonly="readonly" value="${requestScope.file.height}"></td>
			</tr>
			<tr>
				<td>�� ����</td>
				<td><textarea name="contents">${requestScope.work.contents}</textarea></td>
			</tr>
			<tr>
				<td>�±�</td>
				<td><textarea name="tag">${requestScope.work.tag}</textarea></td>
			</tr>
		</table>
		<c:if test="${requestScope.work.reply ne null}">
			<div class="reply">
				<textarea name="reply" readonly="readonly">${requestScope.work.reply }</textarea>
			</div>		
		</c:if>
		<button class="btn btn-default">UPDATE</button>
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