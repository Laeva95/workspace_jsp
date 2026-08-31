<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 요청 한글문자 처리
	 request.setCharacterEncoding("utf-8");
	
	request.setAttribute("id", "hong");
	request.setAttribute("pwd", "1234");
	request.setAttribute("address", "서울시 강남구");
	
	session.setAttribute("name", "홍길동");
	
	application.setAttribute("email", "hong@test.com");
	
	request.getRequestDispatcher("member4.jsp").forward(request, response);
%>