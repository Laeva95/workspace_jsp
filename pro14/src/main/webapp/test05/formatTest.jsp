<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:setLocale value="ko_KR"/>
	<h2>fmt의 formatNumber 태그를 이용한 숫자 포맷팅 예제</h2>
	
	<c:set var="price" value="100000000" />
	
	<%-- groupingUsed: 숫자를 3자리 단위로 ',' 기호를 사용해서 표시 --%>
	<fmt:formatNumber value="${ price }" type="number" var="priceNumber" groupingUsed="true" /> <br>
	일반 숫자형태로 표시 : ${ priceNumber } <br>
	
	통화 기호 표시 : 
	<fmt:formatNumber value="${ price }" type="currency" groupingUsed="true"/> <br>
	
	통화 기호 표시 :
	<fmt:formatNumber value="${ price }" type="currency" currencySymbol="$" groupingUsed="true"/> <br>
	
	퍼센트로 표시 : 
	<fmt:formatNumber value="${ price }" type="percent" groupingUsed="true"/> <br>
	
</body>
</html>