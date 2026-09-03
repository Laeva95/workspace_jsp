package sec01.ex02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/*
	업로드된 파일을 브라우저로 다운로드 할 수 있는 기능을 제공하는 서블릿
 */
@WebServlet("/download.do")
public class FileDownload extends HttpServlet {

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 다운로드를 요청한 클라이언트의 브라우저로 다운로드할 파일의 정보를 응답할 데이터 유형 설정
		response.setContentType("text/html; charset=utf-8");
		
		// 다운로드 할 파일이 저장된 경로 저장
		String file_repo = "C:\\file_repo";
		
		// 다운로드 요청한 파일명을 request 객체에서 가져오기
		// http://localhost:8181/pro15/download.do?fileName=LICENSES.chromium.html
		String fileName = request.getParameter("fileName");
		
		// 경로와 파일명을 더해서 하나의 문자열로 저장
		String downFile = file_repo + "\\" + fileName;
		
		// 클라이언트의 브라우저와 연결될 출력 스트림 통로 생성
		OutputStream outputStream = response.getOutputStream();		
		
		// 전체 경로에 접근하기 위한 File 클래스 객체 생성
		File file = new File(downFile);
		
		// 캐시 메모리를 사용하지 않기 위해 response 객체 설정
		// 또한 뒤로 가기를 통해 이전 페이지로 이동해서 캐싱되는 것을 방지
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Cache-Control", "no-store");
		
		// 파일 다운로드시 다른 이름으로 저장 대화상자가 팝업되도록 헤더 속성 설정
		// 또한 파일명이 한글일 경우 깨지는 것을 방지하기 위해 utf-8 인코딩 설정
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(fileName, "utf-8") + "\"");
		
		// Content-Disposition
		//			- attachment: 모든 파일에 대해 파일 대화상자 팝업
		//			-- inline: 브라우저 파일은 바로 열고, 그 외는 파일 다운로드 대화상자 팝업
		
		// 실제 파일 다운로드를 위한 스트림 통로 객체 생성
		FileInputStream fileInputStream = new FileInputStream(file);
		
		// 다운로드할 파일에서 데이터를 8kb씩 읽어서 저장할 byte 배열 생성
		byte[] buffer = new byte[1024 * 8];
		while (true) {
			// 다운로드 할 파일을 읽어서 buffer 에 저장하고 읽은 데이터 개수를 count 에 저장
			int count = fileInputStream.read(buffer);
			
			// 더이상 읽을 파일이 없으면 while 문 종료
			if(count == -1) {
				break;
			}
			
			// 저장된 데이터를 출력 스트림을 통해 buffer 배열의 0부터 count 까지의 값을 저장
			outputStream.write(buffer, 0, count);
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

}
