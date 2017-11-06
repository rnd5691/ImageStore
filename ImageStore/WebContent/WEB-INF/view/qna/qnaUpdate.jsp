<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/header.css" rel="stylesheet">
<link href="../css/qna/qnaUpdate.css" rel="stylesheet">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<!-- header start -->
<c:import url="../WEB-INF/view/temp/header.jsp"></c:import>
<!-- header finish -->

<%-- ${login eq admin } --%>


<!-- contents start -->
<div class="body">
	<div class="allbody">
	<form name="frm" action="qnaUpdate.qna" method="post" class="frm">
	<div id="qnatitle">
	<h1>QnA</h1>&nbsp;<h4>Update</h4></div>
	<div class="blank"></div>
	<input type="hidden" id="num" name="num" value="${view.qna_seq}">
	<table class="table table-hover">
		<tr class="trtable">
			<td class="tdtable1">등록일</td>
			<td class="tdtd"><input type="text" id="date" value="${view.reg_date}" readonly="readonly"></td>
			<td class="tdtable2">처리상태</td>
			<td class="tdtd"><input type="text" id="reply_check" value="${view.reply_check}" readonly="readonly"></td>
		</tr>
		<tr class="trtable">
			<td class="tdtable1">제목</td>
			<td class="tdtd"><input type="text" id="title" name="title" value="${view.title}"></td>
			<td class="tdtable1">작성자</td>
			<%-- <c:if test="${sessionScope.member.id eq view.nickname}"> --%>
			<td class="tdtd"><input type="text" id="nickname" name="nickname" value="${view.nickname}" readonly="readonly"></td>
			<%-- </c:if> --%>
			<%-- <c:if test="${sessionScope.member.id eq view.company_name}">
			<td class="tdtd"><input type="text" id="company_name" name="company_name" value="${view.company_name}" readonly="readonly"></td>
			</c:if> --%>
		</tr>
		<tr class="trtable">
			<td class="tdtable1" id="tdtable1_1">내용</td>
			<td colspan="3" class="tdtable3">
				<textarea class="area1" rows="12" style="width:100%; border:0; resize: none"
				id="contents" name="contents">${view.contents}</textarea>
			</td>
		</tr>
		</table>
		
		<div id="blank1"></div>
		
	<button class="btn btn-default">확인</button>
	</form>
	</div>
	<div class="push"></div>
</div>
<!-- contents finish -->

<!-- footer start -->
<c:import url="../WEB-INF/view/temp/footer.jsp"></c:import>
<!-- footer finish -->
</body>
</html>