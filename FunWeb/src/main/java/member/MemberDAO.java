package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private DataSource dataSource;
	
	public MemberDAO() {
		try {
		Context ctx = new InitialContext();
		
		Context envCtx = (Context)ctx.lookup("java:/comp/env");
		
		dataSource = (DataSource)envCtx.lookup("jdbc/jspdb");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isExisted(MemberVO memberVO) {
		boolean result = false;
				
		String id = memberVO.getId();
		String pass = memberVO.getPass();
		
		String query = "SELECT CASE WHEN COUNT(*) = 1 THEN 'true' ELSE 'false' END AS result"
					+ " FROM t_member"
					+ " WHERE id = ? AND pwd = ?";
		
		try(Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query)){
			
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			try(ResultSet rs = pstmt.executeQuery()){
				rs.next();
				
				// AS result 로 설정한 열 이름을 매개변수로 전달
				result = rs.getBoolean("result");
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}
