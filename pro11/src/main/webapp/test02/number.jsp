<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 실습 1. 404 예외
		int num = Integer.parseInt(request.getParameter("num"));
	
		out.print(num);
	%>
	<h1>쇼핑몰 중심 JSP 입니다!!!!</h1>
</body>
</html>