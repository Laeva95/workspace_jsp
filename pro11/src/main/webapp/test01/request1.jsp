<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setAttribute("name", "이순신");
	request.setAttribute("address", "서울시 강남구");
	
	// request, response 객체를 유지한 상태로 포워딩
	request.getRequestDispatcher("request2.jsp").forward(request, response);
	
	// response.sendRedirect("request2.jsp");
%>