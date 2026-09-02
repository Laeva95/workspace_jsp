<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 		prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" 		prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.highlight {
		color: red;
		font-weight: bold;
	}
</style>
</head>
<body>
	<h2>JSP 기반 텍스트 분석기</h2>
	<%--
		클라이언트가 텍스트를 입력해서 fnTest2.jsp 서버페이지를 요청하는 폼 디자인
		URL: http://localhost:8181/pro14/test05/fnTest2.jsp
	 --%>
	 
	 <form method="post">
		<label>분석할 문장을 입력하세요</label>	 
		<%-- 클라이언트가 입력한 요청 데이터를 톰캣 서버가 실행하는 fnTest2.jsp의 request 객체에 담아 재요청 --%>
		<input type="text" name="inputTest" value="${ param.inputTest }">
		<button type="submit">분석 요청하기</button>
	 </form>
	
	<%-- 클라이언트가 입력한 데이터가 있다면 실행 --%>
	<c:if test="${ not empty param.inputTest }">
		<c:set var="text" value="${ param.inputTest }" />
		
		<%-- 검색할 키워드 목록을 , 기호로 구분한 전체 문자열을 만들어서 keywords 변수에 저장 --%>
		<c:set var="keywords" value="JSP,Java,Spring" />
		
		<h3>입력된 문장: ${ text }</h3>
		<ul>
			<li>
				<b>입력받은 전체 문자열의 총 문자 개수</b>
				${ fn:length(text) } 문자
			</li>
			<li>
				<b>입력받은 전체 문자열을 소문자로 변경</b>
				${ fn:lowercase(text) }
			</li>
		</ul>
		
	</c:if>
	
	
</body>
</html>