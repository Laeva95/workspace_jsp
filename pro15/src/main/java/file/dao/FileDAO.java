package file.dao;

import file.vo.FileVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class FileDAO {
	private static DataSource dataSource;
	
	// 스태틱 초기화 블록
	static {
		try {
			dataSource = (DataSource)(new InitialContext().lookup("java:comp/env/jdbc/file"));
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// 커넥션 객체 하나를 반환하는 메소드
	private Connection getConnection() throws Exception {
		 return dataSource.getConnection();
	}
	
	// 업로드 한 파일을 file 테이블에 insert 하는 메소드
	public int upload(String fileName, String fileRealName) {
		
		// 처음 업로드하는 상황이므로 downloadcount 열에 0을 입력
		String query = "insert into file(filename, filerealname, downloadcount) values(?, ?, 0)";
		
		try(Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(query)){
			
			// 쿼리 완성하기
			pstmt.setString(1, fileName);
			pstmt.setString(2, fileRealName);
			
			// 완성된 쿼리 실행. 성공시 1 반환
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 예외가 발생해서 추가에 실패했을 경우 -1 반환
		return -1;
	}
	
	// 업로드된 파일 목록을 모두 조회해서 ArrayList로 반환하는 메소드
	public ArrayList<FileVO> selectAll(){
		ArrayList<FileVO> list = new ArrayList<FileVO>();
		
		// 모든 열을 조회하는 쿼리 작성
		// filerealname 을 기준으로 내림차순 정렬
		String query = "select * from file order by filerealname desc";
		
		try(Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery()){
			
			// rs에 다음 행이 남아 있다면 계속 실행
			while (rs.next()) {
				// list.add(new FileVO(rs.getString("filename"), rs.getString("filerealname"), rs.getInt("downloadcount")));
				// rs의 각 열 데이터를 변수에 저장
				String fileName = rs.getString("filename");
				String fileRealName = rs.getString("filerealname");
				int downloadCount = rs.getInt("downloadcount");
				
				// FileVO에 저장한 변수를 전달해서 생성
				FileVO vo = new FileVO(fileName, fileRealName, downloadCount);
				
				// list에 추가
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	// 매개변수를 통해 데이터 베이스에서 원본 파일명을 찾아서 반환하는 메소드
	public String selectOriginName(String fileRealName) {
		// 원본 파일명을 조회할 쿼리 작성
		String query = "select filename from file where filerealname = ?";
		
		// 커넥션 객체 및 쿼리를 실행할 객체 생성
		try(Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(query)){
			
			// 쿼리의 ? 자리에 fileRealName 전달
			pstmt.setString(1, fileRealName);
			
			// 쿼리를 실행하고 결과를 rs 변수에 저장
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					// 결과 열 값 반환
				return rs.getString("filename");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// null 반환
		return null;
	}
	
	// 파일을 다운로드 할 때 다운로드 횟수를 1 증가시키는 메소드
	// 성공하면 1, 실패하면 -1을 반환
	public int hit(String fileRealName) {
		// 다운로드 횟수를 1 증가시키는 update 쿼리 생성
		String query = "update file set downloadcount = downloadcount + 1 "
					+ "where filerealname = ?";
		
		try (Connection con = getConnection();
			 PreparedStatement pstmt = con.prepareStatement(query)) {
			
			pstmt.setString(1, fileRealName);
			
			// 쿼리 실행에 성공한 행 개수 반환
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
