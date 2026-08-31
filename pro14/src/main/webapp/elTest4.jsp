<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>el 태그 내부 논리 연산자 사용</h2>
	<!-- 
		el 태그 내부에 논리 연산자를 작성 할 수 있음
	 -->
	 ${ (10 == 10) && (20 == 20) } <br>
	 ${ (10 eq 10) and (20 eq 20) } <br><br>
	 
	 ${ (10 == 10) || (20 != 30) } <br>
	 ${ (10 eq 10) or (20 ne 30) } <br><br>
	 
	 ${ !(20 != 10) } <br>
	 ${ not(20 ne 10) } <br><br>
	
</body>
</html>