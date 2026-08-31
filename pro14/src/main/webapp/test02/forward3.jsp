<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="sec01.ex01.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 요청 한글문자 처리
	 request.setCharacterEncoding("utf-8");
	
	// ArrayList 배열 생성
	List list = new ArrayList();
	
	// ArrayList 배열에 순서대로 MemberVO 객체 2개 생성 후 추가
	list.add(new MemberVO("lee", "1234", "이순신", "lee@test.com"));
	list.add(new MemberVO("kim", "1234", "김유신", "kim@test.com"));
	
	// forward3.jsp를 처음 요청한 클라이언트의 정보가 저장된 request 객체에 ArrayList 바인딩
	request.setAttribute("list", list);
	
	// member3.jsp 두번째 서버 페이지로 디스패처 방식으로 포워딩
	request.getRequestDispatcher("member3.jsp").forward(request, response);
%>