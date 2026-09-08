<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#chatWindow{
        width: 270px;				/* 대화창 너비 설정 */
        height: 310px;				/* 대화창 높이 설정 */
        border: 1px solid black;	/* 대화창 테두리 설정 */
        overflow: scroll;			/* 대화창 넘칠 때 스크롤 표시 */ 
        padding: 5px;				/* 대화창 안쪽 여백 설정 */
	}
	#chatMessage { 
	    width: 236px;               /* 메시지 입력창 너비 설정 */
	    height: 30px;               /* 메시지 입력창 높이 설정 */
	}
	#sendBtn { 
	    height: 30px;               /* 전송 버튼 높이 설정 */
	    position: relative;         /* 전송 버튼 위치 조정을 위해 relative 포지션 설정 */
	    top: 2px;                   /* 버튼을 약간 아래로 이동 */
	    left: -2px;                 /* 버튼을 약간 왼쪽으로 이동 */
	}
	#closeBtn { 
	    margin-bottom: 3px;         /* 종료 버튼의 하단 여백 설정 */
	    position: relative;         /* 종료 버튼 위치 조정을 위해 relative 포지션 설정 */
	    top: 2px;                   /* 종료 버튼을 약간 아래로 이동 */
	    left: -2px;                 /* 종료 버튼을 약간 왼쪽으로 이동 */
	}
	#chatId { 
	    width: 158px;               /* 대화명 입력창 너비 설정 */
	    height: 24px;               /* 대화명 입력창 높이 설정 */
	    border: 1px solid #AAAAAA;  /* 대화명 입력창 테두리 설정 */
	    background-color: #EEEEEE;  /* 대화명 입력창 배경색 설정 */
	}
	.myMsg { 
	    text-align: right;          /* 내 메시지를 오른쪽 정렬로 설정 */
	}
</style>
<script type="text/javascript">
	/*
		WebSocket 객체 생성
		- new WebSocket(요청주소); 를 통해 웹 소켓 객체를 생성하면 지정된 요청 주소의 서버 페이지로
		    즉시 연결 요청을 시도함
		- 이 연결은 서버 페이지와 양방향 통신 채널을 형성함
	*/
	
	// 웹 소켓 객체 생성
	let webSocket = new WebSocket("<%= application.getInitParameter("CHAT_ADDR") %>/ChatingServer");
		
	// 웹 소켓 채팅에 사용할 HTML 요소들을 저장할 변수 선언
	let chatWindow, chatMessage, chatId;
	
	window.onload = function(){
		// 대화 내용이 표시될 영역
		chatWindow = document.getElementById("chatWindow");
		
		// 클라이언트가 입력한 메세지
		chatMessage = document.getElementById("chatMessage");
		
		// 클라이언트 id
		chatId = document.getElementById("chatId").value;
	};
	
	// 클라이언트가 엔터키를 누르거나 전송 버튼을 클릭했을 때 호출되는 메소드
	function sendMessage(){
		// 기존 채팅 내역에 누적해서 메세지 추가
		chatWindow.innerHTML += "<div class='myMsg'>" + chatMessage.value + "</div>";
		
		// 웹 소켓 서버를 통해 메세지를 서버 페이지로 전송
		// 대화명 | 메세지로 구분하여 전송
		webSocket.send(chatId + "|" + chatMessage.value);
		
		chatMessage.value = "";
		
		// 대화창 스크롤 막대바를 가장 아래로 강제 이동
		chatWindow.scrollTop = chatWindow.scrollHeight;
	}
	
	// 서버 페이지와 웹 소켓 통로를 종료하는 함수
	function disconnect(){
		webSocket.close();
	}
	
	// 메세지 입력창에서 엔터키를 눌렀을 때 sendMessage() 함수를 호출하는 함수
	function enterKey(){
		if(window.event.keyCode == 13){
			sendMessage();
		}
	}
	// =================================================================
		
	// WebSocket 객체 통로에 여러 이벤트가 발생했을 때 자동으로 처리하는 이벤트 핸들러
	// 서버 페이지에서 웹소켓 통로 연결이 성공적으로 이루어진 이벤트가 발생했을 때 호출되는 이벤트 처리 함수
	webSocket.onopen = function(event){
		// 대화창에 연결 성공 메세지를 보여주기 위해 출력
		chatWindow.innerHTML += "웹소켓 통로를 통한 서버 페이지에 연결되었습니다.<br>";
	};
	// 서버 페이지에서 웹소켓 통로 연결이 종료되었을 때 호출되는 이벤트 처리 함수
	webSocket.onclose = function(event){
		// 대화창에 연결 실패 메세지를 보여주기 위해 출력
		chatWindow.innerHTML += "웹소켓 통로를 통한 서버 페이지 연결이 종료되었습니다.<br>";
	};
	// 서버 페이지에서 통신 중 에러가 발생했을 때 호출되는 이벤트 처리 함수
	webSocket.onerror = function(event){
		// 오류 발생 메세지 알람
		alert(event.data);
		
		chatWindow.innerHTML += "채팅 중 오류가 발생했습니다.<br>";
	};
	// 서버 페이지에서 웹소켓 통로를 통해 클라이언트가 보낸 메세지를 전달 받았을 때 호출되는 이벤트 처리 함수
	webSocket.onmessage = function(event){
		// 전달받은 메세지를 대화명, 메세지로 분리
		let message = event.data.split("|");
		
		// 대화명 저장
		let sender = message[0];
		
		// 메세지 저장
		let content = message[1];
		
		// 수신된 메세지가 있다면
		if(content != ""){
			// 수신된 메세지가 1:1 귓속말인지 확인
			if(content.match("/")){
				// 귓속말 대상자인지 확인
				if(content.match("/" + chatId)){
					let temp = content.replace(("/" + chatId), "[귓속말]");
					chatWindow.innerHTML += "<div>" + sender + ": " + temp + "</div>";
				}
			}else{
				chatWindow.innerHTML += "<div>" + sender + ": " + content + "</div>";
			}
		}
		
		// 스크롤 바를 가장 아래로 이동
		chatWindow.scrollTop = chatWindow.scrollHeight;
	};
	
</script>
</head>
<body>
	<!--
		현재 채팅하는 사람의 대화명을 input 태그에 표시, 읽기 전용으로 설정하여 수정 불가능
	-->
	대화명 : <input type="text" id="chatId" value="${ param.chatId }" readonly/>
	
	<!-- 
		채팅 종료 버튼 클릭 시 disconnect() 함수를 호출
	 -->
	 <button id="closeBtn" onclick="disconnect();">채팅 종료</button>
	 
	 <!--  
	 	수신된 메세지와 전송한 메세지가 표시되는 영역
	  -->
	  <div id="chatWindow">
	  	
	  </div>

	  <div>	  
		<!-- 
		  메세지 입력 공간, 키보드의 KeyUp 이벤트 발생 시 enterKey() 함수 호출
		 -->
	  		<input type="text" id="chatMessage" onkeyup="enterKey();"/>
	  	<!-- 
	  		입력한 메세지 전송 버튼, 클릭시 sendMessage() 함수 호출
	  	 -->
	  	 	<button id="sendBtn" onclick="sendMessage();">전송</button>
	  </div>
</body>
</html>