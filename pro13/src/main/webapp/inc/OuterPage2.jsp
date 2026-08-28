<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포함될 외부 JSP 파일</title>
</head>
<body>
	<h2>OuterPage2.jsp 외부 파일2</h2>
	<%
		String newVar2 = "백제 온조왕";
	%>
	<ul>
		<li>page 내장 객체 영역 속성: <%= pageContext.getAttribute("pAttr") %></li>
		<li>request 내장 객체 영역 속성: <%= request.getAttribute("rAttr") %></li>
	</ul>
</body>
</html>