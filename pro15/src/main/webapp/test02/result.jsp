<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String contextPath = request.getContextPath();
	
	String file1 = URLEncoder.encode(request.getParameter("param1"));
	String file2 = URLEncoder.encode(request.getParameter("param2"));
%>

파일 내려받기 1: <a href="<%= contextPath %>/download.do?fileName=<%= file1 %>">파일 다운로드 요청1</a>
<br><br>
파일 내려받기 2: <a href="<%= contextPath %>/download.do?fileName=<%= file2 %>">파일 다운로드 요청2</a>