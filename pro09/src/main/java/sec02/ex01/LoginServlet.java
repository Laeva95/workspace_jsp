package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login3")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		if("admin".equals(user_id) && "1234".equals(user_pw)) {
			// 로그인에 성공 할 경우 사용자 아이디를 기억할 쿠키 객체 생성
			Cookie userCookie = new Cookie("user_id", user_id);
			
			// 7일간 유지되도록 설정
			userCookie.setMaxAge(60 * 60 * 24 * 7);
			
			// "/": http://localhost:8181/pro09/ 까지의 주소를 의미. 즉 사이트 전체
			userCookie.setPath("/");
			
			// 쿠키 객체의 정보를 자바 스크립트를 통해 읽을 수 없도록 설정
			userCookie.setHttpOnly(true);
			
			// response 객체에 생성한 쿠키 추가
			response.addCookie(userCookie);
			
			// 로그인 성공 처리 후 WelcomeServlet 페이지로 포워딩
			// response.sendRedirect("welcome");
			request.getRequestDispatcher("welcome").forward(request, response);
			
			
		}else {
			// 입력한 id, pw가 데이터베이스와 일치 하지 않을 때
			// 로그인 실패 처리 후 재시도 알림
			out.print("로그인 실패. 잘못된 아이디 또는 비밀번호입니다.");
			
		}
		
	}
}
