package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// LoginTest 서블릿 주요 역할: ID나 비밀번호를 제대로 입력하지 않으면 오류 메세지를 출력
//							이후 다시 로그인창으로 이동
@WebServlet("/loginTest2")
public class LoginTest2 extends HttpServlet{
	public void init() {
		System.out.println("init 메서드 호출");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user_pw");
		
		System.out.println("아이디 : " + id);
		System.out.println("패스워드 : " + pw);
		
		if(id != null && (id.length() != 0)) {	// id를 입력했을 경우
			
			if(id.equals("admin")) {	// 입력한 id가 admin이면 관리자 화면을 표시
				out.print("<html>");
					out.print("<body>");
						out.print("<font size='12'> 관리자로 로그인 하셨습니다!! </font>");
						out.print("<br>");
						out.print("<input type=button value='회원정보 수정하기'    />");
						out.print("<input type=button value='회원정보 삭제하기'    />");
					out.print("</body>");
				out.print("</html>");
			}else {	// 관리자가 아닌 일반 사용자일 경우 로그인 성공 메세지
				out.print("<html>");
					out.print("<body>");
					out.print(id + " 님!! 로그인 하셨습니다.");
					out.print("</body>");
				out.print("</html>");
			}
		}else {	// 입력한 ID와 비밀번호가 없으면 다시 로그인창으로 이동합니다.
			out.print("<html>");
				out.print("<body>");
					out.print("ID와 비밀번호를 입력하세요!!!");
					out.print("<br>");
					out.print("<a href='http://localhost:8181/pro06/test01/login.html'>로그인창으로 이동</a>");
				out.print("</body>");
			out.print("</html>");
		}
		
	}
	
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
	
	
}
