<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style>

	* {
		box-sizing: border-box; 
	}
	
	#h4 {
		text-align: center;
		padding-top: 100px;
		margin-botton : 100px;
		color: black;
	}

	.joinForm {
		/* font-family: 'Noto Sans KR', sans-serif; */
		font-family: 'Noto Sans KR', sans-serif;
		color: #565656;
		font-size: 15px;
		width : 100%;
		margin: 0 auto;
		
	}
	.tableClass{
		margin: 0 auto;
		width: 80%;
	}
		
	.colFirst{
		text-align: center;
		background: #FBFCFD;
		border: 1px solid lightgray;
		width: 20%;
	}
	
	.colSecond{
		padding-left: 20px;
		width: 80%;
		
	}
	
	.tableClass>tbody>tr {
		height: 50px;
		border: 1px solid lightgray;
	}
	
	.information {
		margin-left : 20px;
		font-size : 13px;
		color : gray;
	}
	
	#emailBtn{
		margin-left : 20px;
		font-size : 13px;
		color : gray;
	}
	
	input::placeholder {
		color: #c4c4c4;
		font-size: 13px;
	}
	
	.inputBox{
		width: 200px;
		height: 30px;
		border: 1px solid lightgray;
		padding: 10px;
	}
	
	.divBtn{
		width: 100%;
		margin-top :50px;
		padding-left: 680px;
		/* margin : 0 auto; */ 
	}
	
	.divForm{
		border: 1px solid lightgray;
		width : 50%;
		margin: 0 auto;	
	}
	
	
	
	
	
	
</style>


</head>

<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>

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
	<div id="h4">
		<h4>회원가입</h4>
	</div>
	<div class="divForm">
		<form action="/join" method="post" id="memberJoin" class="joinForm">
		<br>
			<table class="tableClass">
				<tr>
					<td class="colFirst">아이디</td>
					<td class="colSecond">
						<input type="text" class="inputBox" name="id" id="id">
						<span class="information">5~20자의 영문 소문자, 숫자, 특수기호(_),(-)만 사용 가능</span>
						
					</td>
					
				</tr>
				<tr>
					<td class="colFirst">패스워드</td>
					<td class="colSecond">
						<input type="password" class="inputBox" name="password" id="password">
						<span class="information">영어, 숫자, 특수문자 포함 8~16자리</span>
					</td>
				</tr>
				<tr>
					<td class="colFirst">패스워드 확인</td>
					<td class="colSecond">
						<input type="password" class="inputBox" name="passwordChk" id="passwordChk">
						<span class="information">동일한 비밀번호 입력</span>
					</td>
				</tr>
				<tr>
					<td class="colFirst">이름</td>
					<td class="colSecond">
						<input type="text" class="inputBox" name="name" id="name">
					</td>
				</tr>
				<tr>
					<td class="colFirst">생년월일</td>
					<td class="colSecond">
						<input type="text" class="inputBox" name="birth" id="birth" placeholder="ex)940101">
						<span class="information">생년월일 6자리로 입력</span>
					</td>
				</tr>
				<tr>
					<td class="colFirst">성별</td>
					<td class="colSecond">남자 <input type="radio" name="gender"> 
					    여자 <input type="radio" name="gender">
					</td>
				</tr>
				<tr>
					<td class="colFirst">전화번호</td>
					<td class="colSecond">
						<input type="text" class="inputBox" name="phone" id=phone placeholder="010-1234-1234">
						<span class="information">핸드폰 번호 입력</span>
					</td>
				</tr>
				<tr>
					<td class="colFirst">이메일</td>
					<td class="colSecond">
						<input type="text" class="inputBox" name="email" id="email">
						<button type="button" class="btn btn-light btn-sm" id="emailBtn">이메일 인증</button>
					</td>
				</tr>
				<tr>
					<td class="colFirst">주요 활동 지역</td>
					<td class="colSecond">
						<input type="text" class="inputBox" name="city" id="city" placeholder="ex) 서울시, 인천시">
						<span class="information">'시'만 입력</span>
					</td>
				</tr>
				<tr>
					<td class="colFirst">프로필 사진</td>
					<td class="colSecond"><input type="file" name="filename"
						onchange="loadImg(this)">
					</td>
				</tr>
	
			</table>
				<!-- <button type="button" class="btn btn-primary">돌아가기</button>
	          	<button type="button" class="btn btn-primary">다음단계</button> -->
			<div class="divBtn">
				<button type="button" class="btn btn-outline-info">돌아가기</button>
				<button type="button" class="btn btn-outline-info">다음단계</button>
			</div>
		</form>
	</div>
	</section>
</body>
</html>