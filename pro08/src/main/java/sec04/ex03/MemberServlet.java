package sec04.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// MemberSerblet 첫번째 서블릿 클래스 역할
// 	- 모든 회원 정보를 조회 요청 받아서 List 배열에 담아 저장한 정보를 두번째 서블릿으로 공유
//    ViewServlet 에서 조회한 정보 출력

// 사장 클래스
@WebServlet("/member4")
public class MemberServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 깨짐 방지를 위한 문자 처리
		request.setCharacterEncoding("UTF-8");
		
		// DB 작업을 위한 DAO 객체 생성	
		MemberDAO dao = new MemberDAO();
		
		// listMembers(): 검색한 회원 정보를 MemberVO 객체에 저장해서 list로 반환하는 메서드
		List list = dao.listMembers();
		
		// 회원 정보를 request 객체에 저장
		request.setAttribute("membersList", list);
		
		// dispatch 방식을 이용해서 view 서블릿 페이지 요청
		request.getRequestDispatcher("viewMembers").forward(request, response);
		
		
	}
}
