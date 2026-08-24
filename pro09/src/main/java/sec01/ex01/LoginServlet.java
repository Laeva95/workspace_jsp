package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String address = request.getParameter("user_address");
		String email = request.getParameter("user_email");
		String hp = request.getParameter("user_hp");
		
		String data = "안녕하세요!<br> 로그인하셨습니다.<br><br>";
			   data += "입력한 아이디: " + id + "<br>";
			   data += "입력한 비밀번호: " + pw + "<br>";
			   data += "입력한 주소: " + address + "<br>";
			   data += "입력한 이메일: " + email + "<br>";
			   data += "입력한 전화번호: " + hp + "<br>";
		
		response.setContentType("text/html; charset=utf-8");
		
		response.getWriter().print(data);
		
	}
	
}
