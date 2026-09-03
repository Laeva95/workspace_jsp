package file.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import file.dao.FileDAO;
import file.vo.FileVO;

@WebServlet("/list.do")
public class FileListServlet extends HttpServlet {
	// DB 작업을 대신 시키기 위한 FileDAO 객체
	private FileDAO fileDAO;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 서버 시작시 최초 1회 FileDAO 객체 생성
		fileDAO = new FileDAO();
	}
	/*
	  get 요청
	  1. 주소창에 직접 주소를 입력하는 경우
	  2. <a> 태그의 링크를 클릭한 경우
	  3. <form> 태그의 method="get" 으로 전송한 경우
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 브라우저의 요청 데이터 한글 처리
		request.setCharacterEncoding("utf-8");
		
		// fileDAO 객체를 통해 업로드된 파일 정보 조회
		ArrayList<FileVO> list = fileDAO.selectAll();
		
		// request 내장 객체에 list 저장
		request.setAttribute("list", list);
		
		// 조회 결과를 보여주기 위한 JSP 화면 포워딩
		request.getRequestDispatcher("/WEB-INF/views/fileList.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
