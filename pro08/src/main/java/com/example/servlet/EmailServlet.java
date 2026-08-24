package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// @WebServlet("/sendEmail")	-> web.xml 에서 매핑된 주소로 연결
public class EmailServlet extends HttpServlet {
	private String serverAddress;
	private int serverPort;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		serverAddress = config.getInitParameter("serverAddress");
		
		String port = config.getInitParameter("serverPort");
		
		try {
			serverPort = Integer.parseInt(port);
		} catch (Exception e) {
			throw new ServletException("Invalid port number: " + port);
		}
		
		System.out.println("이메일 서버의 도메인주소: " + serverAddress);
		System.out.println("이메일 서버의 포트번호: " + serverPort);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
			out.print("<h2>이메일 발송 서버 정보</h2>");
			out.print("<p><string>이메일 서버 도메인 주소: </string>" + serverAddress + "</p>");
			out.print("<p><string>이메일 서버 포트 번호: </string>" + serverPort + "</p>");
			out.print("<p>이메일 발송 기능 실행</p>");
		out.print("</body></html>");
		
	}

}
