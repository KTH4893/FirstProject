<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String str = "안녕하세여 저는 배병축입니다. 면을 좋아하고요, 최대 7봉까지는 가능합니다. 연락주세요."; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>좋아요 누르는 페이지</title>
</head>
	<style>
		section{
			width:70%;
			margin:0 auto;
			
		}
		.all{
			float:left;
			padding-left:20px;
		}
		div{
			
			box-sizing: border-box;
		}
		.img{
			margin:0 auto;
			position: relative;
			top: 10px;
			left: 8px;
			border-bottom-left-radius: 30px;
			border-bottom-right-radius: 30px;
			border-top-left-radius: 30px;
			border-top-right-radius: 30px;
		}
		.heart{
			position: relative;
			bottom : 25px;
			right : 10px;
		}
		
	</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>

	<section>
		<h1 style="text-align:center;">세렌디피티</h1>
		<br>
		<%for(int i=1;i<13;i++){ %>
		<div style="width:400px;height:200px; margin:0 auto; box-sizing: border-box;" class="all">
			<div style="width:40%;height:100%; float:left;">
				<img class="img" src="/img/깡패.png" style="width:90%;height:80%;">
			</div>
			<div style="width:60%;height:100%; float:left;">
				<div style="width:100%; height:50%;padding-left:10px;padding-top:15px;"><%=str.substring(0,40)+"..." %></div>
				<div style="width:100%; height:50%;">
					<div style="width:60%;height:100%;float:left;">
						<div style="width:100%;height:30%;padding-left:10px;padding-bottom:15px;">나이 : 29</div>
						<div style="width:100%;height:70%;padding-left:10px;padding-bottom:20px;">주소 : 서울</div>
					</div>
					<div style="width:40%;height:70%;float:left;padding-top:30px;" >
					<img src="/img/빈하트.png" style="width:60px;height:50px;padding-left:10px;" onclick="img1(this);" class="heart">
					<img src="/img/하트.png" style="width:60px;height:50px;padding-left:10px; display:none;" onclick="img2(this);"class="heart">
					</div>
				</div>
			</div>
			
		</div>
		<%} %>				
	</section>
	<script>
		function img1(atr) {
			$(atr).hide();
			$(atr).next().show();
		}
		function img2(atr) {
			$(atr).hide();
			$(atr).prev().show();
		}
	</script>
</body>
</html>