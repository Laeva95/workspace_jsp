package sec02.ex01;

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
		// 다른 서블릿 서버 페이지를 재요청하는 메소드
		RequestDispatcher dispatcher = request.getRequestDispatcher("second?name=lee");
		
		// 재요청할 서버 페이지와 같은 request, response 객체를 공유하기 위해 매개변수로 전달함
		dispatcher.forward(request, response);
	}
}
