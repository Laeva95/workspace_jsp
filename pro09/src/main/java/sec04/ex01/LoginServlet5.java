package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet {

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		// 클라이언트가 로그인 요청시 입력한 아이디, 비밀번호를 MemberVO 객체 변수에 저장
		MemberVO memberVO = new MemberVO();
		memberVO.setId(user_id);
		memberVO.setPwd(user_pw);
		
		// 클라이언트가 로그인 요청시 입력한 아이디, 비밀번호가 데이터베이스에 저장되어 있는지 확인을 위해 MemberDAO 객체 생성해서 메소드 호출
		MemberDAO memberDAO = new MemberDAO();
		
		boolean result = memberDAO.isExisted(memberVO);
		
		// 로그인 요청시 입력한 아이디, 비밀번호가 데이터베이스의 t_member 테이블에서 조회된다면
		// HttpSession 메모리를 생성해서 로그인 처리 인증 값, 입력한 아이디, 비밀번호를 바인딩
		if(result) {
			HttpSession session = request.getSession();
			
			session.setAttribute("isLogin", true);
			session.setAttribute("login.id", user_id);
			session.setAttribute("login.pw", user_pw);
			
			// 브라우저에 로그인된 사용자 화면 출면
			out.print("<html><body>");
				out.print(user_id + "님 로그인 중입니다... 환영합니다!");
				out.print("<a href='show'>회원정보 조회</a>");
			out.print("</body></html>");
		}else {
			// 클라이언트가 로그인 요청시 입력한 값이 데이터베이스의 t_member 테이블에서 조회되지 않으면
			// 비 로그인 화면으로 응답하고, 다시 로그인으로 유도하기 위한 화면 출력
			out.print("<html><body>");
				out.print("<center>회원 아이디 또는 비밀번호가 틀립니다. 다시 확인해주세요.</center>");
				out.print("<a href='login5.html'>로그인 화면으로 이동</a>");
			out.print("</body></html>");
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

}
