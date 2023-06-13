package edu.java.conditional04;

public class ConditionalMain04 {

	public static void main(String[] args) {
		// 조건문과 논리 연산자ㅏ(&&, ||, !)
		// && // and  // 둘 다 참일 때
		int score = 50;
		if (score >= 0 && score <= 100) {
			System.out.println("결과값");
		} else {
			System.out.println("오류");
		}

		// || // or   // 둘 중 하나라도 참일 때
		if (score < 0 || score > 100) {
			System.out.println("오류");
		} else {
			System.out.println("결과값");
		}
		
		// !  // not  // 참과 거짓이 바뀜
		boolean running = true;
		if (running) {
			System.out.println("달리는 중...");
		} else {
			System.out.println("멈춤");
		}
		
		if (!running) {
			System.out.println("멈춤");
		} else {
			System.out.println("달리는 중...");
		}
		
		// 복합 // 대입
		// 증가 // 감소 
		// 삼항연산자 

	}

}
