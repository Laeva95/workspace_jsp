package sec01.ex01;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	InputServlet2
		input2.html 클라이언트 화면에서 이름, 비밀번호, 과목을 체크하여
		전송 요청 버튼을 눌었을 때 from 태그의 action="input2" 태그로
		연결되어 처리
*/
@WebServlet("/input2")
public class InputServlet2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청한 데이터들을 request 객체 메모리에서 얻기 전에 인코딩 방식 UTF-8 으로 설정
		request.setCharacterEncoding("UTF-8");
		
		// 개발자가 request 객체에 담겨 있는 name 태그의 값을 기억하지 못할 때
		// 모든 input 태그의 name 속성 값들을 가져와서 Enumaration 배열로 반환
		Enumeration<String> names = request.getParameterNames();
		
		while (names.hasMoreElements()) {		// 배열에 다음 요소가 있는지 확인
			String name = names.nextElement();	// 배열의 다음 요소를 가져옴
			
			String[] values = request.getParameterValues(name);
			
			for (String value : values) {
				System.out.println("input 태그의 name: " + name + ", value: " + value);
			}
		}
	}
}
