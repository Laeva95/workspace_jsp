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

@WebServlet("/get")
public class GetCookieValue extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		Cookie[] allValue = request.getCookies();
		
		if(allValue == null) {
			out.print("처음 접속요청. 저장된 cookie가 없습니다.");
			return;
		}
		
		for(Cookie cookie : allValue) {
			if(cookie.getName().equals("cookieTest")) {
				out.print("웹 브라우저 쿠키 저장소에서 요청 할 때 가져온 쿠키 객체 내부의 쿠키명 = cookieTest<br>");
				out.print("함께 저장된 쿠키 값 = " + URLDecoder.decode(cookie.getValue(), "utf-8"));
			}
		}
		
	}
}
