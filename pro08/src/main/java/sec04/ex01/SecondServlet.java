package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/second")
public class SecondServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 재요청한 클라이언트의 웹 브라우저 창으로 응답할 데이터 유형 설정
		response.setContentType("text/html; charset=utf-8");
		
		// FirstServlet 클래스에서 작성한 정보를 가져오기
		String address = (String)request.getAttribute("address");
		
		// 요청한 클라이언트의 브라우저와 연결되어 있는 데이터를 내보내서 연결할 출력 스트림 생성
		PrintWriter out = response.getWriter();
		
		// 응답할 메세지를 생성해서 출력
		out.print("<html><body>");
			// null 출력
			out.print("FirstServlet 클래스에서 공유받아서 출력하는 값: " + address);
		out.print("</body></html>");
		
	}
}
