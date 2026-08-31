<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%-- MemberBean vo 객체 생성 --%>
<jsp:useBean id="vo" class="sec01.ex01.MemberBean" scope="page"></jsp:useBean>

<%-- vo 객체의 name 속성 "이순신" 으로 변경 --%>
<jsp:setProperty property="name" name="vo" value="이순신"/>

<%-- ArrayList list 객체 생성 --%>
<jsp:useBean id="list" class="java.util.ArrayList" scope="page"></jsp:useBean>

empty 연산자를 이용해서 EL 태그 영역에 출력 <br>

<h2>
	<%--
		MemberBean 객체의 모든 인스턴스 변수의 값이 저장되이 있지 않는지 확인
	 --%>
	 ${ empty vo } <br>
	 ${ not empty vo } <br>
	 ${ empty list } <br>
	 ${ not empty list } <br>
	 
	 
</h2>