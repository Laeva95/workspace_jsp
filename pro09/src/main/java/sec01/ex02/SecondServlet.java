package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String address = request.getParameter("user_address");
		String email = request.getParameter("user_email");
		String hp = request.getParameter("user_hp");
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		if(id != null && id.length() != 0) {
				out.print("이미 로그인된 상태입니다.<br><br>");
				out.print("첫번째 서블릿 LoginServlet으로부터 <a> 태그로 인해 재요청받아 공유받은 아이디: " + id + "<br>");
				out.print("첫번째 서블릿 LoginServlet으로부터 <a> 태그로 인해 재요청받아 공유받은 비밀번호: " + pw + "<br>");
				out.print("첫번째 서블릿 LoginServlet으로부터 <a> 태그로 인해 재요청받아 공유받은 주소: " + address + "<br>");
				out.print("첫번째 서블릿 LoginServlet으로부터 <a> 태그로 인해 재요청받아 공유받은 이메일: " + email + "<br>");
				out.print("첫번째 서블릿 LoginServlet으로부터 <a> 태그로 인해 재요청받아 공유받은 전화번호: " + hp + "<br>");
		} else {
				out.print("로그인 하지 않고 두번째 서블릿 페이지를 보여주고 있습니다.<br><br>");
				out.print("다시 로그인하고 오세요.<br>");
				out.print("<a href='/pro09/login2.html'>로그인 요청 하러가기</a>");
			   
		}
		
		
	}
}
