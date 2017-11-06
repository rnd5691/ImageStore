<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../../../css/header.css" rel="stylesheet">
<link href="../../../css/sales/salesRequestWrite.css" rel="stylesheet">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<!-- header start -->
<c:import url="../WEB-INF/view/temp/header.jsp"></c:import>
<!-- header finish -->

<!-- contents start -->
<div class="body">
<form action="" method="post" id="frm">
	<div class="allbody">
		<div class="totalbutton">
			<div class="buttongroup">
				<button type="button" class="btn btn-default">MY PAGE</button>
				<button type="button" class="btn btn-default">내 정보</button>
				<button type="button" class="btn btn-default">내 작품 판매승인 요청 현황</button>
				<button type="button" class="btn btn-default">현재 판매 중인 내 작품</button>
				<button type="button" class="btn btn-default">작품 별 수익 현황</button>
			</div>
		</div>
		<div class="writebody">
			<div class="writetitle">
				<h1>판매승인 요청</h1>&nbsp;&nbsp;<h4>write</h4>
			</div>
			<div class="writetable">
				<table class="table table-hover">
					<tr>
						<td>작품명</td>
						<td>
						<input type="file">
						</td>
				</table>
			</div>
		</div>
	</div>
</form>

<div class="push"></div>
</div>
<!-- contents finish -->

<!-- footer start -->
<c:import url="../WEB-INF/view/temp/footer.jsp"></c:import>
<!-- footer finish -->
</body>
</html>