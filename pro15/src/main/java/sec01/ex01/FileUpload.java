package sec01.ex01;

import java.io.File;
import java.io.IOException;
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
 	브라우저 화면에서 첨부한 파일에 관한 파일 업로드 요청을 받아서 처리하는 서블릿 클래스
 	
 	commons-fileupload-1.3.3.jar 라이브러리 압축파일에서 제공하는 DiskFileItemFactory 클래스를 이용해서
 	업로드되는 톰캣 서버의 하드디스크 경로 위치와 한번에 업로드 가능한 최대 파일 크기를 설정
 	
 	ServletFleUpload 클래스를 이용해서 파일 업로드 요청 화면에서 업로드 요청한 파일과 요청한 파라미터 정보를 가져와서
 	파일 업로드 기능을 실제로 처리하고 요청한 파라미터를 얻어서 브라우저에 출력
 */
@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 업로드 되는 톰캣 서버의 하드 디스크 경로와 연결된 File 클래스의 객체 생성
		File currentDirPath = new File("C:\\file_repo");
		
		// 업로드 할 파일을 임시로 저장할 객체 생성
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// 파일 업로드시 사용할 임시 메모리 크기 설정
		factory.setSizeThreshold(1024 * 1024 * 1);
		
		// 임시로 저장할 객체 메모리에 설정한 크기를 넘으면 실제 업로드될 하드디스크 경로에 접근하기 위해 
		// File 클래스의 객체를 DiskFileItemFactory 객체의 생성자로 전달
		factory.setRepository(currentDirPath);
		
		// 업로드할 파일의 임시 메모리 객체의 주소를 생성자로 전달해서 저장시킨
		// 파일 업로드 기능을 실제 처리하는 객체 생성
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			// request 내장 객체에 저장된 파라미터들을 List 타입으로 반환
			List items = upload.parseRequest(request);
			
			for(int i = 0; i < items.size(); i++) {
				FileItem file = (FileItem)items.get(i);
				
				// 입력한 텍스트 요청 정보가 저장된 DiskFileItem 객체일 경우
				if(file.isFormField()) {
					System.out.println(file.getFieldName() + " = " + file.getString("utf-8"));
				} else {
					System.out.println("<input type='file'>의 name 속성값: " + file.getFieldName());
					System.out.println("업로드 요청시 첨부한 파일명: " + file.getName());
					System.out.println("업로드 요청시 첨부한 파일 크기: " + file.getSize() + "bytes");
					
					// 파일 크기가 0 초과라면
					if(file.getSize() > 0) {
						// 업로드 요청한 파일명 뒤에서부터 \\ 문자열이 포함되어있는지 찾아서 index 위치를 반환
						// 없다면 -1 반환
						int idx = file.getName().lastIndexOf("\\");
						
						if(idx == -1) {
							// 업로드 요청한 파일명 뒤에서부터 / 문자열이 포함되어있는지 찾아서 index 위치를 반환
							// 없다면 -1 반환
							idx = file.getName().lastIndexOf("/");
							
							System.out.println("업로드시 첨부해서 요청한 파일명에 / 기호는 포함되지 않음");
						}
						// 업로드시 첨부해서 업로드 요청한 파일명을 변수에 저장
						String fileName = file.getName().substring(idx + 1);
						
						// 업로드 요청한 파일명과 경로를 합쳐서 전체 업로드 경로를 만들어서 File 클래스 객체 생성
						File uploadFile = new File(currentDirPath + "\\" + fileName);
						
						// 실제 "C:\\file_repo\\파일명" 으로 업로드
						file.write(uploadFile);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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
