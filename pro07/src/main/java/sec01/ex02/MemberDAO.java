package sec01.ex02;
import java.sql.*;
import java.util.ArrayList;


public class MemberDAO {
	// DAO: Data Access Object. 데이터에 접근하기 위한 객체
	
	// 순서 1. DB 연결 정보 4가지를 상수 메모리에 저장
	
	// 1.1 JDBC 드라이버의 전체 경로를 문자열로 저장
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	// 1.2 DB 접속 주소를 문자열로 저장
	// jdbc		=> Java DataBase Connectivity. 자바에서 DB에 접속하는 표준 규칙
	// :		=> 앞 정보와 뒤 정보를 나누는 구분자 기호
	// oracle	=> 접속 대상 DBMS 종류
	// thin		=> 순수 자바로만 이루어진 드라이버를 사용한다는 의미
	// :@		=> 여기까지 드라이버 정보, @ 뒤부터는 실제 접속 정보
	// localhost=> 오라클 DBMS가 설치된 서버 컴퓨터의 IP 주소
	// 1521		=> 오라클 DBMS 소프트웨어가 요청 받는 포트 넘버(오라클 기본 포트번호)
	// XE		=> SID(System ID). 여러 DB 중에서 XE라는 DB에 접속하라는 의미
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	// 1.3 XE DB에 접속할 계정 아이디를 문자열로 저장
	private static final String USER = "scott";
	
	// 1.4 접속할 계정 아이디의 비밀번호를 문자열로 저장
	private static final String PWD = "tiger";
	
	// =========================================================================
	// DB 작업에 필요한 3가지 객체를 참조할 변수 선언
	private Connection con;
	
	private PreparedStatement pstmt;
	
	private ResultSet rs;
	
	// 순서 2 ~ 4를 처리하는 connDB() 메소드
	private void connDB() {
		try {
			// 순서 2. JDBC 드라이버를 JVM 메모리에 로딩
			// DRIVER: 오라클 드라이버가 저장된 경로 문자열
			Class.forName(DRIVER);
			
			// 순서 3. Connection 객체 얻기
			// 매개변수 URL, 계정 ID, 계정 비밀번호 전달
			con = DriverManager.getConnection(URL, USER, PWD);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ===========================================================================
	// listMembers() 메소드 정의
	public ArrayList<MemberVO> listMembers(){
		
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			// 드라이버 로딩 + DB 접속
			connDB();
			
			// 순서 5. 실행할 SQL 문장을 문자열로 작성
			String query = "SELECT * FROM t_member";
			
			// 순서 5.1 순서 4 대신 SQL 문장을 미리 전달하며 PreparedStatement 객체 생성
			pstmt = con.prepareStatement(query);
			
			// 순서 6. SQL 을 DB로 전송. 결과 커서 받기
			// 처음 받아오는 순간 rs 커서는 첫번째 행 직전 위치에 있음
			rs = pstmt.executeQuery();
		
			// 순서 7. 커서를 한 행씩 이동시키며 데이터 읽기
			// rs.next(): rs 커서를 다음 행으로 이동시키고 true 반환. 만약 다음 행이 존재하지 않는다면 false 반환
			while(rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setJoinDate(rs.getDate("joindate"));
				
				list.add(member);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 순서 8. 성공/예외 발생과 상관 없이 DB 연결 자원 반납
			resourceClose();
		}
		return list;
	}
	
	// 데이터 베이스 연결 자원을 반납하는 기능의 메소드
	public void resourceClose() {
		// null 이 아닌 사용중이던 객체를 close() 메소드를 통해 닫음
		// 생성한 순서 반대로 닫아야함!!
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
