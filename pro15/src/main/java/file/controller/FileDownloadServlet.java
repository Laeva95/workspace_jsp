package file.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import file.dao.FileDAO;

@WebServlet("/download.do")
public class FileDownloadServlet extends HttpServlet{
	// 업로드된 파일이 저장된 폴더 이름
	private static final String UPLOAD_DIR = "upload";
	
	// DB 작업을 대신할 FileDAO 객체
	private FileDAO fileDAO;
	
	@Override
	public void init() throws ServletException {
		fileDAO = new FileDAO();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 전달받은 내장 객체에서 fileRealName 가져오기
		String fileRealName = request.getParameter("fileRealName");
		
		// 다운로드 할 파일명을 다운로드 요청시 전달하지 않았거나 공백만 전달되었으면 목록 화면 재요청
		if(fileRealName == null || fileRealName.trim().length() == 0) {
			response.sendRedirect("list.do");
			return;
		}
		
		// 경로를 조작하는 공격을 차단
		// 파일명에 "..", "\", "/" 기호가 포함 되어 있다면 무조건 차단
		if(fileRealName.contains("..") || fileRealName.contains("\\") || fileRealName.contains("/")) {
			response.sendRedirect("list.do");
			return;
		}
		
		// 업로드된 파일의 절대 경로 얻기
		String savePath = request.getServletContext().getRealPath("/" + UPLOAD_DIR);
		
		// 다운로드 할 파일의 폴더 경로와 파일명을 결합하여 다운로드 할 파일에 접근할 File 객체 생성
		File downFile = new File(savePath, fileRealName);
		
		// 다운로드 할 파일이 존재하지 않는다면 목록 재요청
		if(!downFile.exists()) {
			response.sendRedirect("list.do");
			return;
		}
		
		// file 테이블에서 실제 파일명에 해당하는 원본 파일명 조회
		String fileName = fileDAO.selectOriginName(fileRealName);
		
		// db에 저장된 파일명이 없다면 실제 파일명을 그대로 사용
		if(fileName == null) {
			fileName = fileRealName;
		}
		
		// file 테이블의 downloadcount 열의 값을 1 증가시키기
		fileDAO.hit(fileRealName);
		
		// 응답할 데이터 유형 설정
		// 종류를 알 수 없는 2진 데이터
		response.setContentType("application/octet-stream");
		
		// 응답할 데이터의 전체 크기를 byte 단위로 브라우저에게 알려주기
		response.setContentLengthLong(downFile.length());
		
		// 다운로드 할 파일의 한글 처리 URLEncoder
		// "\\" 기호를 "%20" 으로 치환
		String encodeName = URLEncoder.encode(fileName, "utf-8").replaceAll("\\\\", "%20");
		
		// 다운로드 지시 헤더 설정
		// filename: 구형 브라우저가 읽는 파일명
		// filename*: 한글을 지원하는 최신 브라우저가 읽는 파일명
		response.setHeader("Content-Disposition", "attachment; filename=\"" + encodeName + "\"; filename*=utf-8''" + encodeName);
		
		// 파일의 정보를 읽어서 내보낼 스트림 통로 객체 생성
		try(FileInputStream fis = new FileInputStream(downFile);
			OutputStream os = response.getOutputStream()){
			
			// 파일을 읽어들일 버퍼 선언
			byte[] buffer = new byte[1024 * 8];
			
			int readCount;
			
			while((readCount = fis.read(buffer)) != -1) {
				os.write(buffer, 0, readCount);
			}
			os.flush();
		}
	}
	
	
	
	
}
