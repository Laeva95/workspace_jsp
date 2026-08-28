<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");

	String id = (String)request.getParameter("userID");
	String pw = (String)request.getParameter("userPW");
	
	if(id == null || id.length() == 0){
%>
	<jsp:forward page="login2.jsp">
		<jsp:param value="<%= msg %>" name="msg"/>
	</jsp:forward>
<% 
	}
%>
<h1>환영합니다. 로그인 되셨습니다. <%= id %>님!!</h1>

<%!	// 선언문 -> 전역 변수
	String msg = "아이디를 입력하지 않았습니다. 아이디를 입력해주세요.";
%>