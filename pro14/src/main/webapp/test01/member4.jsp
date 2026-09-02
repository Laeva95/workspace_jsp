<%@page import="sec01.ex01.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<%-- 
	1. 자바 빈 생성
	id: 객체 변수명 class: 생성할 객체의 클래스 경로 scope: 접근 범위 
--%>
<jsp:useBean id="vo" class="sec02.ex01.MemberVO" scope="page"/>

<%--
	2. 자바 빈 변수 설정
	name: 값을 설정할 객체 이름 property: 값을 설정할 객체 변수 이름(*: 모든 변수)
 --%>
<jsp:setProperty name="vo" property="*" />

<jsp:useBean id="membersList" class="java.util.ArrayList"/>
<%
	MemberVO vo2 = new MemberVO("son", "1234", "손흥민", "son@test.com");
	membersList.add(vo);
	membersList.add(vo2);
%>

<table width="100%" align="center">
  <tr align="center" bgcolor="pink">
  	<td width="7%">아이디</td>
  	<td width="7%">비밀번호</td>
  	<td width="7%">이름</td>
  	<td width="7%">이메일</td>
  </tr>
  <tr align="center">
	<td>${ membersList[0].id }</td>
	<td>${ membersList[0].pwd }</td>	
	<td>${ membersList[0].name }</td>	
	<td>${ membersList[0].email }</td>
  </tr>
  <tr align="center">
	<td>${ membersList[1].id }</td>
	<td>${ membersList[1].pwd }</td>	
	<td>${ membersList[1].name }</td>	
	<td>${ membersList[1].email }</td>
  </tr>
  <tr height="1" bgcolor="pink">
  	<td colspan ="5"></td>
  </tr>
</table>