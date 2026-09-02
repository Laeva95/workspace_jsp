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

<table width="100%" align="center">
  <tr align="center" bgcolor="pink">
  	<td width="7%">아이디</td>
  	<td width="7%">비밀번호</td>
  	<td width="7%">이름</td>
  	<td width="7%">이메일</td>
  </tr>
  <tr align="center">
	<td>${ vo.id }</td>
	<td>${ vo.pwd }</td>
	<td>${ vo.name }</td>
	<td>${ vo.email }</td>
  </tr>
    <tr align="center">
	<td><%= vo.getId() %></td>
	<td><%= vo.getpwd() %></td>
	<td><%= vo.getname() %></td>
	<td><%= vo.getemail() %></td>
  </tr>
    <tr height="1" bgcolor="pink">
  	<td colspan ="5"></td>
  </tr>
</table>