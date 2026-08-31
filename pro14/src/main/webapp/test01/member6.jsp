<%@page import="java.util.HashMap"%>
<%@page import="sec01.ex01.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%--
	Address 객체 생성 및 변수 초기화
 --%>
<jsp:useBean id="address" class=sec01.ex02.Address scope="page"/>
<jsp:setProperty property="city" name="address" value="서울"/>
<jsp:setProperty property="zipcode" name="address" value="07654"/>
<%-- 
	id: 객체 변수명 class: 생성할 객체의 클래스 경로 scope: 접근 범위 
--%>
<jsp:useBean id="vo1" class="sec01.ex01.MemberVO" scope="page"/>

<%--
	name: 값을 설정할 객체 이름 property: 값을 설정할 객체 변수 이름(*: 모든 변수)
 --%>
<jsp:setProperty name="vo1" property="*" />

<jsp:useBean id="membersList" class="java.util.ArrayList"/>
<jsp:useBean id="membersMap" class="java.util.HashMap"/>
<%

	membersMap.put("id", "park2");
	membersMap.put("pwd", "4321");
	membersMap.put("name", "박지성");
	membersMap.put("email", "park2@test.com");

	MemberVO vo2 = new MemberVO("son", "1234", "손흥민", "son@test.com");
	membersList.add(vo1);
	membersList.add(vo2);
	
	membersMap.put("ArrayList", membersList);
%>

<table width="100%" align="center">
  <tr align="center" bgcolor="pink">
  	<td width="7%">아이디</td>
  	<td width="7%">비밀번호</td>
  	<td width="7%">이름</td>
  	<td width="7%">이메일</td>
  </tr>
   <tr align="center">
	<td>${ membersMap.id }</td>
	<td>${ membersMap.pwd }</td>
	<td>${ membersMap.name }</td>	
	<td>${ membersMap.email }</td>
  </tr>
  <tr align="center">
	<td>${ membersMap.ArrayList[0].id }</td>
	<td>${ membersMap.ArrayList[0].pwd }</td>
	<td>${ membersMap.ArrayList[0].name }</td>	
	<td>${ membersMap.ArrayList[0].email }</td>
  </tr>
  <tr align="center">
	<td>${ membersMap.ArrayList[1].id }</td>
	<td>${ membersMap.ArrayList[1].pwd }</td>
	<td>${ membersMap.ArrayList[1].name }</td>
	<td>${ membersMap.ArrayList[1].email }</td>
  </tr>
  <tr height="1" bgcolor="pink">
  	<td colspan ="4"></td>
  </tr>
</table>