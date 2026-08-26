package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutTest2")
public class LogoutTest2 extends HttpServlet {
	ServletContext context;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		context = getServletContext();
		
		HttpSession session = request.getSession();
		
		// 현재 브라우저의 로그인된 사용자 id 값 가져오기
		String user_id = request.getParameter("user_id");
		
		// 현재 브라우저의 세션 객체 메모리 제거
		session.invalidate();
		
		List<String> user_list = (ArrayList<String>)context.getAttribute("user_list");
		
		if(user_list.remove(user_id)) {
			System.out.println("유저 리스트에서 제거 완료");
		} else {
			System.out.println("유저 리스트에서 제거 실패");
		}

		context.setAttribute("user_list", user_list);
		
		out.print("<br>로그아웃 했습니다.");
	}
}
