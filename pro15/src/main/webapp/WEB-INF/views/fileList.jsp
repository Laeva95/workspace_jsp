<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- JSTL 중에서 core태그들을 사용하기 위해 외부 주소로 요청 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- JSTL 중에서 functions태그들을 사용하기 위해 외부 주소로 요청 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업로드된 파일 목록을 보여주는 fileList.jsp 화면</title>
<style type="text/css">
	body  { font-family:'Malgun Gothic'; padding:24px; background:#f7f9fc; }
	h2    { color:#1d5fa8; }
	table { border-collapse:collapse; width:100%; background:#fff; margin-top:12px; }
	th,td { border:1px solid #cbd5e2; padding:9px; }
	th    { background:#e8f0fb; color:#1d5fa8; }
	a     { color:#1d5fa8; font-weight:bold; text-decoration:none; }
	.btn  { display:inline-block; background:#1d5fa8; color:#fff; padding:9px 18px;
	        border-radius:6px; text-decoration:none; }
	.none { color:#c0392b; font-weight:bold; }
</style>
</head>
<body>

	<h2>업로드된 파일 목록</h2>
	<a href="upload.do" class="btn">파일 업로드</a>
	<h3>총 ${ fn:length(list) } 건</h3>
	<table>
		<tr align="center">
			<th width="45%">원본 파일명</th>
			<th width="35%">실제 파일명</th>
			<th width="10%">다운로드 횟수</th>
			<th width="10%">다운로드</th>
		</tr>
<c:choose>
	<%-- 조회한 list가 비어있다면 --%>
	<c:when test="${ empty list }">
		<tr>
			<td colspan="4" align="center" class="none">
				업로드된 파일이 존재하지 않습니다.
			</td>
		</tr>
	</c:when>
	<%-- 조회한 list가 비어있지 않다면 --%>
	<c:otherwise>
		<c:forEach var="vo" items="${ list }">
			<tr align="center">
				<td>${ vo.fileName }</td>
				<td>${ vo.fileRealName }</td>
				<td>${ vo.downloadCount }</td>
				<td></td>
			</tr>
		</c:forEach>
	</c:otherwise>
</c:choose>
	</table>

</body>
</html>
