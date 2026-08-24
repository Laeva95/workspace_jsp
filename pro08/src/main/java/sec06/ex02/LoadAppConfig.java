package sec06.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/loadConfig"},
			name = "loadConfig",
			loadOnStartup = 1)
public class LoadAppConfig extends HttpServlet {
	
	private ServletContext context;
	
	private String menu_member;
	private String menu_order;
	private String menu_goods;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoadAppConfig 서블릿의 init 메소드 호출");
		
		context = config.getServletContext();
		
		menu_member = context.getInitParameter("menu_member");
		menu_order = context.getInitParameter("menu_order");
		menu_goods = context.getInitParameter("menu_goods");
		
		context.setAttribute("menu_member", menu_member);
		context.setAttribute("menu_order", menu_order);
		context.setAttribute("menu_goods", menu_goods);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String menu_member = (String)context.getAttribute("menu_member");
		String menu_order = (String)context.getAttribute("menu_order");
		String menu_goods = (String)context.getAttribute("menu_goods");
		
		out.print(menu_member);
		out.print(menu_order);
		out.print(menu_goods);
		
	}
}
