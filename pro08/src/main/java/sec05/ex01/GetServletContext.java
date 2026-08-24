package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 클라이언트가 다른 종류의 웹 브라우저 창을 열어 주소창에 요청 URL을 입력
// GetServletContext 서블릿 클래스를 톰캣 서버에 요청
@WebServlet("/cget")
public class GetServletContext extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		ServletContext servletContext = getServletContext();
		
		List list = (ArrayList)servletContext.getAttribute("member");
		
		String name = (String)list.get(0);
		int age = (Integer)list.get(1);
		
		out.print("이름: " + name + ", 나이: " + age);
		
	}
}
