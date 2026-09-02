<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" import="java.util.*, sec02.ex01.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- MemberBean 클래스의 m 변수 생성 --%>
<jsp:useBean id="member" class="sec02.ex01.MemberBean"/>
<%-- m 변수의 모든 setter 메소드 호출 --%>
<jsp:setProperty property="*" name="member"/>

<%-- MemberDAO 클래스의 memDAO 객체 생성 --%>
<jsp:useBean id="memDAO" class="sec02.ex01.MemberDAO"/>
<c:set var="insertResult" value="${ memDAO.addMember(member) }"/>

<c:set var="list" value="${ memDAO.listMembers() }" scope="request" />

<title>Insert title here</title>
</head>
<body>
	<%-- 다시 memberList.jsp로 포워딩 --%>
	<jsp:forward page="memberList.jsp"/>
</body>
</html>