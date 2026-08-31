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
<jsp:useBean id="address" class="sec01.ex02.Address" scope="page"/>
<jsp:setProperty property="city" name="address" value="서울"/>
<jsp:setProperty property="zipcode" name="address" value="07654"/>
<%-- 
	id: 객체 변수명 class: 생성할 객체의 클래스 경로 scope: 접근 범위 
--%>
<jsp:useBean id="vo" class="sec01.ex02.MemberVO" scope="page"/>

<%--
	name: 값을 설정할 객체 이름 property: 값을 설정할 객체 변수 이름(*: 모든 변수)
 --%>
<jsp:setProperty name="vo" property="*" />
<%--
	MemberVO의 setAddress 메소드를 호출하여 변수값 전달
 --%>
<jsp:setProperty name="vo" property="address" value="<%= address %>"/>

<table width="100%" align="center">
  <tr align="center" bgcolor="pink">
  	<td width="7%">아이디</td>
  	<td width="7%">비밀번호</td>
  	<td width="7%">이름</td>
  	<td width="7%">이메일</td>
  	<td width="7%">주거지</td>
  	<td width="7%">우편번호</td>
  </tr>
   <tr align="center">
	<td width="7%">${ vo.id }</td>
  	<td width="7%">${ vo.pwd }</td>
  	<td width="7%">${ vo.name }</td>
  	<td width="7%">${ vo.email }</td>
  	<td width="7%">${ vo.address.city }</td>
  	<td width="7%">${ vo.address.zipcode }</td>
  </tr>
  <tr height="1" bgcolor="pink">
  	<td colspan ="6"></td>
  </tr>
</table>