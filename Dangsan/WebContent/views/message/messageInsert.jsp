<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel= "stylesheet" type="text/css" href="/css/message/messageInsert.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 쪽지 보내는 페이지 -->

<%@include file="/WEB-INF/views/common/header.jsp"%>
<br><br>
<div class="king">
	<div class="headDiv">
		<div class="head">
			<!-- 받는사람 이름 넣기 -->
			<span class="name">김뚜비</span>
			<span class="name-right">님에게 쪽지 보내기
			</span>
		</div>
	</div>
	<form action="/messageInsert">
		<!-- 히든(현재로그인한 아이디, 받는사람아이디) -->
		<input type="hidden" value="admin" name="msgFromId">
		<input type="hidden" value="test01" name="msgToId">
		<div class="msg-contentDiv">
			<textarea class="msg-textarea" cols="60" rows="8" name="msgContent" ></textarea>
		</div>
		<div class="footDiv">
			<div class="foot-left">
				<input class="msg-sub-btn msg-btn" type="submit">보내기</button>
			</div>
			<div class="foot-right">
				<button class="msg-cancel-btn msg-btn" type="button" id="canBtn">취소</button>
			</div>
		</div>
	</form>
</div>
</body>
<script>
	$("#canBtn").click(function(){
		location.href = "/messageList";
	});
</script>
</html>