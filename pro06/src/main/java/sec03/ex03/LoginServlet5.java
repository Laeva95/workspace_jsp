package sec03.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 해당 서블릿 역할: 클라이언트의 요청을 받고 브라우저로 응답할 데이터를 생성하여
//					클라이언트의 브라우저로 응답하는 서버 페이지

// form 태그의 action 속성의 값과 동일한 URL 주소를 입력해야함
// action="login5" -> @WebServlet("/login5")
@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet {
	// doGet 메소드와 doPost 메소드를 모두 오버라이딩 해서 각 메소드에서 doHandle 메소드 호출
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET 전송 요청 전달 받음. doGet() 호출");
		doHandle(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST 전송 요청 전달 받음. doPost() 호출");
		doHandle(request, response);
	}
	// doHandle 메소드에는 @Override 어노테이션을 붙이면 안됨
	// doHandle 메소드는 기존에 정의되지 않은, 직접 작성한 메소드
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 순서 1. 클라이언트가 요청한 아이디와 비밀번호를 매개변수 request 로 전달 받음
		//			요청한 데이터 중에서 한글 문자가 존재하면 글자가 깨질 수 있으므로 인코딩 방식의 값을
		// 			UTF-8 방식으로 설정해서 가져옴
		request.setCharacterEncoding("UTF-8");	// ISO-8859-1 : 유럽 문자 처리
												// EUC-KR 	  : 한글 문자 처리
												// UTF-8	  : 모든 문자 처리
		
		// 순서 2. login.html 에서 입력한 클라이언트의 로그인 요청시 전달 한 값들을 request 객체에서 가져오기
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String address = request.getParameter("user_address");
		
		System.out.println("id: " + user_id + "\npw: " + user_pw + "\naddress: " + address);
		
		// 순서 3.1 요청한 클라이언트 웹 브라우저로 응답할 데이터 종류 설정
		response.setContentType("text/html; charset=UTF-8");
		
		// 순서 3.2 getWriter 메소드를 통해 PrintWriter 객체 생성
		PrintWriter out = response.getWriter();
		
		// 순서 3.3 클라이언트로 요청받은 데이터를 이용해서 클라이언트의 브라우저로 응답할 데이터 생성
		String data = "<html>";
					data += "<body>";
						data += "클라이언트가 입력한 아이디 : " + user_id + "<br>";
						data += "클라이언트가 입력한 비밀번호 : " + user_pw + "<br>";
						data += "클라이언트가 입력한 주소: " + address + "<br>";
					data += "</body>";
				data += "</html>";
		
		// 순서 4. 요청한 클라이언트의 웹 브라우저로 데이터 출력
		out.print(data);
		
	}
}
