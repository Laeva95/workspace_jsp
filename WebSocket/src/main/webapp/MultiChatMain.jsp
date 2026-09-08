<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>웹 소켓 채팅 - 대화명 입력해서 채팅창 띄우기</h2>
	대화명 : <input type="text" id="chatId"/>
	<button onclick="chatWinOpen();">채팅 참여</button>
	
	<script type="text/javascript">
		function chatWinOpen(){
			let id = document.getElementById("chatId");
			
			// input 태그에 입력한 값이 없다면 함수 중단
			if(id.value.trim() == ""){
				alert("대화명을 입력하세요.");
				id.focus.
				return;
			}
			// 입력한 대화명을 요청 데이터로 전달해서 새로운 팝업창 형식으로 열기
			window.open("ChatWindow.jsp?chatId=" + id.value, "", "width=400, height=500");
			
			// 새로운 팝업 채팅창이 열리면 입력한 대화명을 input 태그에서 제거
			id.value= "";
			
			
			
		}
	</script>
</body>
</html>