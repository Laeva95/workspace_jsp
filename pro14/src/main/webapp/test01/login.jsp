<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
	<form action="result.jsp" method="post">
		아이디: <input type="text" name="userID"><br>
		비밀번호: <input type="password" name="userPW"><br>
		<input type="submit" value="로그인">
		<input type="reset" value="취소">
	</form>
	
	<a href="http://localhost:8181/pro14/test01/memberForm.html">회원가입 1</a><br>
	<% String contextPath = request.getContextPath(); %>
	<a href="<%= contextPath %>/test01/memberForm.html">회원가입 2</a><br>
	<a href="${ pageContext.request.contextPath }/test01/memberForm.html">회원가입 3</a>
</body>
</html>