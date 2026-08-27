package member;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private MemberService memberService;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 서블릿이 처음 실행 될 때 1회만 생성
		memberService = new MemberService();
		
	}
	// 요청하는 주소를 받아 응답을 처리하는 공용 일반 메소드
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String action = request.getServletPath();
		
		if(action.endsWith("/login.do")) {
			login(request, response);
		} else if(action.endsWith("/logout.do")) {
			logout(request, response);
		} else {
			// 등록되지 않은 주소를 요청 받았을 때 메인 화면을 재요청
			//											/FunWeb/index.jsp
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
		
	}
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		MemberVO memberVO = new MemberVO(id, pass);
		
		boolean isMember = memberService.login(memberVO);
		
		if (isMember) {
			// 로그인 성공
			HttpSession session = request.getSession();
			
			session.setAttribute("userId", id);
			
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			
		} else {
			// 로그인 실패
			request.setAttribute("loginMsg", "아이디 또는 비밀번호가 틀렸습니다.");
			
			request.getRequestDispatcher("/member/login.jsp").forward(request, response);
			
		}
		
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
}
