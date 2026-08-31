<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="sec01.ex01.*, java.util.*"%>
<!DOCTYPE html>
<%--
	전송된 회원 정보를 getParameter() 메소드로 가져와서 MemberBean 객체에 저장
	이후 MemberDAO 객체의 addMember() 메소드를 호출해서 회원 추가
	이후 모든 회원 조회
 --%>
 <%
 	request.setCharacterEncoding("utf-8");
 %>
 <%
 boolean isDuplicate = false;
 boolean isNull = false;
 
 // 요청의 id가 회원 목록 조회가 아니라면
 // 전달받은 데이터를 통해서 회원 추가
 if(request.getParameter("id") != null && !request.getParameter("id").equals("")){
	 if(!request.getParameter("id").equals("checkMemberList")){
%>
<jsp:useBean id="" class="w" scope="page"/>
<jsp:setProperty name="vo" property="*" />
<% 
	 } 
	 // 전달받은 id가 null이거나 비어있는지 확인
 }else{
	 isNull = true;
 }
 // 전체 회원 목록 리스트 가져오기
 %>
 
 <%-- <jsp:useBean id="생성한 객체 식별값" class="클래스 파일 저장 경로" scope="page, request, session, application 바인딩 범위 설정" /> --%>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록창</title>
<script type="text/javascript">
<%
// memberForm.html 페이지에서 전달받은 정보를 통해 데이터베이스에 회원 추가
// 중복된 id가 있는지 확인하고 성공 여부를 반환
if(isDuplicate){
%>
	window.alert("잘못된 입력입니다!");
<%
	request.getRequestDispatcher("memberForm.html").forward(request, response);
// 전달받은 id가 null이거나 비어있다면 memberForm.html 페이지 요청
} if(isNull){
%>
	window.alert("아이디를 입력해주세요!");
<%
	request.getRequestDispatcher("memberForm.html").forward(request, response);
} 
%>
</script>
</head>
<body>
	<table align="center" width="100%">
		<tr align=center bgcolor="#99ccff">
			<td width="7%">아이디</td>
			<td width="7%">비밀번호</td>
			<td width="5%">이름</td>
			<td width="11%">이메일</td>
		</tr>
		<tr align="center">
			<td width="7%"><jsp:getProperty name="vo" property="id"/></td>
			<td width="7%"><jsp:getProperty name="vo" property="pwd"/></td>
			<td width="5%"><jsp:getProperty name="vo" property="name"/></td>
			<td width="11%"><jsp:getProperty name="vo" property="email"/></td>
		</tr>
	</table>
</body>
</html>