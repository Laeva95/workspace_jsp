package sec02.ex01;
import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO {
	// DAO: Data Access Object. 데이터에 접근하기 위한 객체
	
	// =========================================================================
	// DB 작업에 필요한 3가지 객체를 참조할 변수 선언
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 톰캣이 context.xml 을 읽어서 커넥션풀 객체의 주소를 저장할 변수
	private DataSource dataSource;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			
			Context envCtx = (Context)ctx.lookup("java:/comp/env");
			
			dataSource = (DataSource)envCtx.lookup("jdbc/oracle");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// ===========================================================================
	// listMembers() 메소드 정의
	public ArrayList<MemberVO> listMembers(){
		
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			// 커넥션 풀에서 커넥션 객체 하나 가져오기
			// 객체를 새로 생성하는 것이 아니라, 이미 생성된 객체 하나를 가져오는 것
			con = dataSource.getConnection();
			
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
