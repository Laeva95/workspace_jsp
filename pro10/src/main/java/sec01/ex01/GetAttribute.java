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

@WebServlet("/get")
public class GetAttribute extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		ServletContext servletContext = getServletContext();
		HttpSession session = request.getSession();
		
		String ctxMesg = (String)servletContext.getAttribute("context");
		String sesMesg = (String)session.getAttribute("session");
		String reqMesg = (String)request.getAttribute("request");
		
		out.print("ServletContext 서블릿 관련 객체 메모리 영역에 바인딩 된 값: " + ctxMesg + "<br>");
		out.print("HttpSession 서블릿 관련 객체 메모리 영역에 바인딩 된 값: " + sesMesg + "<br>");
		out.print("HttpServletRequest 서블릿 관련 객체 메모리 영역에 바인딩 된 값: " + reqMesg + "<br>");
		
		
	}
	
	
}
