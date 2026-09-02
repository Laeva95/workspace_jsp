package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	// 커넥션 풀을 사용하기 위한 DataSource 객체 선언
	private DataSource dataFactory;
	
	// MemberDAO 생성자
	// 생성자 호출 시 dataFactory 객체 생성
	public MemberDAO() {
		try {
			dataFactory = (DataSource)((Context)new InitialContext().lookup("java:/comp/env")).lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 전체 회원 리스트를 반환하는 메서드
	public List listMembers() {
		List list = new ArrayList();
		String query = "select * from t_member order by joinDate desc";
		try(Connection con = dataFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery()){
			
			while(rs.next()) {
				MemberBean vo = new MemberBean(rs.getString("id"), 
											   rs.getString("pwd"),
											   rs.getString("name"), 
											   rs.getString("email"));
				Date joinDate = rs.getDate("joinDate");
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean addMember(MemberBean memberBean) {
		boolean result = true;
		
		// 중복된 id가 존재한다면 아이디를 추가하지 않고 반환
		if(isDuplicated(memberBean.getId())) {
			result = false;
			return result;
		}
		String query = "insert into t_member(id, pwd, name, email) values(?, ?, ?, ?)";
		try (Connection con = dataFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query)){
			
			pstmt.setString(1, memberBean.getId());
			pstmt.setString(2, memberBean.getPwd());
			pstmt.setString(3, memberBean.getName());
			pstmt.setString(4, memberBean.getEmail());
			
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean isDuplicated(String id) {
		boolean result = false;
		
		String query = "select count(*) as result from t_member where id = ?";
		
		try(Connection con = dataFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query)){
			
			pstmt.setString(1, id);
			
			try(ResultSet rs = pstmt.executeQuery()){
				// 결과표의 첫 행으로 이동
				rs.next();
				// result 열의 값을 boolean 으로 꺼내 저장
				result = rs.getBoolean("result");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
