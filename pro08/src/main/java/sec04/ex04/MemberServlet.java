package sec04.ex04;

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
@WebServlet("/member5")
public class MemberServlet extends HttpServlet{
	private MemberDAO memberDAO = new MemberDAO();
	
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
		
		String command = request.getParameter("command");
		
		// 어떤 요청을 받았는지 조건식으로 확인
			// 회원 가입 요청
		if("addMember".equals(command)) {
			addMember(request);
			// 회원 삭제 요청
		} else if("delMember".equals(command)) {
			delMember(request);
			// 회원 정보 수정 요청
		} else if("modMember".equals(command)) {
			modMember(request, response);
			return;
		} else if("modMember2".equals(command)) {
			modMember2(request, response);
		}
		
		// 전체 회원 조회를 위한 ViewServlet 포워딩
		forwardListMembers(request, response);

	}
	
	private void addMember(HttpServletRequest request) {
		// 새 회원 정보를 DB에 추가하는 메소드
		MemberVO vo = new MemberVO(request.getParameter("id")
								, request.getParameter("pwd")
								, request.getParameter("name")
								, request.getParameter("email"));
		
		int result = memberDAO.addMember(vo);
		
		System.out.println("회원 가입 성공 시 1, 실패 시 0 출력: " + result);
	}
	
	private void delMember(HttpServletRequest request) {
		// 회원 정보 하나를 DB에서 삭제하는 메소드
		String id = request.getParameter("id");
		
		memberDAO.delMember(id);
	}
	
	private void modMember(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 기존 회원 정보를 수정하는 메소드
		MemberVO vo = memberDAO.modMember(request.getParameter("id"));
		
		// 한글 이름을 주소에 전달 할 수 있게 변환(URL 인코딩)
		// 인코딩 하지 않으면 한글이 깨질 수 있음
		String encName = URLEncoder.encode(vo.getName(), "utf-8");
		
		// 브라우저로 응답할 데이터 유형을 설정 후 출력 스트림 생성
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		// 재요청 자바스크립트를 문자열로 조립해서 브라우저 응답으로 출력
		out.print("<script>");
			out.print("location.href = '/pro08/memberModForm.html"
					+ "?id=" + vo.getId() 		
					+ "&pwd=" + vo.getPwd() 
					+ "&name=" + encName			// vo.getName() 이 아닌 encName 을 입력. 한글이 깨질 수 있기 때문
					+ "&email=" + vo.getEmail() + "';");
		out.print("</script>");
	}
	
	private void modMember2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 수정된 회원의 정보 받아오기
		String _id = request.getParameter("id");
		String _pwd = request.getParameter("pwd");
		String _name = request.getParameter("name");
		String _email = request.getParameter("email");
		
		// 수정된 회원의 정보가 담긴 vo 객체 생성
		MemberVO vo = new MemberVO(_id, _pwd, _name, _email);
		
		// vo 객체를 전달해서 회원 정보 수정
		int result = memberDAO.updateMember(vo);
		
		// 회원 정보가 수정이 되었는지 확인하기 위해 조회 재요청
		// 브라우저로 응답할 데이터 유형을 설정 후 출력 스트림 생성
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<script>");
			out.print("alert('회원 정보가 수정되었습니다.');");
			out.print("location.href = '/pro08/member5';");
		out.print("</script>");
	}
	
	private void forwardListMembers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// listMembers(): 검색한 회원 정보를 MemberVO 객체에 저장해서 list로 반환하는 메서드
		List list = memberDAO.listMembers();
		
		// 회원 정보를 request 객체에 저장
		request.setAttribute("membersList", list);
		
		// dispatch 방식을 이용해서 view 서블릿 페이지 요청
		request.getRequestDispatcher("viewMembers2").forward(request, response);
	}
}
