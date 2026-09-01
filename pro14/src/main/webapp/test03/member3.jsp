<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- JSTL의 core 라이브러리를 사용하기 위해 외부 사이트에서 불러오는 taglib 디렉티브 태그 --%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <% 
    	request.setCharacterEncoding("utf-8");
    %>
    <c:set var="id" value="hong" scope="page"/>
    <c:set var="pwd" value="1234" scope="page"/>
    <c:set var="name" value="${ '홍길동' }" scope="page"/>
    <c:set var="age" value="${ 22 }" scope="page"/>
    <c:set var="height" value="${ 177 }" scope="page"/>
    <%--
    	c:remove -> c:set 태그로 설정한 변수를 내장 객체 영역에서 제거 할 때 사용
     --%>
    <c:remove var="age"/>
<table width="100%" align="center">
	<tr align="center" bgcolor="pink">
		<td width="7%">아이디</td>
		<td width="7%">비밀번호</td>
		<td width="7%">이름</td>
		<td width="7%">나이</td>
		<td width="7%">신장</td>
	</tr>
	<tr align="center">
		<td width="7%">${ id }</td>
		<td width="7%">${ pwd }</td>
		<td width="7%">${ name }</td>
		<td width="7%">${ age }</td>
		<td width="7%">${ height }</td>
	</tr>
</table>