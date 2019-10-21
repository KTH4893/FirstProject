<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body {
	margin-top: 100px;
	font-family: 'Trebuchet MS', serif;
	line-height: 1.6
}

.container {
	width: 500px;
	margin: 0 auto;
}

ul.tabs {
	margin: 0px;
	padding: 0px;
	list-style: none;
}

ul.tabs li {
	background: none;
	color: #222;
	display: inline-block;
	padding: 10px 15px;
	cursor: pointer;
}

ul.tabs li.current {
	background: #ededed;
	color: #222;
}

.tab-content {
	display: none;
	background: #ededed;
	padding: 15px;
}

.tab-content.current {
	display: inherit;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<!-- Tab메뉴 활용하기 -->
	<section>
	<form action="/searchProfileList" method="post">

		<div class="container">

			<ul class="tabs">
				<h1>당신의 이상형을 찾아보세요</h1>
				<li class="tab-link current" data-tab="tab-1"><span>상대방이 어떤종교이길 원하나요?</span></li>
				<li class="tab-link" data-tab="tab-2"><span>당신이 원하는 상대방의 키는?</span></li>
				<li class="tab-link" data-tab="tab-3"><span>이성이 담배를 피우시길원하십니까?</span></li>
				<li class="tab-link" data-tab="tab-4"><span>원하는 상대방의 거주지를	입력하세요(ex)서울시) 여기는 select면 더 좋을듯?</span></li>
			</ul>

			<div id="tab-1" class="tab-content current">
				<input type="button" name="religion" value="기독교" class="btn btn-outline-primary btn-lg"> 
				<input type="button" name="religion" value="불교"	class="btn btn-outline-secondary btn-lg">
				<input type="button" name="religion" value="천주교" class="btn btn-outline-success btn-lg">
				<input type="button" name="religion" value="힌두교" class="btn btn-outline-danger btn-lg"><br>
				<input type="button" name="religion" value="이슬람교" class="btn btn-outline-warning btn-lg">
				<input type="button" name="religion" value="원불교" class="btn btn-outline-info btn-lg">
				<input type="button" name="religion" value="무교" 	class="btn btn-outline-dark btn-lg">
				<input type="button" name="religion" value="사이비종교" class="btn btn-outline-light btn-lg">
			</div>
			<div id="tab-2" class="tab-content">
				<input type="button" name="height" value="~150" class="btn btn-outline-primary btn-lg">
				<input type="button" name="height" value="150~160" class="btn btn-outline-secondary btn-lg">
				<input type="button" name="height" value="160~170" class="btn btn-outline-success btn-lg"><br>
				<input type="button" name="height" value="170~180" class="btn btn-outline-danger btn-lg">
				<input type="button" name="height" value="180~" class="btn btn-outline-warning btn-lg">
			</div>
			<div id="tab-3" class="tab-content">
				<input type="button" name="smoke" value="O" class="btn btn-outline-primary btn-lg">
				<input type="button" name="smoke" value="X" class="btn btn-outline-secondary btn-lg">
				<input type="button" name="smoke" value="무관" class="btn btn-outline-success btn-lg">
			</div>
			<div id="tab-4" class="tab-content">
				<input type="text" name="city" placeholder="ex)서울시">	
			</div>
			<button class="btn btn-outline-primary btn-lg">입력</button>
		</div>

	</form>
	</section>
	
	<script>
			$(document).ready(function() {
				$('ul.tabs li').click(function() {
					var tab_id = $(this).attr('data-tab');

					$('ul.tabs li').removeClass('current');
					$('.tab-content').removeClass('current');

					$(this).addClass('current');
					$("#" + tab_id).addClass('current');
				})
			})
			
			
			
			
	</script>
	

</body>
</html>