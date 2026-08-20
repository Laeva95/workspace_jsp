package sec02.ex01;

import java.sql.Date;	// 데이터베이스의 날짜 정보를 담기 위한 클래스

// 계산이나 판단 없이 getter, setter 메소드만 갖는 클래스

// 1. 테이블의 열과 같은 이름, 같은 자료형으로 변수를 선언
// 2. 변수당 getter / setter 메소드를 하나씩 생성
public class MemberVO {
	/*
	 	t_member 	테이블
		ID       NOT NULL VARCHAR2(10) 
		PWD               VARCHAR2(10) 
		NAME              VARCHAR2(50) 
		EMAIL             VARCHAR2(50) 
		JOINDATE          DATE   
	 */
	
	// 1단계. 변수 선언
	// private 접근 제어자로 변수 선언. 외부에서 접근하지 못하도록 캡슐화를 위함
	// 직접 접근을 막고 getter / setter 메소드를 사용하면 잘못된 접근을 방지 할 수 있음
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
	
	// 기본 생성자
	public MemberVO() {
		System.out.println("MemberVO 클래스의 기본 생성자 호출");
	}
	
	// 2단계. getter / setter 메소드 생성
	public String getId() {					// id
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPwd() {				// pwd
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {				// name
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {				// email
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinDate() {				// joinDate
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	
}
