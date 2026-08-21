package sec02.ex02;
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
	
	// t_member 테이블에 새로운 회원을 추가하는 기능의 메서드
	public int addMember(MemberVO vo) {
		int result = 0;
		try {
			// 커넥션풀에서 커넥션 객체 가져오기
			con = dataSource.getConnection();
			
			String id = vo.getId();
			String pwd = vo.getPwd();
			String name = vo.getName();
			String email = vo.getEmail();

			String query = "INSERT INTO t_member (id, pwd, name, email)" +
							"VALUES(?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
			// executeUpdate(): INSERT 쿼리문이 성공하면 1, 실패하면 0 반환
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {	
			e.printStackTrace();
		} finally {
			// 생성했던 DB 관련 객체들 메모리 해제
			resourceClose();
		}
		
		return result;
	}
	
	public void delMember(String id) {
		try {
			con = dataSource.getConnection();
			
			String query = "DELETE FROM t_member WHERE id = ?";
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 자원 해제
			resourceClose();
		}
	}
	
	public MemberVO modMember(String id) {
		MemberVO vo = null;
		
		try {
			// 커넥션풀에서 커넥션 객체 할당
			con = dataSource.getConnection();
			
			// 매개 변수 id에 해당하는 멤버 1명 조회를 위한 쿼리문
			String query = "SELECT * FROM t_member WHERE id = ?";
			
			// preparedStatement 객체 생성
			pstmt = con.prepareStatement(query);
			
			// 쿼리문의 ? 대신 매개 변수 id 설정
			pstmt.setString(1, id);
			
			// 쿼리문을 실행하여 rs 객체에 저장
			rs = pstmt.executeQuery();
			
			// rs의 첫번째 행에서 회원 정보를 얻어 VO 객체에 저장
			if(rs.next()) {
				vo = new MemberVO();
				
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setJoinDate(rs.getDate("joindate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 사용한 메모리 자원 해제
			resourceClose();
		}
		// 정보가 저장된 VO 객체 반환
		return vo;
	}
	
}
