<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	application: 	내장 객체 메모리의 일종으로 서버 전체에서 접근 가능한 ServletContext 객체
	session:		내장 객체 메모리의 일종으로 현재 세션에서 접근 가능한 HttpSession 객체
	
	내장 객체 메모리에 데이터를 바인딩하고 꺼내서 확인하기
	
	key: "name", "address"
	
--%>
<% 
	session.setAttribute("name", "이순신");
	application.setAttribute("address", "서울시 성동구");
%>
<h1>session 과 application 내장 객체 메모리 영역에 바인딩 완료</h1>
<a href="appTest02.jsp">두번째 서버페이지</a>