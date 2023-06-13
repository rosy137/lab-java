package edu.java.modifier03;

public class User {
	// field
	private int userNo;
	private String userId;
	private String password;
	
	// constructor
	public User(int userNo, String userId, String password) {
		this.userNo = userNo;
		this.userId = userId;
		this.password = password;
	}
	
	// method
	// getter 
	public int getUserNo() {
		return this.userNo;
	}
	public String getUserId() {
		return this.userId;
	}
	public String getPassword() {
		return this.password;
	}
	
	// setter
	public void setUserNo(int userNo) {
		if (userNo >= 0) {
			this.userNo = userNo;
		} else { 
			System.out.print("ERROR\n");
		}
	}
	
	public void setUserId(String userId) {
		System.out.print("아이디 변경 불가\n");
		
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
