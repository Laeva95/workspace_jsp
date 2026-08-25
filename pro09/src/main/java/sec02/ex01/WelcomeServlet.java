package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 사용자가 로그인에 성공했는지 확인 후 출력되는 서블릿
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 데이터 한글처리
		request.setCharacterEncoding("utf-8");
		
		// 응답 데이터 한글처리
		response.setContentType("text/html; charset=utf-8");
		
		response.setCharacterEncoding("utf-8");
		
		// 요청한 브라우저와 연결된 출력 스트림 통로 생성
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		
		String user_id = null;
		
		if(cookies != null) {
			for(Cookie c : cookies) {
				// "user_id" 쿠키가 있다면 값을 저장
				if("user_id".equals(c.getName())) {
					user_id = URLDecoder.decode(c.getValue(), "utf-8");
				}
			}
		}
		
		if(user_id != null) {
			out.print("<h1>환영합니다," + user_id + "님! 로그인 중.....</h1>");
			
			out.print("<a href='logout'>로그아웃</a>");
		}else {
			request.getRequestDispatcher("login3.html").forward(request, response);
		}
		
		
	}
}
