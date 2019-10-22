<%@page import="com.kh.member.model.vo.MemberPage"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<MemberPage> list = (ArrayList)request.getAttribute("list");
    %>
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
			border : 1px solid black;
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
			left : 20px;
		}
		
	</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>

	<section>
		<h1 style="text-align:center;">세렌디피티</h1>
			<br>
			<% for(MemberPage p : list){ %>
			<div style="width:400px;height:200px; margin:0 auto; box-sizing: border-box;" class="all">
				<div style="width:40%;height:100%; float:left;">
					<img class="img" src="/img/아이린2.jpg" style="width:90%;height:80%;">
				</div>
				<div style="width:60%;height:100%; float:left;">
					<div style="width:100%; height:50%;padding-left:10px;padding-top:15px;"><%=p.getProfile().getIntro().substring(0,44)+"..." %></div>
					<div style="width:100%; height:50%;">
						<div style="width:50%;height:100%;float:left;">
							<div style="width:100%;height:30%;padding-left:10px;padding-bottom:15px;">나이 : <%=p.getAge() %></div>
							<div style="width:100%;height:70%;padding-left:10px;padding-bottom:20px;">주소 : <%=p.getProfile().getCity() %></div>
						</div>
						<div style="width:50%;height:70%;float:left;padding-top:30px;">
							<img src="/img/빈하트.png" style="width:50px;height:50px;" id="before" onclick="img1(this);">
							<img src="/img/하트.png" style="width:50px;height:50px;display:none;" id="after" onclick="img2(this);">
						</div>
					</div>
				</div>
			</div>
			<%} %>
	</section>
	<script>
		function img1(atr) {
			var toId = list(atr).getProfile().getId();
			var fromId = sessionScope()
			$.ajax({
				url : "/ajaxBefore",
				type : "get",
				data : {toId:toId,fromId:fromId},
				success : function(data){
					$(atr).hide();
					$(atr).next().show();
				}
			})
		}
		function img2(atr) {
			var toId = list(atr).getProfile().getId();
			var fromId = sessionScope(id)
			$.ajax({
				url : "/ajaxHeart2",
				type : "get",
				data : {toId:toId,fromId:fromId},
				success : function(data){
					$(atr).hide();
					$(atr).prev().show();
				}
			})
		}
	</script>
</body>
</html>