<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
	<table align="center" border="1">
		<tr	align="center" bgcolor="lightgreen">
			<td width="7%"><b>아이디</b></td>
			<td width="7%"><b>비밀번호</b></td>
			<td width="7%"><b>이름</b></td>
			<td width="7%"><b>이메일</b></td>
			<td width="7%"><b>가입일</b></td>
		</tr>
		<c:choose>
			<%-- 조건 1. list 가 비어있을 경우 --%>
			<c:when test="${ list eq null }">
				<tr>
					<td colspan="5">
						<b>등록된 회원이 없습니다.</b>
					</td>
				</tr>
			</c:when>
			<%-- 조건 2. list 가 비어있지 않을 경우 --%>
			<c:when test="${ list ne null }">
				<%-- membersList 의 모든 요소를 순회 --%>
				<c:forEach var="mem" items="${ list }">
					<%-- list 의 각 요소가 가진 정보 출력 --%>
					<tr align="center">
						<td>${ mem.id }</td>
						<td>${ mem.pwd }</td>
						<td>${ mem.name }</td>
						<td>${ mem.email }</td>
						<td>${ mem.joinDate }</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
</body>
</html>