package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// login.html 에서 로그인 요청 시 form 태그에 의해 요청되는 서블릿
@WebServlet("/login")
public class LoginTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		// 실제 작업
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		out.print("<html><body>아이디는: " + user_id + "<br>비밀번호는: " + user_pw + "<br></body></html>");
		
		
		
		
	}
}
