<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 		prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" 		prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
	<c:set var="title1" value="hello world!" />
	
	<c:set var="title2" value="쇼핑몰 중심 JSP입니다!" />
	
	<c:set var="str1" value="중심" />
	
	<h2>여러가지 문자열 관련 처리 함수들</h2>
	
	fn:contains(title1, str1) -> ${ fn:contains(title1, str1) } <br>
	fn:contains(title2, str1) -> ${ fn:contains(title2, str1) } <br>
	
	fn:indexOf(title2, str1) -> ${ fn:indexOf(title2, str1) } <br>
	
	fn:replace(title1, " ", "/") -> ${ fn:replace(title1, " ", "/") } <br>
	
	fn:trim("   안 녕  하 세요  ") -> ${ fn:trim("   안 녕  하 세요  ") } <br>
	
	fn:substring(title1, 3, 6) -> ${ fn:substring(title1, 3, 6) } <br>
	
	fn:length(title1) -> ${ fn:length(title1) } <br>
	
</body>
</html>