<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업로드할 파일을 첨부하는 fileUpload.jsp 화면</title>
<style type="text/css">
	body  { font-family:'Malgun Gothic'; padding:24px; background:#f7f9fc; }
	h2    { color:#1d5fa8; }
	.box  { background:#fff; border:1px solid #cbd5e2; border-radius:8px; padding:20px; max-width:560px; }
	.row  { margin-bottom:12px; }
	label { display:inline-block; width:110px; font-weight:bold; }
	.btn  { background:#1d5fa8; color:#fff; border:none; padding:9px 18px;
	        border-radius:6px; cursor:pointer; font-size:14px; }
	.link { display:inline-block; margin-top:14px; color:#1d5fa8; font-weight:bold; }
	.tip  { color:#6b7c93; font-size:13px; margin-top:10px; }
</style>
</head>
<body>

	<h2>파일 업로드</h2>
	<div class="box">
		<form action="upload.do" method="post" enctype="multipart/form-data">
			<div class="row">
				<label>첨부파일 1</label>
				<input type="file" name="file1">
			</div>
			<div class="row">
				<label>첨부파일 2</label>
				<input type="file" name="file2">
			</div>
			<div class="row">
				<label>첨부파일 3</label>
				<input type="file" name="file3">
			</div>
			<button type="submit" class="btn">업로드</button>
		</form>
		
		<p class="tip">
			한번에 최대 10MB까지 첨부해서 업로드 할 수 있습니다.<br>
			같은 이름의 파일이 이미 업로드되어 있다면 파일명 뒤에 숫자가 추가되어 업로드됩니다.</p>
		<a class="link" href="list.do">업로드된 파일 목록</a>
	</div>

</body>
</html>
