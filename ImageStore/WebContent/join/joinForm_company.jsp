<!-- 회원 가입시, 계정 선택 부분 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입</title>
<link href="../css/header.css" rel="stylesheet">
<link href="../css/join/joinForm_company.css" rel="stylesheet">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>   
<body>
<%@ include file="../temp/header.jsp" %>
<!-- Contents -->
<section class="body">
	<article class="contents">
		<article class="title">
			<h1>회원 가입</h1> <h5>기업 회원 가입</h5>
		</article>
		<article class="join_info">
			<form>
				<input type="hidden" name="kind" value="company">
				<table class="table table-striped">
					<tr>
						<td><span>*</span>ID</td>
						<td><input type="text" name="id" required="required"></td>
					</tr>
					<tr>
						<td><span>*</span>PW</td>
						<td><input type="text" name="pw" required="required"></td>
					</tr>
					<tr>
						<td>담당자 연락처</td>
						<td><input type="text" name="phone"></td>
					</tr>
					<tr>
						<td><span>*</span>이메일</td>
						<td><input type="email" name="email" required="required"></td>
					</tr>
					<tr>
						<td><span>*</span>사업자등록번호</td>
						<td><input type="text" name="company_num" required="required"></td>
					</tr>
					<tr>
						<td><span>*</span>상호명</td>
						<td><input type="text" name="company_name" required="required"></td>
					</tr>
					<tr>
						<td><span>*</span>회사 연락처</td>
						<td><input type="text" name="company_phone" required="required"></td>
					</tr>
				</table>
				<div>
					<a href="../index.jsp" class="btn btn-default">취소</a>
					<button class="btn btn-default">확인</button>
				</div>
				
			</form>
		</article>
	</article>
</section>
<!-- Contents 끝 -->
<%@ include file="../temp/footer.jsp" %>
</body>
</html>