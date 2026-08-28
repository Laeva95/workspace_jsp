<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	include1.jsp의 상단 영역 코드
	
	<jsp:include page="duke_image.jsp">
		<jsp:param value="duke" name="name"/>
		<jsp:param value="duke.png" name="imgName"/>
	</jsp:include>
	
	include1.jsp의 하단 영역 코드
</body>
</html>