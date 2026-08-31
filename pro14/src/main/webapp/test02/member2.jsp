<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<table width="100%" align="center">
	<tr align="center" bgcolor="pink">
		<td width="7%">아이디</td>
		<td width="7%">비밀번호</td>
		<td width="7%">이름</td>
		<td width="7%">이메일</td>
	</tr>
	<%-- 디스패처 방식으로 포워딩 -> request, response 객체를 공유받아 사용 할 수 있음 --%>
	<tr align="center">
		<td width="7%">${ member.id }</td>
		<td width="7%">${ member.pwd }</td>
		<td width="7%">${ member.name }</td>
		<td width="7%">${ member.email }</td>
	</tr>
</table>