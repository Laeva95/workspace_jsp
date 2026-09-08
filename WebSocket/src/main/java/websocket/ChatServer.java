package websocket;

// 입출력 예외를 사용하기 위한 클래스
import java.io.IOException;
// Set을 동기화 처리하는 유틸 클래스
import java.util.Collections;
// 실제 저장소 역할을 하는 HashSet 클래스
import java.util.HashSet;
// 중복으로 저장을 허용하지 않는 Set 인터페이스
import java.util.Set;
// 클라이언트 연결이 끊길 때 호출되는 메소드를 표시하는 어노테이션
import javax.websocket.OnClose;
// 통신 중 예외가 발생했을 때 호출되는 메소드를 표시하는 어노테이션
import javax.websocket.OnError;
// 클라이언트가 보낸 메세지를 받을 때 호출되는 메소드를 표시하는 어노테이션
import javax.websocket.OnMessage;
// 클라이언트가 접속했을 때 호출되는 메소드를 표시하는 어노테이션
import javax.websocket.OnOpen;
// 클라이언트 한 명의 연결 정보를 담고 있는 객체
import javax.websocket.Session;
// 웹소켓 서버의 엔드포인트를 지정하는 어노테이션
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/ChatingServer")
public class ChatServer {
	// 현재 접속중인 모든 클라이언트를 저장하기 위한 변수
	// synchronizedSet: 여러 스레드가 동시에 접근해도 값이 변경되지 않도록 동기화 처리된 Set 컬렉션을 생성
	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
	
	// 클라이언트가 접속했을 때 호출되는 메소드
	// Session: 접속한 클라이언트의 연결 정보를 담고 있는 객체
	@OnOpen
	public void onOpen(Session session) {
		// 클라이언트가 접속하면 Session 객체를 Set에 추가하고
		// 현재 접속중인 모든 클라이언트에게 접속한 클라이언트의 세션 아이디를 전송
		clients.add(session);
		
		// session.getId(): 톰캣이 접속 순서대로 부여하는 문자열
		System.out.println("[웹 소켓 연결]: " + session.getId() + "님이 접속했습니다.");
	}
	// 클라이언트가 메세지를 보내는 순간 호출되는 메소드
	// String: 클라이언트가 보낸 메세지
	// Session: 메세지를 보낸 클라이언트의 연결 정보를 담고 있는 객체
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		// 메세지를 보낸 사람의 id와 메세지 내용 확인
		System.out.println("[메세지 전송]: " + session.getId() + "님이 보낸 메세지: " + message);
		
		// synchronized: 반복문이 실행되는 동안 다른 스레드가 Set에 접근하지 못하도록 동기화 처리
		// 반복 도중 접근/종료 발생 시 오류 발생 가능
		synchronized (clients) {
			// Set 배열에 저장된 클라이언트를 하나씩 꺼내서 반복
			// Session: 클라이언트 한 명의 연결 정보를 담고 있는 객체
			for(Session client : clients) {
				// 메세지를 보낸 session 객체와 반복문에서 꺼낸 client 객체가 같지 않으면 메세지를 전송
				if(!client.equals(session)) {
					// getBasicRemote(): 동기화 방식 전송 객체를 얻는 메소드
					// sendText(): 클라이언트에게 메세지를 전송하는 메소드
					client.getBasicRemote().sendText(message);
				}
			}
		}
	}
	
	// 클라이언트가 채팅창을 닫거나 연결이 끊겼을 경우 호출되는 메소드
	// Session: 연결이 끊긴 클라이언트의 연결 정보를 담고 있는 객체
	@OnClose
	public void onClose(Session session) {
		// 접속이 끊긴 클라이언트의 Session 객체를 Set에서 제거
		// 제거하지 않으면 접속이 끊긴 클라이언트에게도 메세지 전송을 시도하여 예외 발생
		// remove(): Set 배열에서 특정 객체를 제거하는 메소드
		clients.remove(session);
		
		System.out.println("[웹 소켓 종료]: " + session.getId() + "님이 접속을 종료했습니다.");
	}
	// 클라이언트 통신 중 예외가 발생하면 호출되는 메소드
	// Throwable: 예외 정보를 담고 있는 객체
	@OnError
	public void onError(Throwable e) {
		System.out.println("[웹 소켓 에러]: " + e.getMessage());
		e.printStackTrace();
	}
}
