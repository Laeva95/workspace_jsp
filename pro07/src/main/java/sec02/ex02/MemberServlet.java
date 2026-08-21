package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		// MemberServlet 객체가 어떤 요청을 받았는지 확인
		String command = request.getParameter("command");
		
		// addMember 요청을 받았을 때의 처리
		if(command != null && command.equals("addMember")) {
			String _id = request.getParameter("id");
			String _pwd = request.getParameter("pwd");
			String _name = request.getParameter("name");
			String _email = request.getParameter("email");
			
			// 데이터를 전달하기 위한 VO 객체
			MemberVO vo = new MemberVO(_id, _pwd, _name, _email);

			int result = dao.addMember(vo);
			
			
		// delMember 요청을 받았을 때의 처리
		}else if(command != null && command.equals("delMember")) {
			String id = request.getParameter("id");
			
			dao.delMember(id);
		}else if(command != null && command.equals("modMember")) {
			String id = request.getParameter("id");
			
			// id 값을 통해 수정할 회원의 정보가 담긴 VO 객체 생성
			MemberVO vo = dao.modMember(id);
			
			// 한글 이름을 주소에 전달 할 수 있게 변환(URL 인코딩)
			// 인코딩 하지 않으면 한글이 깨질 수 있음
			String encName = URLEncoder.encode(vo.getName(), "utf-8");
			
			// 브라우저로 응답할 데이터 유형을 설정 후 출력 스트림 생성
			response.setContentType("text/html; charset=utf-8");
			
			PrintWriter out = response.getWriter();
			
			// 재요청 자바스크립트를 문자열로 조립해서 브라우저 응답으로 출력
			out.print("<script>");
				out.print("location.href = '/pro07/memberModForm.html"
						+ "?id=" + vo.getId() 		
						+ "&pwd=" + vo.getPwd() 
						+ "&name=" + encName			// vo.getName() 이 아닌 encName 을 입력. 한글이 깨질 수 있기 때문
						+ "&email=" + vo.getEmail() + "';");
			out.print("</script>");
			return;
		}
		
		
		// listMembers(): 검색한 회원 정보를 MemberVO 객체에 저장해서 list로 반환하는 메서드
		List list = dao.listMembers();
		
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
								+ "<a href='/pro07/member4?command=delMember&id=" + vo.getId() + "'>삭제</a></td><td>"
								+ "<a href='/pro07/member4?command=modMember&id=" + vo.getId() + "'>수정</a></td>");
		}
		out.print("</table>");
		out.print("<a href='/pro07/memberForm.html'>" + "회원 가입" + "</a>");
		out.print("</body></html>");
	}
}
