<%@page import="java.util.*, sec02.ex01.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<% 
// 요청한 데이터 한글 처리
request.setCharacterEncoding("utf-8"); 

// request 내장 객체에 저장된 list 값 가져오기
List<MemberBean> list = (ArrayList<MemberBean>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
	<table align="center" border="1">
		<tr	align="center" bgcolor="lightgreen">
			<td width="7%"><b>아 이 디</b></td>
			<td width="7%"><b>비밀번호</b></td>
			<td width="7%"><b>이    름</b></td>
			<td width="7%"><b>이 메 일</b></td>
			<td width="7%"><b>가 입 일</b></td>
		</tr>
		<% 
		// 가져온 list 가 null 이거나 비어있는지 확인
		if(list == null || list.isEmpty()){
		%>
			<tr>
				<td colspan="5" align="center">
					<b>등록된 회원이 없습니다.</b>
				</td>
			</tr>
		<%
		// list가 비어있거나 null 이 아니라면 반복해서 모든 요소 출력
		} else{
			for(MemberBean mem : list){

		%>
			<tr align="center" bgcolor="#99ccff">
				<td><%= mem.getId() %></td>
				<td><%= mem.getPwd() %></td>
				<td><%= mem.getName() %></td>
				<td><%= mem.getEmail() %></td>
				<td><%= mem.getJoinDate() %></td>
			</tr>
		<%
			}
		}
		%>
	</table>
</body>
</html>