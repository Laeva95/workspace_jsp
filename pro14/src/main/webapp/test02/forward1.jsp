<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 한글 처리
	request.setCharacterEncoding("utf-8");
	
	// 2. request 객체에 값 바인딩
	request.setAttribute("id", "hong");
	request.setAttribute("pwd", "1234");
	
	// 3. session 객체에 값 바인딩
	session.setAttribute("name", "홍길동");
	
	// 4. application 객체에 값 바인딩
	application.setAttribute("email", "hong@test.com");
	
	// 5. member1.jsp 페이지로 포워딩
	request.getRequestDispatcher("member1.jsp").forward(request, response);
	// <jsp:forward page="member1.jsp"/>
%>

