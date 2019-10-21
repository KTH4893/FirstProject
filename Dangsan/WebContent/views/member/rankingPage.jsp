<%@page import="com.kh.member.model.vo.MemberPage"%>
<%@page import="com.kh.member.model.vo.Profile"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<MemberPage> list = (ArrayList)request.getAttribute("list");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>랭킹페이지</title>
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
		.num{
			position: relative;
			bottom: 18px;
			
		}
		
		
	</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>

	<section>
		<h1 style="text-align:center;">랭커회원</h1>
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
						<div style="width:100%;height:70%;padding-left:10px;padding-bottom:20px;">주소 : <%=p.getCity() %></div>
					</div>
					<div style="width:50%;height:70%;float:left;padding-top:30px;" >
						<b class="num">추천수 : <%=p.getHeart() %></b>
					</div>
				</div>
			</div>
			
		</div>
		<%} %>				
	</section>
	<script>
	
	</script>
	
	
</body>
</html>