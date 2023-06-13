package edu.java.inheritance06;

public class StringTest {
	public static void main(String[] args) {
		// 상수(constant): final로 선언된 변수
		// 리터럴(literal): 만들어진 값. 
		int x = 1;
		x = 100; // x 재할당
		
		final int x1 = 1; //-> x: 상수, 1: 정수 리터럴
//		x1 = 100; // final 선언된 x1 재할당 불가
		
		String s1 = "hello"; // s1: 변수, "hello": 문자열 리터럴 
		String s2 = "hello"; // s2: 변수, "hello": s1변수 생성하면서 힙에 저장된 문자열 리터럴 재활용// 스택에 호출되는 값의 주소가 같아진다.
		System.out.println(s1==s2);
		//-> true: JVM은 같은 문자열 리터럴은 두 번 생성하지 않음.
		
		String s3 = new String("hello"); // s3, 스택에 동일한 객체 하나 더 만듦 // 스택에 호출되는 값의 주소가 달라진다. 
		String s4 = new String("hello");
		System.out.println(s3==s4);
		//-> false: 생성자는 호출할 때마다 새로운 객체를 힙(heap) 메모리에 생성.
		System.out.println(s3.equals(s4)); 
		
	}

}
