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