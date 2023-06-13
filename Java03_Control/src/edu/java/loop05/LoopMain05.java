package edu.java.loop05;

public class LoopMain05 {

	public static void main(String[] args) {
		// 1 ~ 10 정수들을 오름차순으로 한 줄에 출력
		for (int i = 1 ; i <= 10 ; i ++ ) {
			System.out.print(i + "\t");
		}
		
		System.out.println();
		
		// while 반복문
		int n = 1;
		while ( n <= 10 ) {
			System.out.print( n + "\t");
			n++; 
		}
		
		System.out.println();
		System.out.println("----------");
		
		// 출력 결과: 1 3 5 7 9
		
		for (int a = 1 ; a <= 10 ; a += 2) {
			System.out.print( a + "\t" );
		}
		
		System.out.println();
		
		int b = 1;
		while ( b <= 10 ) {
			System.out.print( b + "\t" );
			b += 2;
		}
		
		System.out.println();
		
		int c = 1;
		while ( c <= 5 ) {
			System.out.print( c * 2 - 1 + "\t" );
			c++;
		}
		
		System.out.println();
		
		n=1;
		while ( n<10 ) {
			if ( n % 2 == 1 ) {
				System.out.print (n +"\t");
			}
			n++;
		}

		System.out.println();
		

	}

}
