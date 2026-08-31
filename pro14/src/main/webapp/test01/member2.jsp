<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	request.setCharacterEncoding("utf-8");
    
    %>
    
<table width="100%" align="center">
  <tr align="center" bgcolor="pink">
  	<td width="7%">아이디</td>
  	<td width="7%">비밀번호</td>
  	<td width="7%">이름</td>
  	<td width="7%">이메일</td>
  	<td width="7%">주소</td>
  </tr>
    <tr align="center">
	<td>${ param.id }</td>
	<td>${ param.pwd }</td>
	<td>${ param.name }</td>
	<td>${ param.email }</td>
	<td>${ requestScope.address }</td>
  </tr>
    <tr height="1" bgcolor="pink">
  	<td colspan ="6"></td>
  </tr>
</table>	
