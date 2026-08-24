package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/visitorCounter")
public class VisitorCounterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		
		Integer visitor = (Integer)servletContext.getAttribute("visitor");
		
		if(visitor == null) {
			visitor = 1;
		} else {
			visitor++;
		}
		
		servletContext.setAttribute("visitor", visitor);
		
		servletContext.log("현재 방문자 수: " + visitor);
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("현재 방문자 수: " + visitor);
	}
}
