package edu.java.loop01;

public class LoopMain01 {

	public static void main(String[] args) {
		// 반복문
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);

		System.out.println("----------------");
		
		// for 반복문
		for (int n=1; n <= 5; n++) { // n=1 ; n이 5보다 작음 > print ; n이 2로 증가 // n=2 ; n이 5보다 작음 > print ; n이 3으로 증가 >> 반복
			System.out.println(n);
		}
		
		// 증가 연산자(++)/감소 연산자(--): 변수의 값을 1 증가/감소 >> 단항 연산자 (하나의 항만을 사용)
		// 증가/감소 연산자는 변수 앞 또는 뒤에 사용. (예) x++, ++x
		
		System.out.println("----------------");
		
		// 10부터 1까지 내림차순으로 출력.
		for (int i=10; i > 0; i--) {
			System.out.println(i);
		}
		
		// 지역 변수(local variable): 메서드 블록({}) 안에서 선언한 변수.
		// 지역 변수는 선언된 위치에서부터 그 변수가 속한 블록({}) 안에서만 사용 가능.
		// for () 구문에서 선언하는 변수는 for 블록 안에서만 사용 가능한 지역 변수.
		
		System.out.println("----------------");
		
		int x = 1;
		{	
			int y = 2;
			System.out.println("x = " +x);
			System.out.println("y = " +y);
		}
		//System.out.println("x = " +x); 
//		System.out.println("y = " +y); 
//		y는 블록 안에서만 사용가능한 지역 변수.
//		 블록을 벗어나면 자동으로 사라지는 변수
//		주석 처리 Ctrl+/ 커서가 있는 줄(또는 선택된 줄) 주석 토글
		
	}

}
