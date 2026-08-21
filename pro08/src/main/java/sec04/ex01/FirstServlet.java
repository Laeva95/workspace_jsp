package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/first")
public class FirstServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서블릿 간 문자데이터를 공유해야 하므로 한글이 깨지지 않도록 설정
		request.setCharacterEncoding("utf-8");
		
		// setAttribute(): 키, 값을 연결해서 저장하는 메소드
		request.setAttribute("address", "서울시 성북구");
		
		// SecondServlet 요청
		response.sendRedirect("second");
		
	}
}
