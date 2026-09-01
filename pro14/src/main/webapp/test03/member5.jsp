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
    
    
<table width="100%" align="center">
	<tr align="center" bgcolor="pink">
		<td width="7%">아이디</td>
		<td width="7%">비밀번호</td>
		<td width="7%">이름</td>
		<td width="7%">나이</td>
		<td width="7%">신장</td>
	</tr>
	<c:choose>
	<%-- page 내장객체에 name 변수가 저장되어 있는지 확인 --%>
		<c:when test="${ empty pageScope.name }">
			<tr align="center">
				<td colspan="5">
					이름이 저장되어 있지 않습니다.
				</td>
			</tr>
		</c:when>
		<c:when test="${ empty pageScope.pwd }">
			<tr align="center">
				<td colspan="5">
					비밀번호가 저장되어 있지 않습니다.
				</td>
			</tr>
		</c:when>
		<c:when test="${ empty age }">
			<tr align="center">
				<td colspan="5">
					나이가 저장되어 있지 않습니다.
				</td>
			</tr>
		</c:when>
		<c:when test="${ empty height }">
			<tr align="center">
				<td colspan="5">
					신장이 저장되어 있지 않습니다.
				</td>
			</tr>
		</c:when>
		<c:otherwise>
			<tr align="center">
				<td>${ id }</td>
				<td>${ pwd }</td>
				<td>${ name }</td>
				<td>${ age }</td>
				<td>${ height }</td>
			</tr>
		</c:otherwise>
	</c:choose>
</table>