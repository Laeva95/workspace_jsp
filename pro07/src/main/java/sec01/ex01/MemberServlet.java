package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 사장 클래스
@WebServlet("/member")
public class MemberServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		// DB 작업을 위한 DAO 객체 생성
		MemberDAO dao = new MemberDAO();
		
		// listMembers(): 검색한 회원 정보를 MemberVO 객체에 저장해서 list로 반환하는 메서드
//		List list = dao.listMembers();
		
		
		
		
		
		
	}
}
