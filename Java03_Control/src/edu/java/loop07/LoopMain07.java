package edu.java.loop07;

public class LoopMain07 {

	public static void main(String[] args) {
		// 2중 반복문
		
		for (int dan = 1 ; dan < 10 ; dan ++) {
				System.out.printf("---%d단---\n", dan);
				for (int one = 1; one < 10; one++) {
					System.out.printf("%d x %d = %d\n", dan, one, dan * one); //%d 정수 %f 실수 %s 문자열
				}
			}
		
		System.out.println("\n==========\n");
		// while문을 사용한 구구단 출력
		int dan1 = 1;
//		int one1 = 1; // 변수 선언 위치 확인 (방법1: 선언)
		while ( dan1 < 10 ) {
			System.out.printf("---%d단---\n", dan1);
//				one1 = 1; // 변수 선언 위치 확인 (방법1: 재선언/끝)
				int one1 = 1; // 변수 선언 위치 확인 (방법2: 선언/끝)
				while (one1 < 10) {
					System.out.printf ("%d x %d = %d\n", dan1, one1, dan1 * one1);
					one1 ++;
				} // end for (one1)
			dan1 ++;
		} // end for (dan1)
		
		System.out.println("\n==========\n");
		// do-while을 사용한 구구단 출력
		int dan2 = 1;
		do {
			System.out.printf("---%d단---\n", dan2);
//			dan2 ++; // 반복 위치 확인
			int one2 = 1;
			do {
				System.out.printf("%d x %d = %d\n", dan2, one2, dan2*one2);
				one2 ++;
			} while (one2 < 10);
			dan2 ++; // 반복 위치 확인
		} while (dan2 < 10);
		
		
		System.out.println("\n:)\n");

	}

}
