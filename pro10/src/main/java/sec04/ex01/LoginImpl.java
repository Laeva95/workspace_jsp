package sec04.ex01;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;


// 아이디와 비밀번호 저장
// 객체가 메모리에 등록되고 해제되는 순간을 감지해서 접속자 수를 증감
@WebListener
public class LoginImpl implements HttpSessionBindingListener {
		String user_id;
		String user_pw;
		
		static int total_user = 0;		// 현재 접속자 수를 저장할 변수
		public LoginImpl() {};
		public LoginImpl(String id, String pw){
			user_id = id;
			user_pw = pw;
		}
		@Override
		public void valueBound(HttpSessionBindingEvent event) {
			System.out.println("사용자 접속");
			total_user++;
		}
		@Override
		public void valueUnbound(HttpSessionBindingEvent event) {
			System.out.println("사용자 접속 해제");
			total_user--;
		}
}
