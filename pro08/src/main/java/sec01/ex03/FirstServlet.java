package sec01.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 다른 서블릿 서버 페이지를 재요청하는 메소드
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<script type='text/javascript'>");
		
		out.print("window.alert('회원 가입 성공!');");
		
		out.print("window.alert('메인 화면으로 이동!');");
		
		out.print("location.href='second';");
		
		out.print("</script>");
		
		
	}
}
