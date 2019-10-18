<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<style>
		.body{
			box-sizing: border-box;
		}
		.king{
			background-color: transparent;
			width: 350px;
			height: auto;
			position: relative;
		}
		.profileDiv{
			border:0px solid blue;
			width: 70px;
			height: 100%;
			float: left;
		}
		.profile{
			border: 0px solid pink;
			width: 40px;
			height: 40px;
			border-radius: 15px;
			float: right;
			position: relative;
			top: 5px;
			
		}
		.profileImg{
			width: 40px;
			height: 40px;
			border-radius: 15px;
			margin: 0 auto;
			background-color: black;
			border: 0px solid blue;
		}
		
		.chatDiv{
			border: 0px solid blue;
			width: 270px;
			height: 100%;
			float:left;
		}
		.nameDiv{
			border: 0px solid gold;
			float:left;
			width:100%;
			height: 30%;
		}
		.name{
			font-size: 12px;
			position: relative;
			left: 12px;
		}
		.chat{
			float:left;
			width:100%;
			height: auto;
		}
		.bubbleDiv{
			float: left;
			position: relative;
			width:90%;
			padding: 0px;
			height: auto;
		}
		.bubble{
			background-color: pink;
			width: auto;
			height:auto;
			border-radius: 10px;
			position: relative;
			left: 0px;
			top: 4px;
			box-shadow: 2px 2px 2px gray;
			padding: 10px;
			font-size: 12px;
			float:left;
			margin: 0px 0px 20px 0px;	
		}
		.bubble2{
			background-color: lightblue;
			width: auto;
			height:auto;
			border-radius: 10px;
			position: relative;
			left: 0px;
			top: 4px;
			box-shadow: 2px 2px 2px gray;
			padding: 10px;
			font-size: 12px;
			float:left;
			margin: 0px 0px 20px 0px;	
		}
		.arrowDiv{
			position: relative;
			float:left;
			width: 10px;
			height: auto;
			margin: 0px;
			overflow: hidden;
		}
		.arrow1{
			content: '';
			position: relative;
    		height: 30px;
    		width: 30px;
    		border-radius: 25px;
    		background: pink;
			bottom: 5px;
    		left: 5px;
			box-shadow: 1px 1px 2px gray;
		}
		.arrow2{
			content: '';
    		position: relative;
    		height: 20px;
    		width: 20px;
    		border-radius: 25px;
			background: white;
    		bottom: 35px;
    		left: 1px;	
		}
		.arrow11{
			content: '';
			position: relative;
    		height: 30px;
    		width: 30px;
    		border-radius: 25px;
    		background: lightblue;
			bottom: 5px;
    		left: 5px;
			box-shadow: 1px 1px 2px gray;
		}
		
		
		.queen{
			width: 600px;
			height: 500px;
			
		}
		.showDiv{
			width: 100%;
			height: 85%;
			background-color: pink;
		}
		.showDivIn{
			width: 98%;
			height: 97%;
			margin: 0 auto;
			position: relative;
			top: 5px;
			background-color: white;
			border: 0px solid red;
			overflow-y: auto;
		}
		
		.chatUl{
			position: relative;
			top: 10px;
			margin: 0px;
		}
		.chatUl>li{
			list-style: none;
			position: relative;
			left: -40px;
			width: 400px;
			height: auto;
		}
		
		
		.inputDiv{
			width: 100%;
			height: 15%;
			background-color: lightpink;
		}
		.buttonLeftDiv{
			float: left;
			width: 80%;
			height: 100%;
			border: 0px solid red;
		}
		.buttonDiv{
			float: left;
			width: 19%;
			height: 100%;
			border: 0px solid red;
		}
		.submitBtn{
			background-color: lightblue;
			border-radius: 15px;
			border-style: none;
			width: 70px;
			height: 40px;
			position: relative;
			top: 18px;
			left: 25px;
		}
		.textStyle{
			width: 470px;
			height: 40px;
			overflow: scroll;
			border: 1px solid lightgrey;
			border-radius: 0px;
			position: relative;
			top: 15px;
			left: 10px;
		}
	
	</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/views/common/header.jsp"%>
<h1>오픈 채팅</h1>
<div class="queen">
	<!-- 메세지 출력 창 -->
	<div class="showDiv">
		<div class="showDivIn" id="showListDiv">
			<ul class="chatUl" id="showList">
			
			</ul>
		</div>
	</div>
	<!-- 메세지 입력창 -->
	<div class="inputDiv">
		<div class="buttonLeftDiv">
				<input class="textStyle" type="text" id="inputMessage">
		</div>
		<div class="buttonDiv">
			<button class="submitBtn" type="submit" id="sendBtn">전 송</button>
		</div>
	</div>
</div>
<br>
이름입력
<input type="text" id="inputName">
 
</body>
  <script type="text/javascript">
  	//$('#showList').scrollTop($('#showList').prop('scrollHeight'));
	


        var textarea = document.getElementById("messageWindow");
        var webSocket = new WebSocket('ws://192.168.40.16:80/'+'<%=request.getContextPath()%>/broadcasting');
        var inputMessage = document.getElementById('inputMessage');
    webSocket.onerror = function(event) {
      onError(event)
    };
    webSocket.onopen = function(event) {
      onOpen(event)
    };
    webSocket.onmessage = function(event) {
      onMessage(event)
    };
    function onMessage(event) {
    	var msg = event.data;
    	var msg = msg.split(",")
    	
    	
    	var text ="";
    	//프로필영역
    	text += "<li>"
    	text += "<div class='king'>";
    	text += "<div class='profileDiv'>";
    	text += "<div class='profile'>";
    	text += "<a href='#'>";
    	//프로필사진 넣기
    	text += "<img class='profileImg'>";
    	text += "</a></div></div>";
    	//챗영역
    	text += "<div class='chatDiv'>";
    	text += "<div class='nameDiv'>";
    	//!!! 현재 로그인한 아이디의 이름 넣기 !!!
    	text += "<span class='name'>"+msg[0]+"</span>";
    	text += "</div>";
    	text += "<div class='chat'>";
    	text += "<div class='arrowDiv'>";
    	text += "<div class='arrow1'></div>";
    	text += "<div class='arrow2'></div>";
    	text += "</div>";
    	text += "<div class='bubbleDiv'>";
    	text += "<div class='bubble'>";
    	//채팅입력한 내용
    	text += msg[1];
    	text += "</div></div></div></div></div>";
    	text += "</li>";
    	$("#showList").append(text);
    	$("#showListDiv").scrollTop($("#showListDiv")[0].scrollHeight);
    	
    	
       // textarea.value += "상대 : " + event.data + "\n";
    }
    function onOpen(event) {
       // textarea.value += "연결 성공\n";
    }
    function onError(event) {
      alert(event.data);
    }
   
    $("#sendBtn").click(function(){
    	if($("#inputMessage").val()==""){
    		alert("메세지를 입력하세요");
    		return;
    	}
    	var name = $("#inputName").val();
    	var text ="";
    	//프로필영역
    	text += "<li>"
    	text += "<div class='king'>";
    	text += "<div class='profileDiv'>";
    	text += "<div class='profile'>";
    	text += "<a href='#'>";
    	//프로필사진 넣기
    	text += "<img class='profileImg'>";
    	text += "</a></div></div>";
    	//챗영역
    	text += "<div class='chatDiv'>";
    	text += "<div class='nameDiv'>";
    	//!!! 현재 로그인한 아이디의 이름 넣기 !!!
    	text += "<span class='name'>"+name+"</span>";
    	text += "</div>";
    	text += "<div class='chat'>";
    	text += "<div class='arrowDiv'>";
    	text += "<div class='arrow11'></div>";
    	text += "<div class='arrow2'></div>";
    	text += "</div>";
    	text += "<div class='bubbleDiv'>";
    	text += "<div class='bubble2'>";
    	//채팅입력한 내용
    	text += inputMessage.value;
    	text += "</div></div></div></div></div>";
    	text += "</li>";
    	$("#showList").append(text);
    	
    
    	$("#showListDiv").scrollTop($("#showListDiv")[0].scrollHeight);

		
         webSocket.send(name+","+inputMessage.value);
         inputMessage.value = "";
    });
  </script>
</html>