<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel= "stylesheet" type="text/css" href="/css/message/messageList.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 쪽지기능의 메인 페이지.. 받은 메세지(내가 읽지않은) 메세지 출력  -->

<%@include file="/WEB-INF/views/common/header.jsp"%>
<br><br>
<div class="msg-list-wrapper">
	<div class="msg-list-head">
		<span>쪽지 목록</span>
	</div>
	<div class="msg-list-content">
	
		<!-- 이곳에 메세지가 들어옵니다 -->
		<!-- 임시로넣은 메세지  -->
		<div class="msg-list-one">
				<div class="king">
					<div class="profileDiv">
						<div class="profile">
							<img class="profileImg" src="C:\Users\user1\Desktop\po.jpg">
						</div>
					</div>
				<div class="conDiv">
					<div class="nameDiv">
						<span class="name">이하영</span>
						<span class="nameRight">2</span>
					</div>
					<div class="msgDiv">
						<p class="msg">안녕하세요 저는 쪽지입니다. 쪽지인데요 쪽지입니다</p>
					</div>
					<div class="dateDiv">
						<span class="date">2019.10.17 17:59</span>
					</div>
				</div>
			</div>
		</div>
		</div>
	<div class='msg-list-footer'>
		<!-- 페이지네비가 들어갈 부분 -->
		<span>1 2 3 4 5</span>
	</div>
</div>

<a href="/messageView">쪽지보기</a>
]<a href="/messageInsert">쪽지쓰기</a>
</body>
</html>