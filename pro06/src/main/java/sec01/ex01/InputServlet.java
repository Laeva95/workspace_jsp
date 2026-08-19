package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	InputServlet
		input.html 클라이언트 화면에서 이름, 비밀번호, 과목을 체크하여
		전송 요청 버튼을 눌었을 때 from 태그의 action="input" 태그로
		연결되어 처리
*/
@WebServlet("/input")
public class InputServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청한 데이터들을 request 객체 메모리에서 얻기 전에 인코딩 방식 UTF-8 으로 설정
		request.setCharacterEncoding("UTF-8");
		
		// 요청한 데이터 가져오기
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		// 체크박스 데이터 가져오기
		// input 태그들의 공통된 name 속성("subject")에 대해 한번에 가져오기
		String[] subjects = request.getParameterValues("subject");
		
		System.out.println("Id: " + user_id + " / pw: " + user_pw);
		System.out.print("subject: ");
		for(String s : subjects) {
			System.out.print(s + " ");
		}
		
	}
}
