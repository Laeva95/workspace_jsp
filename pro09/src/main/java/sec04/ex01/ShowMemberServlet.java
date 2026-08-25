package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/show")
public class ShowMemberServlet extends HttpServlet {

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = "";
		String pw = "";
		boolean isLogin = false;
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			// 로그인 인증 값을 가져와서 저장
			isLogin = (Boolean)session.getAttribute("isLogin");
			
			if(isLogin) {
				id = (String)session.getAttribute("login.id");
				pw = (String)session.getAttribute("login.pw");
					
				out.print("<html><body>");
					out.print(id + "님 로그인 중입니다... 환영합니다!");
					out.print("비밀번호는 " + pw + " 입니다!");
				out.print("</body></html>");
			}else {
				response.sendRedirect("login5.html");
			}
		}else {
			response.sendRedirect("login5.html");
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

}
