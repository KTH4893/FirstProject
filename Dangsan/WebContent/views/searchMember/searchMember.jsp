<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아무나 만난다</title>
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<form action="/searchMember" method="post" id="search-box">
			<h1>회원검색</h1>
			<h3>원하시는 이상형의 조건을 검색해주세요~</h3>
			<ul>
				<li><label for="addr">거주지[ex)○○시]</label></li>
				<li><input type="text" name="addr" id="addr"></li><br>
				<li><label for="height">키(cm)</label></li>
				<li><input type="text" name="height" id="height"></li><br>
				<li id="btn-wrapper">
					<br>
					<button type="submit" class="btn btn-outline-danger btn-lg">이상형찾기</button>
					<button type="reset" class="btn btn-outline-danger btn-lg">초기화</button>
					<br><br>
				</li>
			</ul>
		</form>
	</section>
	
</body>
</html>