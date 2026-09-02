<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setCharacterEncoding("utf-8"); %>

<c:set var="contextPath" value="${ pageContext.request.contextPath }" />



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
		파일 업로드를 요청하는 form 태그
		서블릿에 파일 업로드를 요청
		파일 업로드시 반드시 method="post", enctype="multipart/form-data" 속성 값을 추가해야함
	 --%>
	<form action="${ contextPath }/upload.do" method="post" enctype="multipart/form-data">
		첨부파일1: <input type="file" name="file1"><br>
		첨부파일2: <input type="file" name="file2"><br>
		
		파라미터1: <input type="text" name="param1"><br>
		파라미터2: <input type="text" name="param2"><br>
		파라미터3: <input type="text" name="param3"><br>
	
		<input type="submit" value="업로드">
	</form> 
</body>
</html>