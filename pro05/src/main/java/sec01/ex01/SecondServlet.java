package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
// 이 한줄이 web.xml 의 <servlet> + <servlet-mapping> 태그를 대신함
// 브라우저에서 http://localhost:8181/pro05/second 주소를 요청하면 이 클래스의 객체를 생성함
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	// 클래스 객체가 처음 톰캣 서버 메모리에 올라갈 때 1회만 호출되는 메소드
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출 >>>>");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	// 클라이언트가 GET 요청을 할 때마다 호출되는 메소드
	// request: 브라우저의 요청 정보를 담는 객체
	// response: 브라우저로 전달할 응답을 담는 객체
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메소드 호출 >>>>");
	}
	
	/**
	 * @see Servlet#destroy()
	 */
	// 톰캣 서버가 종료되거나 객체가 톰캣에서 제거될 때 1회 호출되는 메소드
	public void destroy() {
		System.out.println("destroy 메소드 호출 >>>>");
	}


}
