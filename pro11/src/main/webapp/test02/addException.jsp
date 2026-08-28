<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"
%><%-- isErrorPage: 해당 페이지를 에러 페이지로 사용하겠음을 알리는 속성 --%>

    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>자연수 숫자만 입력 가능합니다. 다시 입력해주세요.</h3>
	<a href="add.html">돌아가기</a>
	<%-- add.jsp 페이지에서 발생한 예외 메세지를 exception 내장 객체에서 얻어 출력 --%>
	<h1><%= exception.toString() %></h1>
	<h1><%= exception.getMessage() %></h1>
	<h1><% exception.printStackTrace(); %></h1>
</body>
</html>