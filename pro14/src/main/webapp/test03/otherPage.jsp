<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h4>/test03/otherPage.jsp</h4>
<ul>
  <li> 
  	redirectTest.jsp를 클라이언트가 최초 요청했을 때 생성된 request 객체에 저장된 값<br>
  	${ requestScope.requestVar }<br>
  </li>
  <li>
  	c:redirect 태그로 전달받은 request 객체에 저장된 값<br>
  	${ param.user_param1 }<br>
  	${ param.user_param2 }<br>
  </li>
</ul>
