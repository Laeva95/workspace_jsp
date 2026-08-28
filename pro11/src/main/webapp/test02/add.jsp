<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="addException.jsp"
%><%-- add.jsp 에서 에러가 발생했을 때 이동할 페이지 주소 --%>

<% 
	// add.html 페이지에서 입력한 자연수를 request 객체 메모리에서 가져오기
	int num = Integer.parseInt(request.getParameter("num"));

	// 1부터 클라이언트가 저장한 자연수까지의 합
	long sum = 0;
	
	for(int i = 1; i <= num; i++){
		sum += i;
	}
	
	out.print("1부터 " + num + "까지의 합은 " + sum + "입니다.");
%>