<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");

	session.setAttribute("address", "수원시 팔달구");
%>

<table width="100%" align="center">
	<tr align="center" bgcolor="pink">
		<td width="7%">아이디</td>
		<td width="7%">비밀번호</td>
		<td width="7%">이름</td>
		<td width="7%">주소1</td>
		<td width="7%">주소2</td>
	</tr>
	<%-- 디스패처 방식으로 포워딩 -> request, response 객체를 공유받아 사용 할 수 있음 --%>
	<tr align="center">
		<td width="7%">${ id }</td>
		<td width="7%">${ pwd }</td>
		<td width="7%">${ name }</td>
		<td width="7%">${ address }</td>     <!-- session 이 아닌 request 의 address 값이 반환 -->
		<td width="7%">${ sessionScope.address }</td> 
	</tr>
</table>