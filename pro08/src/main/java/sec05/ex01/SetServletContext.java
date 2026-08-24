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

// ServletContext 서블릿 관련 객체 메모리에 바인딩 실습
// SetServletContext -> ServletContext -> GetServletContext
@WebServlet("/cset")
public class SetServletContext extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		ServletContext servletContext = getServletContext();
		
		List list = new ArrayList();
		
		list.add("이순신");
		list.add(30);
		
		servletContext.setAttribute("member", list);
		
		out.print("이순신과 30을 ArrayList에 저장 완료 및 ServletContext에 바인딩 완료");
		
	}
}
