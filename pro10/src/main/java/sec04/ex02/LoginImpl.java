package sec04.ex02;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


// 아이디와 비밀번호 저장
// 객체가 메모리에 등록되고 해제되는 순간을 감지해서 접속자 수를 증감
@WebListener
public class LoginImpl implements HttpSessionListener {
		String user_id;
		String user_pw;
		
		static int total_user = 0;		// 현재 접속자 수를 저장할 변수
		public LoginImpl() {};
		public LoginImpl(String id, String pw){
			user_id = id;
			user_pw = pw;
		}
		
		// HttpSession 객체가 생성될 때 호출되는 메소드
		@Override
		public void sessionCreated(HttpSessionEvent se) {
			System.out.println("HttpSession 객체 메모리 생성");
			total_user++;
		}
		// HttpSession 객체가 사라질 때 호출되는 메소드
		@Override
		public void sessionDestroyed(HttpSessionEvent se) {
			System.out.println("HttpSession 객체 메모리 해제");
			total_user--;
		}
}
