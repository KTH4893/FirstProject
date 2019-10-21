<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel= "stylesheet" type="text/css" href="/css/message/messageView.css">
</head>
<body>
<!-- 한사람과 주고받은 쪽지를 볼 수 있는 페이지 -->

<%@include file="/WEB-INF/views/common/header.jsp"%>

<br>
<!-- 쪽지함 -->
<div class="queen">
	<div class="head">
		<div class="headLeftLeft">
			<!-- 뒤로가기 버튼 -->
			<span>←</span>
		</div>
		<div class="headLeft">
			<div class="photo">
				<img class="photoImg" src="C:\Users\user1\Desktop\po.jpg">
			</div>
		</div>
		<div class="headCenter">
			<!-- 프로필 -->
			<span class="senderName">김뚜비</span>
			<span class="senderNameRight">님과 주고받은 쪽지</span>
		</div>
		<div class="headRight">
			<!-- 쪽지보내기 버튼 -->
			<button class="msg-send-btn" type="button">쪽지 보내기</button>
		</div>
	</div>
	<div class="listDiv">
		<table class="list-table">
			<!-- 쪽지가 들어올 부분입니다. -->
		</table>	
	</div>
</div>

<!-- 페이지네비 만들어야함 -->


</body>
</html>