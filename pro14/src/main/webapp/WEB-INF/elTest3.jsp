<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>el 태그 내부 비교 연산자 사용</h2>
	<!-- 
		el 태그 내부에 비교 연산자를 작성 할 수 있음
	 -->
	 ${ 10 == 10 } <br>
	 ${ 10 eq 10 } <br>
	 
	 ${ "hello" != "apple" } <br>
	 ${ "hello" ne "apple" } <br>
	 
	 ${ 10 < 10 } <br>
	 ${ 10 lt 10 } <br>
	 
	 ${ 10 > 10 } <br>
	 ${ 10 gt 10 } <br>
	 
	 ${ 100 <= 10 } <br>
	 ${ 100 le 10 } <br>
	 
	 ${ 100 >= 10 } <br>
	 ${ 100 ge 10 } <br>
	
	
</body>
</html>