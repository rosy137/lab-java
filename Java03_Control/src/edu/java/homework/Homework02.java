package edu.java.homework;

public class Homework02 {

	public static void main(String[] args) {
		// 369 게임 출력
		// 3, 6, 9 는 *으로, 10에서 끊어지게 100까지 출력 
		// bonus++ 33, 66, 99는 **으로 출력
		
		// 둘 다의 경우 **
		// 10으로 나눈 나머지가 3, 6, 9 인 경우 *
		// 10으로 나눈 몫이 3, 6, 9 인 경우 *
		
		for (int n = 1 ; n <= 100 ; n ++) {
			
			if ( ( n % 10 == 3 || n % 10 == 6 || n % 10 == 9 ) && ( n / 10 == 3 || n / 10 == 6 || n / 10 == 9 ) ) {
				System.out.print("**\t");
			} else if ( n % 10 == 3 || n % 10 == 6 || n % 10 == 9 || n / 10 == 3 || n / 10 == 6 || n / 10 == 9) {
				System.out.print("*\t");
			} else {
				System.out.print(n + "\t");
			}
			if ( n % 10 == 0) {
				System.out.println();
			}
		}	
		System.out.println("----------method1----------");
		System.out.println("");
		for ( int h = 1; h <= 100; h ++ ) {
			int h1 = h % 10; // n을 10으로 나눈 나머지 
			int h10 = h / 10; // n을 10으로 나눈 몫
			// 숫자를 출력할 것인 지, "*"를 출력할 것인 지.
			
			boolean condition1 = (h1 == 3) || (h1 == 6) || (h1 == 9);
			// 1의 자리 숫자가 3 또는 6 또는 9
			boolean condition10	= (h10 == 3) || (h10 == 6) || (h10 == 9);
			// 10의 자리 숫자가 3 또는 6 또는 9  
			
			if ( condition1 && condition10 ) {
				System.out.print("**\t");
			} else if ( condition1 || condition10 ) {
				System.out.print("*\t");
			} else {
				System.out.print(h + "\t");
			}
			
			// 줄바꿈을 할 것인 지, 아닌지
			if ( h % 10 == 0 ) {
				System.out.println();
			}
		}
		
		
		
		
	}

}
