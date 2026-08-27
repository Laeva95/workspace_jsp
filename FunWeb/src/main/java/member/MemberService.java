package member;

public class MemberService {
	
	private MemberDAO memberDAO;
	
	public MemberService() {
		memberDAO = new MemberDAO();
	}
	
	public boolean login(MemberVO memberVO) {
		boolean result = memberDAO.isExisted(memberVO);
		
		return result;
	}
}
