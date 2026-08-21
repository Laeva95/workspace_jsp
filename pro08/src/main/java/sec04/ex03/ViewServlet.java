package sec04.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ViewServlet
// - 전달 받은 회원 목록을 출력하는 서블릿 클래스
@WebServlet("/viewMembers")
public class ViewServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 깨짐 방지 설정
		request.setCharacterEncoding("utf-8");
		
		// request 객체에 저장된 회원 정보 가져오기
		List list = (List)request.getAttribute("membersList");
		
		// 출력 스트림 mime-type 설정
		response.setContentType("text/html; charset=UTF-8");
		
		// 브라우저와 연결된 출력 스트림 생성
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td><td>수정</td>");
		
		for(int i = 0; i < list.size(); i++) {
			MemberVO vo = (MemberVO)list.get(i);
			out.print("<tr><td>" + vo.getId() + "</td><td>"
								+ vo.getPwd() + "</td><td>"
								+ vo.getName() + "</td><td>"
								+ vo.getEmail() + "</td><td>"
								+ vo.getJoinDate() + "</td><td>"
								+ "<a href='/pro07/member4?command=delMember&id=" + vo.getId() + "' onclick=\"return confirm('정말 삭제하시겠습니까?');\">삭제</a></td><td>"
								+ "<a href='/pro07/member4?command=modMember&id=" + vo.getId() + "'>수정</a></td>");
		}
		out.print("</table>");
		out.print("<a href='/pro07/memberForm.html'>" + "회원 가입" + "</a>");
		out.print("</body></html>");
	}
	
}
