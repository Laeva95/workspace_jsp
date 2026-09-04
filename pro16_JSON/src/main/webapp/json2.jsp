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
		$("#checkJson").click(function(){
			let jsonStr = '{"age" : [22, 33, 44]}';
			
			console.log(typeof jsonStr);
			
			let jsonInfo = JSON.parse(jsonStr);
			
			console.log(typeof jsonInfo);
			
			// 문자열 변수를 만들어서 출력할 문자열 누적
			let output = "회원 나이<br>";
			output += "====================<br>";
			
			for(let i in jsonInfo.age){
				console.log(i);
				output += jsonInfo.age[i] + "<br>";
			}
			
			$("#output").html(output);
		});
		
	});
	
	
</script>
</head>
<body>
	<a id="checkJson" style="cursor: pointer;">출력</a><br><br>
	
	<div id="output">콘텐츠 영역
		
	</div>
</body>
</html>