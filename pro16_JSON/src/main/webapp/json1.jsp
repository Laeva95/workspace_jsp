<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- jQuery 사용을 위한 CDN 주소 사용문법 사이트에 요청 --%>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	/*
		웹 브라우저가 json1.jsp 안에 작성된 모든 html 코드를 읽어들였을 때 실행되는 함수
	*/
	$(function(){
		// id="checkJson" 클릭 시 이벤트 처리 함수 실행
		$("#checkJson").on("click", function(){
			alert("a 클릭 했음");
			
			// jsonObject: json 파일에 저장된 객체 형태의 데이터
			// 				-> 중괄호 { } 한 쌍이 하나의 데이터
			let jsonStr = '{ "name" : [ "홍길동", "이순신", "임꺽정" ] }';
			
			// JSON.parse() 메소드
			// 문자열을 JSONObject 타입으로 변환하여 반환하는 메소드
			let jsonObject = JSON.parse(jsonStr);
			
			// JSONObject 객체에서 값 꺼내기
			let output = "회원이름<br>";
			output += "==========================<br>";
			
			// jsonObject의 name 배열에서 모든 값 꺼내서 저장
			for(let i in jsonObject.name){
				output += jsonObject.name[i] + "<br>";
			}
			
			// 저장한 값 출력
			$("#output").html(output);
		});
		
	});
	
	
</script>
</head>
<body>
	<a id="checkJson" style="cursor: pointer;">출력</a><br><br>
	
	<div id="output">
		
	</div>
</body>
</html>