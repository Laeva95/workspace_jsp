<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% request.setCharacterEncoding("utf-8"); %>
<fmt:setLocale value="ko_KR"/>

<%-- 
	<fmt:setLocale>
		국가별 통화 기호나 날짜를 표현할 때 사용하는 태그
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>로케일 설정</h4>
	<c:set var="today" value="<%= new Date() %>" />
	
	한글로 설정: <fmt:setLocale value="ko_kr"/>
	<fmt:formatNumber value="10000" type="currency" />
	<fmt:formatDate value="${ today }"/><br>
	
	일어로 설정: <fmt:setLocale value="ja_jp"/>
	<fmt:formatNumber value="10000" type="currency" />
	<fmt:formatDate value="${ today }"/><br>
	
	영어로 설정: <fmt:setLocale value="en_us"/>
	<fmt:formatNumber value="10000" type="currency" />
	<fmt:formatDate value="${ today }"/><br>
	
	
	
</body>
</html>