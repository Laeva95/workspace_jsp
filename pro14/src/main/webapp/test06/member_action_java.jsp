<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" import="java.util.*, sec02.ex01.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% 
	// 1. 요청 데이터 한글 처리
	request.setCharacterEncoding("utf-8"); 
	
	// 2. request 객체에서 데이터를 얻어 MemberBean 객체 생성
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	MemberBean member = new MemberBean(id, pwd, name, email);
	
	// 3. MemberDAO 객체를 생성 후 addMember 메소드를 호출하여 앞에서 생성한 MemberBean 객체의 데이터를 데이터베이스에 등록
	MemberDAO memDAO = new MemberDAO();
	
	memDAO.addMember(member);
		
	// 4. MemberDAO 클래스의 listMembers 메소드를 호출하여 추가된 회원을 포함한 리스트를 반환 받아서 request 내장 객체에 등록
	List list = memDAO.listMembers();
	request.setAttribute("list", list);
	
	// 5. request 내장 객체의 디스패처 방식으로 포워딩
	request.getRequestDispatcher("memberList_java.jsp").forward(request, response);
	
	/*
		<jsp:useBean id="member" class="sec02.ex01.MemberBean"/>
		<jsp:setProperty property="*" name="member"/>
		
		<jsp:useBean id="memDAO" class="sec02.ex01.MemberDAO"/>
		<c:set var="insertResult" value="${ memDAO.addMember(member) }"/>
		
		<c:set var="list" value="${ memDAO.listMembers() }" scope="request" />
		
		<jsp:forward page="memberList.jsp"/>
	*/
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>