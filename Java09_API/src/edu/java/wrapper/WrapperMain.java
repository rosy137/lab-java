package edu.java.wrapper;

import java.math.BigDecimal;

// Wrapper 클래스: 자바의 기본 타입의 값 하나를 저장하는(감싸는) 클래스.
// 자바의 기본 타입: boolean, byte, short, int, long, char, float, double 
// wrapper: Boolean, Byte, Short, Integer, Long, Character, float, Double
// wrapper 클래스들은 java.lang 패키지에 포함되어 있기 때문에 import 문장 생략.
// wrapper 클래스 사용 목적:
// 1. 기본 데이터 타입의 값을 이용하는 메서드를 제공하기 위해서.
// 2. 상속/다형성과 같은 객체지향 개념들을 이용하기 위해서.
// 3. generic 클래스를 사용하기 위해서.

public class WrapperMain {
	public static void main(String[] args) {
		int x = 1; // 기본 타입(primitive type) - 메서드 없음.
		
		// Integer 타입의 객체 생성 = 생성자는 권장하지 않고, static 메서드 사용을 권장.
		// 동그라미 아이콘에 선 있는 것 deprecated 자바가 업그레이드 되면서 사라질 수 있는 
		Integer number1 = Integer.valueOf(1); // boxing(wrapping): int -> Integer 객체
		System.out.println(number1);
		
		Integer number2 = Integer.valueOf("123"); // String -> Integer 객체
		System.out.println(number2);
		
		// auto-boxing(wrapping)
		Integer number3 = 1; // Integer.valueOf(1) 코드가 자동으로 실행
		
		int y = number3.intValue(); // unboxing: Integer 타입 객체에서 int 타입 값을 추출.
		System.out.println(y);
		
		// auto-unboxing: Integer 타입 객체가 자동으로 int 타입 값으로 변환
		int z = number3; // number3.intValue() 코드가 자동으로 실행.
		
		int add = number1 + number2;
		System.out.println(add);
		
		int num = Integer.parseInt("100"); // String -> int
		
		// float, double 타입은 소수점 이하의 오차가 생길 수 있음. 
		double d1 = 1.1;
		double d2 = 0.9;
		System.out.println(d1-d2); 
		
		// 실수 타입의 오차를 원하는 수준까지 작게 줄여서 계산에 사용할 수 있는 클래스 // Wrapper 클래스 아님
		BigDecimal big1 = new BigDecimal("1.1");
		BigDecimal big2 = new BigDecimal("0.9");
		System.out.println(big1);
		System.out.println(big1.subtract(big2));
		// BigDecimal 타입 객체는 메서드를 호출해서 산술 연산(+, -, *, /)을 수행
		// BigDecimal 클래스 기본 타입의 wrapper 클래스가 아니기 때문에 auto-boxing/unboxing 기능이 없음.
		
		
	}
}
