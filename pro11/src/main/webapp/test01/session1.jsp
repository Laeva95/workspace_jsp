<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)session.getAttribute("name");
	session.setAttribute("address", "서울시 강남구");
%>

이름은 <%= name %>입니다. 이 이름은 SessionTest 서블릿으로부터 공유받은 HttpSession에 바인딩 된 값입니다.
<a href="session2.jsp">두번째 session2.jsp 요청하기 => HttpSession 공유 가능</a>