<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 1. 요청 데이터 한글 데이터 처리
	request.setCharacterEncoding("utf-8");
	
	// 2. 요청받은 객체에서 데이터 가져오기
	int v1 = Integer.parseInt(request.getParameter("v1"));
	int v2 = Integer.parseInt(request.getParameter("v2"));
	
	// 3. 계산 결과를 응답
	// out: 응답 내용을 브라우저로 내보내는 내장 객체
	out.print(v1 + v2);
%>