<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--
================================================================
 [실습 5] join.jsp 를 회원가입이 되도록 고치기

 완성 목표 3가지
   1. 폼의 목적지를 컨트롤러(join.do)로 연결
   2. Submit 버튼을 실제 전송되는 버튼으로 변경
   3. 가입 실패 메시지(joinMsg)를 경고창으로 표시

 ** 주석 아래 빈 줄에 코드를 직접 작성한다. **
================================================================
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/subpage.css" rel="stylesheet" type="text/css">

<%-- [실습 5-3] 가입 실패 안내 --%>
<%-- request 에서 "joinMsg" 를 꺼내 String 변수 joinMsg 에 저장 --%>
<% 
	String joinMsg = (String)request.getAttribute("joinMsg"); 
%> 

<%-- joinMsg 가 null 이 아니면 아래 script 를 출력하는 if 문 시작 --%> 
<% 
	if(joinMsg != null)
	{ 
%> 

    <%-- alert 로 joinMsg 값을 표현식(<%= %>)으로 출력하는 script 태그 작성 --%> 
    <script>
        alert("<%= joinMsg %>");
    </script>

<%-- if 문 닫기 --%> 
<% 
	}
%>

</head>
<body>
	<div id="wrap">
		<!-- 헤더들어가는 곳 -->
		<%@ include file="../inc/top.jsp" %>
		<!-- 헤더들어가는 곳 -->

		<!-- 본문들어가는 곳 -->
		<!-- 본문메인이미지 -->
		<div id="sub_img_member"></div>
		<!-- 본문메인이미지 -->
		<!-- 왼쪽메뉴 -->
		<nav id="sub_menu">
			<ul>
				<li><a href="#">Join us</a></li>
				<li><a href="#">Privacy policy</a></li>
			</ul>
		</nav>
		<!-- 왼쪽메뉴 -->
		<!-- 본문내용 -->
		<article>
			<h1>Join Us</h1>

			<!-- [실습 5-1] form 태그의 action 을 "join.do" 로, method 를 "post" 로 작성 -->
			<form action="join.do" id="join" method="post">

				<fieldset>
					<legend>Basic Info</legend>
					<label>아이디</label> <input type="text" name="id" class="id" onkeyup="mySend();">
					<span id="result"></span><br>
					<label>비밀번호</label> <input type="password" name="pass"><br>
					<label>비밀번호 확인</label> <input type="password" name="pass2"><br>
					<label>이름</label> <input type="text" name="name"><br>
					<label>이메일</label> <input type="email" name="email"><br>
					<label>이메일 확인</label> <input type="email" name="email2"><br>
				</fieldset>
				<fieldset>
					<legend>상세정보 입력</legend>
					<label>주소</label> <input type="text" name="address"><br>
					<label>전화번호</label> <input type="text" name="phone"><br>
					<label>HP</label> <input type="text" name="mobile"><br>
				</fieldset>
				<div class="clear"></div>
				<div id="buttons">

					<!-- [실습 5-2] type 을 "button" 에서 "submit" 으로 변경 (눌러야 전송됨) -->
					<input type="submit" value="회원가입" class="submit">
					<input type="reset" value="가입취소" class="cancel">
				</div>
			</form>
		</article>
		<!-- 본문내용 -->
		<!-- 본문들어가는 곳 -->

		<div class="clear"></div>
		<!-- 푸터들어가는 곳 -->
		<%@ include file="../inc/bottom.jsp" %>
		<!-- 푸터들어가는 곳 -->
	</div>
	<%-- JQuery 문법을 사용하기 위한 CND 요청 --%>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
	// 아이디 입력 input에 아이디를 입력하면 중복 체크 요청을 Ajax 비동기 통신으로 요청
		function mySend(){
			let id = $("input[name='id']").val();	// 입력한 아이디 가져오기
			
			// 아이디를 입력하지 않았다면
			if(id == ""){
				$("#result").text("아이디 입력 필수");
				$("input[name='id']").focus();
				return;
			}
			$.ajax({
				url: "<%= request.getContextPath() %>/idCheck.do",
				type: "POST",
				data: {userid: id},
				dataType: "text",
				success: function(response){
					$("#result").text(response);
				},
				error: function(){
					alert("요청 통신 에러 발생!");
				}
			});
		}
	</script>
</body>
</html>
