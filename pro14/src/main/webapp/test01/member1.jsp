<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 요청한 데이터 한글 처리
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
%>

<table width="100%" align="center">
  <tr align="center" bgcolor="pink">
  	<td width="7%">아이디</td>
  	<td width="7%">비밀번호</td>
  	<td width="7%">이름</td>
  	<td width="7%">이메일</td>
  </tr>
  <%-- 위에서 작성한 데이터를 출력 --%>
  <tr align="center">
  	<td><%= id %></td>
  	<td><%= pwd %></td>
  	<td><%= name %></td>
  	<td><%= email %></td>
  </tr>
  <tr align="center">
	<td>${ param.id }</td>
	<td>${ param.pwd }</td>
	<td>${ param.name }</td>
	<td>${ param.email }</td>
  </tr>
  <tr height="1" bgcolor="pink">
  	<td colspan ="5"></td>
  </tr>
</table>
