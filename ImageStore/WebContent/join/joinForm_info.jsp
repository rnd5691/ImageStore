<!-- 회원 가입시, 계정 선택 부분 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String kind = request.getParameter("kind");
	System.out.println(kind);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입</title>
<link href="../css/header.css" rel="stylesheet">
<link href="../css/join/joinForm_info.css" rel="stylesheet">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>   
<script type="text/javascript">
	$(function(){
		var kind = '<%=kind%>';
		$("#add").load('add/'+kind+'Add.jsp');
		
		$("#id").on({
			change:function(){
				ch=false;
			},blur:function(){
				var id = $(this).val();
				var xmlhttp;
				if(window.XMLHttpRequest){
					xmlhttp = new XMLHttpRequest();
				}else{
					xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
				}
				
				xmlhttp.onreadystatechange = function(){
					if(this.readyState==4&&this.status==200){
						alert(this.responseText.trim());
						
						if(this.responseText.trim()=='OK'){
							ch=true;
							$("#id_check").text("사용가능한 ID 입니다.");
						}else{
							ch=false;
							$("#id_check").text("중복된 ID 입니다.");
						}
					}
				}
				
				xmlhttp.open("GET", "IdCheck.jsp?id="+id);
				xmlhttp.send();
			}
			})
	});
</script>
<body>
<%@ include file="../temp/header.jsp" %>
<!-- Contents -->
<section class="body">
	<article class="contents">
		<article class="title">
			<h1>회원 가입</h1> <h5><%if(kind.equals("company")){ %>기업<%} else{%>개인<%} %> 회원 가입</h5>
		</article>
		<article class="join_info">
			<form>
				<input type="hidden" name="kind" value="company">
				<table class="table table-striped">
					<tr>
						<td><span>*</span>ID</td>
						<td>
							<input id="id"type="text" name="id" required="required">
							<div id="id_check"></div>
						</td>
					</tr>
					<tr>
						<td><span>*</span>PW</td>
						<td><input type="text" name="pw" required="required"></td>
					</tr>
					<tr>
						<td><span>*</span>PW 확인</td>
						<td><input type="text" required="required"></td>
					</tr>
					<tr>
						<td>연락처</td>
						<td><input type="text" name="phone"></td>
					</tr>
					<tr>
						<td><span>*</span>이메일</td>
						<td><input type="email" name="email" required="required"></td>
					</tr>
					<tbody id="add"></tbody>
				</table>
				<div>
					<a href="joinForm_kind.jsp" class="btn btn-default">취소</a>
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