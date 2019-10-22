<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<h1>이상형 리스트!</h1>
	<button class="btn btn-outline-secondary btn-sm" onclick="location.href='/views/searchProfile/searchProfile.jsp'">다시 찾아보기</button>
	<section>
		<table class="table table-striped">
			<tr>
				<th>사진</th>
	   			<th>소개</th>
	   			<th>키</th>
	   			<th>혈액형</th>
	   			<th>직업</th>
	   			<th>취미</th>
	   			<th>추천수</th>
	   			<th>종교</th>
	   			<th>흡연</th>
	   			<th>서식지</th>
	   		</tr>
	   		<c:forEach items="${profileList }" var="profileList" varStatus="i">
	   		<tr>
	   			<td>사진사진</td>
	   			<td>${profileList.intro }</td>
	   			<td>${profileList.height }</td>
	   			<td>${profileList.blood }</td>
	   			<td>${profileList.job }</td>
	   			<td>${profileList.hobby }</td>
	   			<td>${profileList.heart }</td>
	   			<td>${profileList.religion }</td>
	   			<td>${profileList.smoke }</td>
	   			<td>${profileList.profileCity }</td>
	   		</tr>
	   		</c:forEach>
		</table>
		
		
		
		
	</section>
	
	
</body>
</html>