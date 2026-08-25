package sec03.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login4")
public class SessionTest4 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		// 세션 객체 메모리 생성
		HttpSession session = request.getSession();
		
		// 클라이언트가 login4.html 화면에서 로그인 요청 시 입력한 아이디, 비밀번호 얻기
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		
		if(session.isNew()) {									// 세션 메모리가 최초로 생성된 것인지 확인
			if(user_id != null && !user_id.trim().isEmpty()) {	// 아이디가 null 이 아니고 공백이 아니라면
				session.setAttribute("user_id", user_id);
				out.print("<a href='login4'>로그인 상태 확인 요청</a>");
			}else {												// 아이디를 입력하지 않고 요청
				out.print("<a href='login4.html'>다시 로그인 요청화면으로 가기</a>");
				session.invalidate();
			}
		}else {													// 세션이 이미 존재하는 경우
			user_id = (String)session.getAttribute("user_id");
			if(user_id != null && user_id.length() != 0) {		// 세션의 값과 같은 경우
				out.print("안녕하세요 " + user_id + "님!!! 로그인 중.....");
			}else {												// 세션의 값과 다른 경우
				out.print("<a href='login4.html'>다시 로그인 요청화면으로 가기</a>");
				session.invalidate();
			}
		}
		
		
		
		
		
	}

}
