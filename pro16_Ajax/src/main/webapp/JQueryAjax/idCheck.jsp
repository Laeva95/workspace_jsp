<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	// 요청 화면에서 입력한 id 값 얻기
	String id = request.getParameter("id");
	
	// 입력한 id 값이 중복인지 확인
	boolean exist = "admin".equals(id) || "text".equals(id) || "hong".equals(id);
	
	// 톰캣서버가 일하는 시간을 확인하기 위해 의도적 지연
	Thread.sleep(1000);
	
	// 아래에 HTML 태그 없이 JSONObject 형태의 문자열 한 줄 응답
%>
{"id":"<%= id %>","exist":<%= exist %>}