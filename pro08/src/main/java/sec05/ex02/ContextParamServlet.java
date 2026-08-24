package sec05.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/initMenu")
public class ContextParamServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf8");
		
		PrintWriter out = response.getWriter();
		
		ServletContext servletContext = getServletContext();
		
		String member = servletContext.getInitParameter("menu_member");
		String order = servletContext.getInitParameter("menu_order");
		String goods = servletContext.getInitParameter("menu_goods");
		
		out.print("<html><body>");
			out.print("<table border='1' cellspacing='0'>");
				out.print("<tr><td>메뉴명</td></tr>");
				out.print("<tr><td>" + member + "</td></tr>");
				out.print("<tr><td>" + order + "</td></tr>");
				out.print("<tr><td>" + goods + "</td></tr>");
			out.print("</table>");
		out.print("</body></html>");
		
	}
}
