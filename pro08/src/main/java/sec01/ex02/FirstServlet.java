package sec01.ex02;

import java.io.IOException;

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
		// addHeader(): 일정 시간 이후에 Refresh 속성으로 재요청하는 메소드
		response.addHeader("Refresh", "3; url=second");
	}
}
