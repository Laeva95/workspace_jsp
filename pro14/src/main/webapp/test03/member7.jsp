<%@page import="java.util.ArrayList"%>
<%@page import="sec01.ex01.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- JSTL의 core 라이브러리를 사용하기 위해 외부 사이트에서 불러오는 taglib 디렉티브 태그 --%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <% 
    	request.setCharacterEncoding("utf-8");
    
    	List<MemberVO> membersList = new ArrayList<>();
    	
    	MemberVO vo1 = new MemberVO("son", "1234", "손흥민", "son@test.com");
    	MemberVO vo2 = new MemberVO("ki", "1212", "기성용", "ki@test.com");
    	MemberVO vo3 = new MemberVO("park", "4321", "박지성", "park@test.com");
    	membersList.add(vo1);
    	membersList.add(vo2);
    	membersList.add(vo3);
    	
    %>
    
    <table width="100%" align="center">
	<tr align="center" bgcolor="pink">
		<td width="7%">아이디</td>
		<td width="7%">비밀번호</td>
		<td width="7%">이름</td>
		<td width="7%">이메일</td>
	</tr>
	<%-- ArrayList를 저장할 변수 --%>
	<c:set var="list" value="<%= membersList %>" scope="page"/>
	<c:forEach var="member" items="${ list }" varStatus="loop">
		<tr align="center" bgcolor="yellow">
			<td width="7%">${ member.id }</td>
			<td width="7%">${ member.pwd }</td>
			<td width="7%">${ member.name }</td>
			<td width="7%">${ member.email }</td>
		</tr>
	</c:forEach>
	<c:forEach var="i" begin="0" end="${ list.size() - 1 }" step="1" varStatus="loop">
		<tr align="center" bgcolor="aqua">
			<td width="7%">${ list[i].id }</td>
			<td width="7%">${ list[i].pwd }</td>
			<td width="7%">${ list[i].name }</td>
			<td width="7%">${ list[i].email }</td>
		</tr>
	</c:forEach>
	<%
	for(MemberVO member : membersList){
	%>
		<tr align="center">
			<td width="7%"><%= member.getId() %></td>
			<td width="7%"><%= member.getPwd() %></td>
			<td width="7%"><%= member.getName() %></td>
			<td width="7%"><%= member.getEmail() %></td>
		</tr>
	<%
	}
	%>
</table>