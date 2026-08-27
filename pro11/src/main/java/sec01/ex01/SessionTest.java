package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess")
public class SessionTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		session.setAttribute("name", "이순신");

		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
			out.print("<body>");
				out.print("<h1>HttpSession 내장 객체 메모리에 'name' - '이순신'을 바인딩 했습니다.</h1>");
				out.print("<a href='/pro11/test01/session1.jsp'>session1.jsp 를 요청하기</a>");
			out.print("</body>");
		out.print("</html>");
		
	}
}
