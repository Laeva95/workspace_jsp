package file.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
		String savePath = request.getServletContext().getRealPath("/" + UPLOAD_DIR);
		
		// upload 폴더가 없다면 새로 만들기
		File saveDir = new File(savePath);
		
		// exists(): 파일이 존재하는지 여부 반환
		if(!saveDir.exists()) {
			// mkdirs(): 만든 파일의 상위 디렉토리가 없다면 모두 생성
			// mkdir(): 만든 파일의 상위 디렉토리가 없다면 생성하지 않음
			saveDir.mkdirs();
		}
		
		// MultipartRequest 클래스 객체 생성시 생성자로 업로드 할 파일의 정보를 전달하여 업로드
		MultipartRequest multipartRequest = new MultipartRequest(
				request, 						// 매개변수 1. request: form 태그에서 전달받은 요청 데이터가 저장된 내장 객체
				savePath, 						// 매개변수 2. savePath: 파일이 업로드 될 경로가 저장된 변수
				MAX_SIZE, 						// 매개변수 3. MAX_SIZE: 한번에 업로드 할 수 있는 파일의 최대 크기
				"utf-8", 						// 매개변수 4. "utf-8": 파일명의 한글이 깨지지 않도록 설정
				new DefaultFileRenamePolicy());	// 매개변수 5. DefaultFileRenamePolicy: 같은 이름의 파일 업로드 시 파일명 끝에 1을 자동으로 생성하도록 지원
		
		
		// 업로드 요청으로 전송된 input 태그들의 name 속성값들을 Enumaration 배열에 담아 반환받기
		Enumeration<?> files = multipartRequest.getFileNames();
		
		// 데이터 베이스에 저장 성공한 파일 개수를 카운트 할 변수 선언
		int count = 0;
		
		// 배열에 저장된 개수만큼 반복
		while(files.hasMoreElements()) {
			// input 태그의 name 속성을 하나씩 꺼내서 저장
			String inputName = (String)files.nextElement();
			
			// 톰캣 서버가 관리하는 실제 폴더에 업로드 하기전에 첨부한 파일의 원본 파일명 반환
			String fileName = multipartRequest.getOriginalFileName(inputName);
			
			// 톰캣 서버가 관리하는 실제 폴더에 업로드된 실제 파일명 반환
			String fileRealName = multipartRequest.getFilesystemName(inputName);
			
			// input 태그에 파일을 첨부하지 않고 요청한 경우 건너뛰기
			if(fileName == null || fileRealName == null) {
				continue;
			}
			
			// 업로드 요청시 첨부한 원본 파일명과 실제로 업로드된 파일명을 데이터베이스에 추가하기
			// 성공시 1, 실패시 -1 반환
			int result = fileDAO.upload(fileName, fileRealName);
			
			// 성공한 경우 count + 1
			if(result == 1) {
				count++;
			}
		}
		
		// 업로드 결과를 request 내장 객체에 바인딩
		request.setAttribute("successCount", count);
		
		// 업로드 결과 화면인 uploadResult.jsp 요청
		request.getRequestDispatcher("/WEB-INF/views/uploadResult.jsp").forward(request, response);
		
		
	}

}
