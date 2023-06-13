package edu.java.inheritance06;

import java.util.Objects;

public class Point {
	// field
	private int x;
	private int y;
	
	// constructor
	// (1) 기본 생성자
	public Point() {};
	
	// (2) args 2개인 생성자
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// getters & setters
	public int getX() {
		return this.x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return this.y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	// toString override " Point(x=0, y=0)"
	@Override
	public String toString() {
//		return "Point(x = " + this.x + ", y = " + this.y + ")";
		String s = String.format("Point(x=%d, y=%d)", this.x, this.y); //printf와 포맷 동일
		return s;
	}
	
//	객체가 같은지 다른지 재정의 하기 위해서
	@Override
	// hashCode() 메서드는 반드시 int 타입을 리턴.
	// equals()가 true를 리턴하는 두 객체는 hashocde()의 리턴값이 같아야 함.
	public int hashCode() { 
		return Objects.hash(x, y);
	}
	
//	@Override // 이클립스 자동 생성
//	public boolean equals(Object obj) { 
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass()) // 클래스 이름이 다르면
//			return false;
//		// 클래스 이름이 같으면 casting 할 수 있음.
//		Point other = (Point) obj;
//		return x == other.x && y == other.y; // 객체가 가진 주소값이 달라도 객체의 값이 같으면 같은 것이라고 하자~
//	}
	
	@Override // 위에 메서드랑 같은 내용임
	public boolean equals(Object obj) {
		boolean result = false;
		
		if (obj instanceof Point) { // obj가 Point 타입의 인스턴스이면
			Point other = (Point) obj; // 안전한 타입 변환(casting)
			result = (this.x == other.x) && (this.y == other.y);
		}
		return result;
	}
	
	
	
}
