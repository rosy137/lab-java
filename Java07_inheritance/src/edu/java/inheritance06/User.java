package edu.java.inheritance06;

import java.util.Objects;

public class User {
	//field
	private String userId;
	private String password;
	
	//constructor
	public User() {}
	public User(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
	
	//getters & setters
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	
	//toString() override: "User(userId=..., password+...)"
	@Override
	public String toString() {
		String s = String.format("User(userId = %s, password  = %s)", userId, password);
		return s;
//		return "User(userId = " + userId + ", password = " + password + ")";
	}


	
	// hashCode() override
	@Override
	// equals()의 리턴 값이 true이면 hashCode()의 리턴 값이 같아야 한다.
	public int hashCode() {
//		return Objects.hash(userId);
		if (this.userId == null) { //*********null point exception 발생 안하도록
			return 0;
		} else {
			return this.userId.hashCode();
		}
	}
	
	// equals() override: 두 객체의 userId가 같으면 T, 그렇지 않으면 F
	public boolean equals(Object obj) {
		boolean result = false; // 초기화
		
		if (obj instanceof User) { //객체 obj가 User 타입의 인스턴스 이면
			User other = (User) obj; // 새로운 User 타입 변환 
//			result = this.userId == other.userId; //<< ==은 기본 타입에만 사용 >> 왜 안되는지 StringTest에서 설명
			if (this.userId != null && this.userId.equals(other.userId)) { //<- 클래스비교에는 equals 사용해야함
				result = true;
			}
		}
		return result;
	}
	
	
	
}
