package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 사장 클래스
@WebServlet("/member2")
public class MemberServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 깨짐 방지를 위한 문자 처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 브라우저와 연결된 출력 스트림 생성
		PrintWriter out = response.getWriter();
		
		// DB 작업을 위한 DAO 객체 생성
		MemberDAO dao = new MemberDAO();
		
		// listMembers(): 검색한 회원 정보를 MemberVO 객체에 저장해서 list로 반환하는 메서드
		List list = dao.listMembers();
		
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td>");
		
		for(int i = 0; i < list.size(); i++) {
			MemberVO vo = (MemberVO)list.get(i);
			out.print("<tr><td>" + vo.getId() + "</td><td>"
								+ vo.getPwd() + "</td><td>"
								+ vo.getName() + "</td><td>"
								+ vo.getEmail() + "</td><td>"
								+ vo.getJoinDate() + "</td>");
		}
		out.print("</table></body></html>");
		
	}
}
