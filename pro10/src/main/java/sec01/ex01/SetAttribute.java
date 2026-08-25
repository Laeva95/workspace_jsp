package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/set")
public class SetAttribute extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String ctxMesg = "ServletContext 객체 메모리에 바인딩 할 특정 문자열 값";
		String sesMesg = "HttpSession 객체 메모리에 바인딩 할 특정 문자열 값";
		String reqMesg = "HttpServletRequest 객체 메모리에 바인딩 할 특정 문자열 값";
		
		ServletContext servletContext = getServletContext();
		HttpSession session = request.getSession();
		
		servletContext.setAttribute("context", ctxMesg);
		session.setAttribute("session", sesMesg);
		request.setAttribute("request", reqMesg);
		
		out.print("각각의 서블릿 관련 객체 메모리 영역들에 바인딩 완료");
		
		
		
		
	}
	
	
}
