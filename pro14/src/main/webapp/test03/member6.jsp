<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- JSTL의 core 라이브러리를 사용하기 위해 외부 사이트에서 불러오는 taglib 디렉티브 태그 --%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <% 
    	request.setCharacterEncoding("utf-8");
    
    	List dataList = new ArrayList();
    	dataList.add("hello");
    	dataList.add("world");
    	dataList.add("안녕하세요");	
    	
    	pageContext.setAttribute("list", dataList);
    %>

	<%-- <c:set var="list" value="<%= dataList %>"/>    --%>
	<c:forEach var="i" begin="1" end="10" step="1" varStatus="loop">
		현재 ${ loop.count } 반복한 상태의 i 변수에 저장된 값은 ${ i }입니다.<br>
	</c:forEach>
    
    <hr>
    
    <c:forEach var="i" begin="1" end="10" step="2" varStatus="loop">
	 	현재 ${ loop.count }번 실행한 상태의 코드 -> 5 * ${ i } = ${ 5 * i }<br>
	</c:forEach>
    
    <%
    	for(int i = 1; i < 11; i += 2){
    %>
    	5 * <%= i %> = <%= 5 * i %><br>
    <% 
    	}
    %>
    
    <hr>
    
    <c:forEach var="data" items="${ list }" varStatus="loop">
    	${ loop.count }번째 반복 -> ${ data } 문자열 출력<br>
    </c:forEach>
    
    <hr>
    
    <c:set var="fruits" value="사과 파인애플 바나나 망고 귤"/>
    
    <c:forTokens var="value" items="${ fruits }" delims=" ">
    	${ value }<br>
    </c:forTokens>