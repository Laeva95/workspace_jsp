<%@page import="sec01.ex01.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	MemberVO memberVO = new MemberVO("lee", "1234", "이순신", "lee@test.com");
	
	request.setAttribute("member", memberVO);
%>

<jsp:forward page="member2.jsp"/>