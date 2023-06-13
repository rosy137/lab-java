package edu.java.modifier06;

// final 수식어: 최종적인. 변경할 수 없는.
// final 지역 변수: 변경할 수 없는 지역 변수. 상수(constant)/ 초기화 이후에는 값을 변경할 수 없는 변수.
// final 클래스 멤버(필드, 메서드): 변경할 수 없는 클래스 멤버.
// final 필드(멤버 변수)는 반드시 초기화하는 문장을 명시해야 함.
//	(1) 필드 선언과 동시에 값을 초기화.
//	(2) (argument를 갖는) 생성자를 사용해서 값을 초기화.
// final 클래스: 변경할 수 없는 클래스. 상속할 수 없는 클래스. 

public final class ModifierMain06 {
	
	private static final int VERSION = 1; // (1) 선언과 동시에 초기화
	
	private final int test; //(2) - 1. 초기화 되지 않아 오류 발생
	public ModifierMain06(int test) { // (2) - 2. 생성자를 사용해서 final 필드 초기화
		this.test = test;
	}

	public static final void main(String[] args) {
		final int x = 1; 
//		x = 2; // The final local variable x cannot be assigned. 
//		VERSION = 2; // The final field modifier06.VERSION cannot be assigned
	}

}
