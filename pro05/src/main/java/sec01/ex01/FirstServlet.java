package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 
 	1. 실제 웹 프로그래밍에서 사용되는 사용자 정의 서블릿 FirstServlet 생성
 
 		ServletApi.jar 라이브러리에서 제공되는 HttpServlet 클래스를 상속 받아서 생성
 		
 	2. HttpServlet 클래스에서 제공하는 서블릿 생명주기 메소드
 		
 		init(), service(), doGet(), doPost(), destroy()
 
 */
public class FirstServlet extends HttpServlet{
	// init(): 서블릿 객체가 생성과 동시에 단 한번만 호출되는 메소드
	//			변수의 값을 초기화 하거나 DB와 연결, 설정 파일 로드 등 초기화에 사용하는 메소드
	@Override
	public void init() throws ServletException {
		System.out.println("init() 메소드 호출 - FirstServlet 클래스의 객체 메모리 톰캣 서버 메모리 영역에 올림");
	}
	
	// get: 주소창을 통해 요청
	// req: 클라이언트가 서버로 보낸 모든 요청 정보가 담겨있는 객체
	// resp: 서버가 클라이언트에 답장을 보내기 위해 사용하는 객체
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet() 메소드 호출 당함 - GET 요청 처리");
		
		System.out.println("요청 처리 후 destroy() 메소드가 호출되어 서블릿 종료 될 것");
		
		// 클라이언트의 웹 브라우저로 응답할 데이터 종류를 text 기반의 HTML 문서의 태그 형태로 내보내고
		// 한글 깨짐을 방지하기 위해 응답할 문자 처리 방식을 UTF-8 방식으로 설정
		resp.setContentType("text/html; charset=UTF-8");
		
		// 웹 브라우저 창과 연결된 출력 스트림 통로
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
			out.println("<body>");
				out.println("<h1>FirstServlet.class 서블릿이 응답 했음</h1>");
			out.println("</body>");
		out.println("</html>");
		
	}

	// destroy(): 서블릿 객체가 삭제되거나 서버가 종료 될 때 단 한번만 호출되는 메소드
	@Override
	public void destroy() {
		System.out.println("destroy() 메소드 호출 - 서블릿 종료");
	}
	
}
