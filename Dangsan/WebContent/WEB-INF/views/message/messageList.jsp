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
<!-- (noread)pd(list,pagenavi) -->
<!-- 안읽은 받은 메세지 list -->
<%@include file="/WEB-INF/views/common/header.jsp"%>
<br><br>
<div class="msg-list-wrapper">
	<div class="msg-list-head">
		<span>쪽지 목록</span>
	</div>
	<div class="msg-list-content">
	
		<!-- 이곳에 메세지가 들어옵니다 -->
		${pd.list[0].msgContent }
		</div>
	<div class='msg-list-footer'>
		<!-- 페이지네비가 들어갈 부분 -->
		<span>${pd.pageNavi }</span>
	</div>
</div>

<a href="/messageView">쪽지보기</a>
]<a href="/views/message/messageInsert.jsp">쪽지쓰기</a>
</body>
<script>
	
</script>
</html>