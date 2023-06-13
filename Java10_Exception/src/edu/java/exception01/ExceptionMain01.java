package edu.java.exception01;

import java.util.Scanner;

// 오류(error) vs 예외(exception)
// error의 종류:
//	1. 시스템 에러: (예) OOM(Out-Of-Memory, 메모리 부족) -> 수정 불가능. 수정 힘듦.
//	2. 컴파일 에러: 문법 오류 - 반드시 수정!
// 	3. 논리적인 오류: 프로그램이 정상적으로 컴파일되고 실행/종료가 되지만, 원하는 결과가 나오지 않는 경우.
//		-> 반드시 수정. 수정 힘든 경우가 많음
//	4. 예외(exception): 프로그램 실행 중에 발생할 수 있는 비정상적인 상황. -> 반드시 수정.
//		-> (1) if-else 구문
//		-> (2) try-catch 구문

public class ExceptionMain01 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수를 입력하세요 >>> ");
		int x = Integer.parseInt(sc.nextLine());

		System.out.print("두번째 정수를 입력하세요 >>> ");
		int y = Integer.parseInt(sc.nextLine());
		
//		System.out.println("x / y = " + x / y);
		
//		첫번째 정수를 입력하세요 >>> 100
//		두번째 정수를 입력하세요 >>> 0
//		>>>>Exception<<<< in thread "main" java.lang.ArithmeticException: / by zero
//		at edu.java.exception01.ExceptionMain01.main(ExceptionMain01.java:25)
		
		if (y != 0) {
			System.out.println("x / y = " + x / y);
		} else {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		
		ExceptionMain01 app = new ExceptionMain01(); // static method > 객체 생성 필요 x 
		app.printlength(null);
		app.printlength("안뇽 좋은 아침이야");
		
	}
	
	private void printlength(String s) {
		if (s != null) {
			System.out.println(s + " length = " + s.length());
		} else {
			System.out.println("null의 length를 알 수 없음");
		}
	}
	
}
