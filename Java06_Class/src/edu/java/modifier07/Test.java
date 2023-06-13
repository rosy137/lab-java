package edu.java.modifier07;

public class Test {
	int x; // 인스턴스 필드 << 생성자 호출해야 힙에 만들어짐(static은 호출되기 전에 이미 만들어짐)
	static int y; // static 필드
	
	// 인스턴스 메서드
	public void printInfo() {
		System.out.println("---instance method---");
		System.out.println("x = " + this.x);
		System.out.println("y = " + Test.y); //<< 클래스 이름을 사용해서 사용하는 멤버
		//-> 인스턴스 메서드는 static 필드/메서드 사용할 수 있음.
		System.out.println("---------------------");
	}
		
	public static void printStaticInfo() {
		System.out.println("----static method----");
//		System.out.println("x = " + x); 
//		<< Cannot make a static reference to the non-static field x
//		<< static 메서드에서 인스턴스 필드/메서드 사용할 수 없음.
		System.out.println("y = " + y);
		System.out.println("---------------------");
		
		
	}
}
