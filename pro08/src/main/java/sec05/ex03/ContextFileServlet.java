package sec05.ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cfile")
public class ContextFileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		ServletContext servletContext = getServletContext();
		
		InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/bin/init.txt");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		
		String menu = null;
		
		String menu_member = null;
		
		String menu_order = null;
		
		String menu_goods = null;
		
		while((menu = reader.readLine()) != null) {
			StringTokenizer tokenizer = new StringTokenizer(menu, ",");
			
			menu_member = tokenizer.nextToken();
			menu_order = tokenizer.nextToken();
			menu_goods = tokenizer.nextToken();
		}
		
		out.print(menu_member + "<br>");
		out.print(menu_order + "<br>");
		out.print(menu_goods + "<br>");
		
		
		
	}
}
