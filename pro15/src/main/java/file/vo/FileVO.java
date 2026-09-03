package file.vo;

public class FileVO {
	// 조회된 레코드 정보를 저장할 변수 선언
	// filename      VARCHAR(255) NOT NULL,   -- 업로드 요청시 첨부했던 원본 파일명
	// filerealname  VARCHAR(255) NOT NULL,   -- 실제 upload 폴더에 저장된 파일명
	// downloadcount INT DEFAULT 0,           -- 다운로드를 시도한 횟수
	private String fileName;		// 업로드 요청시 첨부했던 원본 파일명
	private String fileRealName;	// 실제 톰캣 서버에 업로드된 파일명
	private int downloadCount;		// 다운로드를 시도한 횟수
	
	// 생성자
	public FileVO() {}
	public FileVO(String fileName, String fileRealName, int downloadCount) {
		this.fileName = fileName;
		this.fileRealName = fileRealName;
		this.downloadCount = downloadCount;
	}
	
	// getter, setter
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileRealName() {
		return fileRealName;
	}
	public void setFileRealName(String fileRealName) {
		this.fileRealName = fileRealName;
	}
	
	public int getDownloadCount() {
		return downloadCount;
	}
	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}
	
}
