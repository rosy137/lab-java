package edu.java.singleton;

public class SingletonMain {

	public static void main(String[] args) {
		// Captain 타입 변수 선언, Captain 타입 객체 생성, 객체(주소값) 저장.
//		Captain captain = new Captain << The constructor Captain() is not visible
		// Captain 생성자는 private으로 선언되어 있기 때문에 호출할 수 없지만
		// -> 힙에는 아무것도 없는 null 상태, 인스턴스는 만들어진 상태
		Captain captain1 = Captain.getInstance(); // 힙에 Captain.name 주소값 저장 > 스택에 위치값 지역변수 Captain1에 참조변수로 저장
		// public static으로 선언된 메서드는 호출할 수 있음.
		System.out.println(captain1.getName());
		
		Captain captain2 = Captain.getInstance();
		System.out.println(captain2.getName());
		
		captain2.setName("아이언맨");
		System.out.println(captain2.getName());
		System.out.println(captain1.getName()); // 객체가 하나니까
		
	}

}
