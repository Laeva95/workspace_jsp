<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    // include 디렉티브 태그와 액션 태그의 차이
    String outerPath1 = "./inc/OuterPage1.jsp";
	String outerPath2 = "./inc/OuterPage2.jsp";
	
	// page 영역과 request 영역에 속성 바인딩
	pageContext.setAttribute("pAttr", "동명왕");
	request.setAttribute("rAttr", "온조왕");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>include 디렉티브 태그와 액션 태그의 차이</h2>
	
	<%-- include 디렉티브 태그 사용 --%>
	<h3>include 디렉티브 태그로 외부 페이지 소스 포함 시키기</h3>
	
	<%-- 표현식을 사용하면 에러가 발생함 --%>
	<%@ include file="./inc/OuterPage1.jsp" %>
	
	<p>외부 파일에 선언한 변수 : <%= newVar1 %></p>
	
	<%-- include 액션 태그 사용 --%>
	<h3>include 액션 태그로 외부 페이지 소스 포함 시키기</h3>
	
	<%-- 표현식을 사용 할 수 있음 --%>
	<jsp:include page="<%= outerPath2 %>"></jsp:include>
	
	<p>외부 파일에 선언한 변수 : 접근 불가<%-- <%= newVar2 %> --%>
</body>
</html>