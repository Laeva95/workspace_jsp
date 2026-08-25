package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// URL: 클라이언트가 서블릿을 요청하는 전체 주소 경로
// 요청하는 전체 URL		-> http://localhost:8181/pro10/첫번째매핑주소/두번째매핑주소
// 실제 요청하는 전체 URL 	-> http://localhost:8181/pro10/first/test
// 컨텍스트 주소: 클라이언트의 요청하는 전체 URL을 받았을 때 톰캣 서버가 pro10 프로젝트에 접근할 수 있는 주소 경로
//						-> /pro10
// @WebServlet("/첫번째매핑주소/두번째매핑주소")
//						-> 정확히 일치하는 요청 URL을 입력하여 실행

// *.do
//		-> .do 로 끝나는 모든 주소에 대해서 매핑
@WebServlet("*.do")
public class TestServlet3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		// 실제 요청하는 URL	-> http://localhost:8181/pro10/first/test
		// 위 요청한 전체 URL 주소 중에서 컨텍스트 주소 /pro10 을 문자열 형태로 얻기
		String contextPath = request.getContextPath();
		System.out.println("컨텍스트 주소: " + contextPath);				// 컨텍스트 주소: /pro10
		
		String url = request.getRequestURL().toString();				
		System.out.println("URL 주소: " + url);							// URL 주소: http://localhost:8181/pro10/first/test
		
		String servletPath = request.getServletPath();
		System.out.println("서블릿 매핑 주소: " + servletPath);				// 서블릿 매핑 주소: /first/test
		
		String uri = request.getRequestURI();
		System.out.println("URI 주소: " + uri);							// URI 주소: /pro10/first/test
		
		out.print("서블릿 3");
	}
}
