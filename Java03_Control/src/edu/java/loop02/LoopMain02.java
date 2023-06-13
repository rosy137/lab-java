package edu.java.loop02;

public class LoopMain02 {

	public static void main(String[] args) {
		// 복합 할당 연산자: +=, -=, *=, /=, %=, ...
		int x = 10;
//		x = x + 2;
		x += 2;
		System.out.println("x = " + x);
		
		// System.out.println: print line. 출력하고 줄바꿈.
		System.out.println("test");
		
		// System.out.print: 출력하고 줄바꿈이 일어나지 않음. 출력이 끝난 위치에 커서가 위치.
		System.out.print("test1");
		System.out.print("test2");
		System.out.println("test3");
		System.out.println("---------------------");
		
		// 0 2 4 6 8 10
		// 0 ~ 10 짝수들을 한 줄에 출력
		for (int y1 = 0; y1 <= 10; y1 += 2) {
			System.out.print(y1+ " ");
		}
		
		System.out.println();
		
		for (int y2 = 0; y2 <= 5; y2++) {
			System.out.print((y2 * 2) + " ");
		}
		
		System.out.println();
		
		for (int y3 = 0; y3 <= 10; y3++) {
			if (y3 % 2 == 0) {
				System.out.print(y3 + " ");
			}
		}
		
		System.out.println();
		System.out.println("---------------------");
		
		// 1 3 5 7 9 
		// 10 이하의 홀수들을 한 줄에 출력
		for (int z1 = 1; z1<=10; z1+=2) {
			System.out.print(z1+" ");
		}
		
		System.out.println();
		
		for (int z2 = 0; z2 <= 4; z2++) {
			System.out.print(((z2 * 2) + 1) + " ");
		}
		
		System.out.println();
		
		for (int z3 = 0; z3 <=10; z3++) {
			if (z3 % 2 == 0 ) {
			} else {
				System.out.print(z3 + " ");
			}
		}
		
		System.out.println();
		System.out.println("---------------------");
				
	}

}

