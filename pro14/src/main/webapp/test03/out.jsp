<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="안녕하세요"/><br>
	<c:out value="${ 2 * 3 }"/><br>
	<%-- 
		null 예외가 발생하지 않고 알아서 예외처리
		default: 예외가 발생했을 때 출력할 기본 내용
	--%>
	<c:out value="${ requestScope.membervo.id }" default="예외가 발생했습니다."/><br> 
	
	<hr>
	<hr>
	
	<abc>는 abc입니다. <br>
	&lt;abc>는 abc입니다. <br>
	<c:out value="<abc>는 abc입니다."/>
	
</body>
</html>