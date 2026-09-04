<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 1. 요청 데이터 한글 데이터 처리
	request.setCharacterEncoding("utf-8");
	
	// 2. 2.html 에서 전달한 데이터를 가져오기
	int v1 = Integer.parseInt(request.getParameter("v1"));
	int v2 = Integer.parseInt(request.getParameter("v2"));
	
	// 3. json 형식의 텍스트를 작성해서 응답
%>
{
	"v1": <%= v1 %>,
	"v2": <%= v2 %>,
	"result": <%= v1 + v2 %>
}