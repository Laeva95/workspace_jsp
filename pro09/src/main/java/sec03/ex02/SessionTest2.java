package sec03.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess2")
public class SessionTest2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		// 세션 객체 메모리 생성
		HttpSession session = request.getSession();
		
		// 세션 메모리를 식별 할 수 있는 ID 값 얻기
		out.print("클라이언트의 새 요청에 의해 새로 생성되어 얻은 HttpSession 객체 메모리의 ID: " + session.getId() + "<br>");
		
		out.print("HttpSession 메모리가 생성된 시각: " + new Date(session.getCreationTime()).toString() + "<br>");
		
		out.print("HttpSession 메모리에 접근한 시각: " + new Date(session.getLastAccessedTime()).toString() + "<br>");
		
		// HttpSession 객체 메모리가 TomCat 서버 메모리에 올라가 유지되는 유효시간 설정
		session.setMaxInactiveInterval(10);
		
		// 생성되어 얻은 HttpSession 객체 메모리의 유효 시간
		out.print("HttpSession 메모리가 톰캣 서버 메모리에 올라가 유지되는 시간: " + session.getMaxInactiveInterval() + "<br>");
		
		if(session.isNew()) {
			out.print("처음 생성되어 얻어진 HttpSession 객체 메모리<br>");
		}
		
		
		
	}

}
