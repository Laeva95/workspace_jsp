package sec06.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { 
				"/sInit3", 
				"/sInit4"
		}, 
		initParams = { 
				@WebInitParam(name = "email", value = "admin@jweb.com2"), 
				@WebInitParam(name = "tel", value = "010-1111-3333")
		})
public class InitParamServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String email = getInitParameter("email");
		
		String tel = getInitParameter("tel");
		
		out.print("<html><body>");
			out.print("email: " + email + "<br>");
			out.print("tel: " + tel + "<br>");
		out.print("</body></html>");
	}

}
