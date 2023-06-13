package edu.java.list04;

public class User {
	// fields:
	private String id;
	private String password;
	// constructor
	public User() {};
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}
	// getters setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	// toString() Override
	@Override
	public String toString() {
		String s = String.format("id: %s, password: %s", id, password);
		return s;
	}
}
