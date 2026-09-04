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
			// 회원 두명의 정보를 저장
			let jsonStr = '{"members" : [{"name" : "박지성", "age" : 25, "gender" : "남자", "nickname" : "날센돌이"},'
										+  '{"name" : "손흥민", "age" : 30, "gender" : "남자", "nickname" : "탱크"}]}';
			
			let jsonInfo = JSON.parse(jsonStr);
			
			let output = "회원 정보들<br>";
			output += "=======================<br>";
			
			// jsonInfo.members[i] 의 값에 접근
			for(let i in jsonInfo.members){
				output += "이름: " + jsonInfo.members[i].name + "<br>";
				output += "나이: " + jsonInfo.members[i].age + "<br>";
				output += "성별: " + jsonInfo.members[i].gender + "<br>";
				output += "별명: " + jsonInfo.members[i].nickname + "<br><br><br>";
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