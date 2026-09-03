<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- JSTL 중에서 core태그들을 사용하기 위해 외부 주소로 요청 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업로드 결과를 보여주는 uploadResult.jsp 화면</title>
<style type="text/css">
	body  { font-family:'Malgun Gothic'; padding:24px; background:#f7f9fc; }
	.box  { background:#fff; border:1px solid #cbd5e2; border-radius:8px; padding:24px; max-width:520px; }
	.ok   { color:#1e7a46; font-weight:bold; font-size:18px; }
	.fail { color:#c0392b; font-weight:bold; font-size:18px; }
	.btn  { display:inline-block; background:#1d5fa8; color:#fff; padding:9px 18px;
	        border-radius:6px; text-decoration:none; margin-top:16px; margin-right:8px; }
</style>
</head>
<body>
	<div class="box">
		<c:choose>
			<c:when test="${ successCount gt 0 }">
				<p class="ok">파일 ${ successCount }건 업로드에 성공했습니다.</p>
			</c:when>
			<c:otherwise>
				<p class="fail">업로드된 파일이 없습니다. 파일을 첨부했는지 확인해주세요.</p>
			</c:otherwise>
		</c:choose>
		<a href="list.do" class="btn">파일 목록 보기</a>
		<a href="upload.do" class="btn">업로드 요청</a>
	</div>

</body>
</html>
