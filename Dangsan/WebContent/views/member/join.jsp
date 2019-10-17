<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
	.tableClass>tr>th {
		
		color: red;
	}
</style>
</head>

<body>
	<%-- <%@ include file="/WEB-INF/views/common/header.jsp" %> --%> 

		<!-- 
		id
		pw
		name
		birth
		gender
		phone
		email
		city
		grade
		date
		photoname
		photopath  -->
	<section>	
  	<form action="/join" method="post" id="memberJoin">
          <h4>회원가입</h4>
          <form>
          	<table class="tableClass">
          		<tr>
          			<th>아이디</th>
          			<td>
          				<input type="text" name="id" id="id">
          			</td>
          		</tr>
          		<tr>
          			<th>패스워드</th>
          			<td>
          				<input type="password" name="password" id=""password"">
          			</td>
          		</tr>
          		<tr>
          			<th>이름</th>
          			<td>
          				<input type="text" name="name" id="name">
          			</td>
          		</tr>
          		<tr>
          			<th>생년월일</th>
          			<td>
          				<input type="text" name="birth" id=""birth"">
          			</td>
          		</tr>
          		<tr>
          			<th>성별</th>
          			<td>
          				남자<input type="radio" name="gender">
        				여자<input type="radio" name="gender">
          			</td>
          		</tr>
          		<tr>
          			<th>전화번호</th>
          			<td>
          				<input type="text" name="phone" id=phone>
          			</td>
          		</tr>
          		<tr>
          			<th>이메일</th>
          			<td>
          				<input type="text" name="email" id="email">
          			</td>
          		</tr>
          		<tr>
          			<th>주요 활동 지역</th>
          			<td>
          				<input type="text" name="city" id="city">
          			</td>
          		</tr>
          		<tr>
          			<th>프로필 사진</th>
          			<td>
          				<input type="file" name="filename" onchange="loadImg(this)">
       				</td> 
          		</tr>
          	</table>
          </form>
        </form>
        </section>
</body>
</html>