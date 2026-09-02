<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first.jsp 입니다.</title>
</head>
<body>
	<form action="result.jsp" method="post">
		<input type="hidden" name="param1" value="LICENSES.chromium.html">
		<input type="hidden" name="param2" value="Cursor.VisualElementsManifest.xml">
		
		<input type="submit" value="다운로드 파일명 전달">
		
	</form>
</body>
</html>