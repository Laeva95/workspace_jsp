<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- JSTL의 core 라이브러리를 사용하기 위해 외부 사이트에서 불러오는 taglib 디렉티브 태그 --%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <% 
    	request.setCharacterEncoding("utf-8");
    %>
    
    <c:set var="id" value="hong" scope="page"/>
    <c:set var="pwd" value="1234" scope="page"/>
    <c:set var="name" value="${ '홍길동' }" scope="page"/>
    <c:set var="age" value="${ 22 }" scope="page"/>
    <c:set var="height" value="${ 177 }" scope="page"/>
    
    <%-- 키가 160 초과인지 확인 --%>
    <c:if test="${ height gt 160 }">
    	<h1>${ name }의 키는 160 보다 큽니다.</h1>
    </c:if>
    
    <%-- 나이가 22살인지 확인 --%>
    <c:if test="${ age eq 22 }" var="result" scope="page">
    	<h1>${ name }의 나이는 ${ age }살 입니다.</h1>
    	${ result }
    	<c:if test="${ result }">
    		<h1>true 확인</h1>
    	</c:if>
    </c:if>
    
    <%-- 아이디가 hong 이고, 이름이 홍길동인지 확인 --%>
    <c:if test="${ (id eq 'hong') and (name eq '홍길동') }">
    	<h1>아이디는 ${ id }이고, 이름은 ${ name }입니다.</h1>
    </c:if>
    
    <c:if test="${ true }">
    	<h1>항상 출력</h1>
    </c:if>
    
    <c:if test="${ 11 eq 11 }">
    	<h1>두 11은 같습니다.</h1>
    </c:if>
    
    <c:if test="${ 11 ne 31 }">
    	<h1>11과 31은 다릅니다.</h1>
    </c:if>