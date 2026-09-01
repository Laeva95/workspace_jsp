<%@page import="sec01.ex01.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- JSTL의 core 라이브러리를 사용하기 위해 외부 사이트에서 불러오는 taglib 디렉티브 태그 --%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <% 
    	request.setCharacterEncoding("utf-8");
    %>
<jsp:useBean id="membersMap" class="java.util.HashMap" scope="page"/>
<jsp:useBean id="membersList" class="java.util.ArrayList" scope="page"/>


<%
	membersList.add(new MemberVO("ki", "1234", "기성용", "ki@test.com"));
	membersList.add(new MemberVO("son", "42321", "손흥민", "son@test.com"));
	
	membersMap.put("id", "park2");
	membersMap.put("pwd", "4321");
	membersMap.put("name", "박지성");
	membersMap.put("email", "park2@test.com");
	
	membersMap.put("list", membersList);
%>

<c:set var="membersList" value="${ pageScope.membersMap.list }"/>

<table width="100%" align="center">
	<tr align="center" bgcolor="pink">
		<td width="7%">아이디</td>
		<td width="7%">비밀번호</td>
		<td width="7%">이름</td>
		<td width="7%">이메일</td>
	</tr>
	<tr align="center">
		<td width="7%">${ membersMap.id }</td>
		<td width="7%">${ membersMap.pwd }</td>
		<td width="7%">${ membersMap.name }</td>
		<td width="7%">${ membersMap.email }</td>
	</tr>
		<tr align="center">
		<td width="7%">${ membersMap.list[0].id }</td>
		<td width="7%">${ membersMap.list[0].pwd }</td>
		<td width="7%">${ membersMap.list[0].name }</td>
		<td width="7%">${ membersMap.list[0].email }</td>
	</tr>
		<tr align="center">
		<td width="7%">${ membersMap.list[1].id }</td>
		<td width="7%">${ membersMap.list[1].pwd }</td>
		<td width="7%">${ membersMap.list[1].name }</td>
		<td width="7%">${ membersMap.list[1	].email }</td>
	</tr>
</table>