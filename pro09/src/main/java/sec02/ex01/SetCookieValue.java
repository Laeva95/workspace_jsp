package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.javadoc.doclet.Reporter;

@WebServlet("/set")
public class SetCookieValue extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		Date date = new Date();
		Cookie cookie = new Cookie("cookieTest", URLEncoder.encode("JSP 프로그래밍", "utf-8"));
		
		cookie.setMaxAge(60 * 60 * 24);	// 24시간 유효
	
		cookie.setMaxAge(-1);			// 파일로 생성되는 것이 아니라 session 쿠키 메모리로 저장
		
		response.addCookie(cookie);
		
		out.print("현재 날짜 및 시간 정보 : " + date.toString());
		out.print("Cookie 객체를 생성해서 웹 브라우저의 쿠키 저장소 공간으로 보냈습니다.");
		
		
		
		
	}

}
