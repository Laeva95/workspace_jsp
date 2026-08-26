package sec04.ex01;

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

@WebServlet("/loginTest")
public class LoginTestServlet extends HttpServlet {
	ServletContext context = null;
	List user_list = new ArrayList();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		// 이벤트 핸들러 객체: 이벤트가 발생하면 이벤트를 처리하는 코드가 작성된 클래스의 객체
		LoginImpl loginUser = new LoginImpl(user_id, user_pw);
		
		// 로그인 접속 요청 하나에 대한 세션 객체 메모리
		HttpSession session = request.getSession();
		
		// 로그인 접속시 새로 만든 세션 메모리라면
		if(session.isNew()) {
			// 이벤트 처리 핸들러 객체 바인딩
			session.setAttribute("loginUser", loginUser);
		}
		
		out.print("<html>");
			out.print("<head>");
				out.print("<script type='text/javascript'>");
					out.print("window.setTimeout('history.go(0)', 5000)");
				out.print("</script>");
			out.print("</head>");
			out.print("<body>");
				out.print("접속한 사용자 아이디: " + loginUser.user_id + "<br>");
				out.print("접속한 사용자 패스워드: " + loginUser.user_pw + "<br>");
				out.print("총 접속자 수: " + LoginImpl.total_user);
		out.print("</body></html>");
		
	}

}
