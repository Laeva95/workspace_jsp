<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
</head>
<body>
	<%--
		<jsp:forward/> 액션 태그를 사용한 디스패처 방법 포워딩
		
		순서 1. 클라이언트가 브라우저 주소창에 요청할 URL을 입력하여 Tomcat에 요청
		
		순서 2. 요청받은 Tomcat이 login.jsp 찾아서 실행하여 브라우저에 응담
		
		순서 3. 로그인 요청 할 수 있는 디자인 코드 작성
	 --%>
	 <%
	 	request.setCharacterEncoding("utf-8");
	 %>
	 <h1>아이디를 입력하지 않았습니다. 아이디를 입력해주세요.</h1>
	 <form action="result.jsp" method="post">
	 	아이디: <input name="userID"><br>
	 	비밀번호: <input type="password" name="userPW"><br>
	 	<input type="submit" value="로그인">
	 	<input type="reset" value="취소">
	 </form>
</body>
</html>