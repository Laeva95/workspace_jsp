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
	<%-- jsp에 표시할 언어 선택 --%>
	<fmt:setLocale value="ko_KR"/>
	<%-- <fmt:setLocale value="en_US"/> --%>
	
	<h1>
		<fmt:bundle basename="resource.member">
			이름: <fmt:message key="mem.name"/><br>
			주소: <fmt:message key="mem.address"/><br>
			직업: <fmt:message key="mem.job"/><br>
		</fmt:bundle>
	</h1>
	
</body>
</html>