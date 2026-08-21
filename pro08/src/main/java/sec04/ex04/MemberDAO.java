package sec04.ex04;
import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO {
	// DAO: Data Access Object. 데이터에 접근하기 위한 객체
	
	// =========================================================================	
	// 톰캣이 context.xml 을 읽어서 커넥션풀 객체의 주소를 저장할 변수
	private DataSource dataSource;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envCtx = (Context)ctx.lookup("java://comp/env");
			
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
	
	
	// t_member 테이블에 새로운 회원을 추가하는 기능의 메서드
	public int addMember(MemberVO vo) {
		int result = 0;
		
		// 가입 날짜는 오라클의 현재 날짜정보를 사용해서 생성
		String query = "INSERT INTO t_member(id, pwd, name, email, joinDate) VALUES(?, ?, ?, ?, SYSDATE)";
		
		try(Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query)) {
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void delMember(String id) {
		// 가입 날짜는 오라클의 현재 날짜정보를 사용해서 생성
		String query = "DELETE FROM t_member WHERE id = ?";
		
		try(Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query)) {
			
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public MemberVO modMember(String id) {
		MemberVO vo = new MemberVO();
		
		// 매개 변수 id에 해당하는 멤버 1명 조회를 위한 쿼리문
		String query = "SELECT * FROM t_member WHERE id = ?";
		
		try(Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query)) {
				
			pstmt.setString(1, id);
			
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					vo.setId(rs.getString("id"));
					vo.setPwd(rs.getString("pwd"));
					vo.setName(rs.getString("name"));
					vo.setEmail(rs.getString("email"));
					vo.setJoinDate(rs.getDate("joinDate"));
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		
		// 정보가 저장된 VO 객체 반환
		return vo;
	}

	// 회원 정보 수정 요청을 DB에 전달하고 성공했는지 여부를 반환하는 메소드
	public int updateMember(MemberVO vo) {
		int result = 0;
		
		try {
			// 커넥션풀에서 미리 생성된 커넥션 객체 가져오기
			con = dataSource.getConnection();
			
			// 회원 정보 수정을 위한 UPDATE 쿼리문 생성
			String query = "UPDATE t_member SET pwd = ?, name = ?, email = ? WHERE id = ?";
			
			// query 변수의 쿼리문을 로드한 PreparedStatement 객체 생성
			pstmt = con.prepareStatement(query);
			
			// 수정값과 조건값의 순서에 따라 데이터 입력
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getId());
			
			// 쿼리문을 DB에 전달하여 실행하고 결과값을 result 변수에 저장
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 사용한 메모리 자원 해제
			resourceClose();
		}
		// 회원 정보 수정이 성공했는지 여부 반환
		// 1 = 성공 0 = 실패
		return result;
	}
	
}
