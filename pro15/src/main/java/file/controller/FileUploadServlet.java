package file.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import file.dao.FileDAO;

@WebServlet("/upload.do")
public class FileUploadServlet extends HttpServlet {
	// 직렬화 버전 번호
	private static final long serialVersionUID = 1;
	
	// 업로드된 파일이 저장된 폴더 이름
	private static final String UPLOAD_DIR = "upload";
	
	// 한번에 업로드 할 수 있는 파일의 크기를 10MB로 설정
	// 10MB = 1024 * 1024 * 10 byte
	private static final int MAX_SIZE = 1024 * 1024 * 10;
	
	// DB 작업을 대신 시킬 FileDAO 클래스의 객체 저장
	private FileDAO fileDAO;
	
	// FileUploadServlet 객체가 최초로 톰캣 서버 메모리에 올라갈 때 딱 한번만 실행되는 메소드
	@Override
	public void init() throws ServletException {
		fileDAO = new FileDAO();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET 요청 -> 파일 업로드 폼 디자인 화면으로 재요청
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/fileUpload.jsp");
		dispatcher.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 요청 -> 업로드 요청한 파일을 데이터베이스에 업로드
		
		// 파일을 업로드 할 실제 절대 경로
		String savePath = request.getServletContext().getRealPath(UPLOAD_DIR);
		
		System.out.println(savePath);
		
	}

}
