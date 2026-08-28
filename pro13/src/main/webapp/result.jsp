<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");

	String id = (String)request.getParameter("userID");
	String pw = (String)request.getParameter("userPW");
	
	if(id == null || id.length() == 0){
%>
	<jsp:forward page="login.jsp"></jsp:forward>
<% 
	}
%>
<h1>환영합니다. 로그인 되셨습니다. <%= id %>님!!</h1>