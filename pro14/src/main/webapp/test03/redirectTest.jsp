<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<c:set var="requestVar" value="홍길동" scope="request" />
<c:redirect url="/test03/otherPage.jsp">
	<c:param name="user_param1" value="출판사"/>
	<c:param name="user_param2" value="한빛출판사"/>
</c:redirect>


