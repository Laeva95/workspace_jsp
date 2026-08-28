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
		request.setCharacterEncoding("utf-8");
	
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		// out: 내장 객체의 일종으로 스크립트릿
		if(name != null || name.length() != 0){
			out.print("<h1>이름은 " + name + "</h1>");
			out.print("<h1>나이는 " + age + "</h1>");
		} else{
			
		}
	%>
</body>
</html>