<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String name = (String)request.getAttribute("name");
	String address = (String)request.getAttribute("address");
%>
<h1>이름은 <%= name %></h1>
<h1>주소는 <%= address %></h1>