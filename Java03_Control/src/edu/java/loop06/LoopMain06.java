package edu.java.loop06;

public class LoopMain06 {

	public static void main(String[] args) {
		// do-while 반복문
		// do-while문은 반복 여부를 검사하기 전에 무조건 블록을 한 번 실행함!
		// for문과 while문은 블록을 실행하기 전에 반복 여부를 먼저 검사하고, 조건이 참이면 블록을 실행.
		int n = 1;
		do {
			System.out.print( n + "\t");
			n++;
		} while (n <= 10);

		System.out.println();
		System.out.println("----------");
		
		int h = 1;
		do {
			System.out.print(h +"\t");
			h += 2;
		} while (h <= 10);
		
		System.out.println();
		System.out.println("----------");
		
		n = 1;
		while (n > 5) { // 반복 여부를 검사하고 참이면 출력, 그러므로 출력문 없음.
			System.out.print(n + "\t");
			n++;
		}
		System.out.println();

		System.out.println();
		System.out.println("----------");
		
		n = 1;
		do { // 출력한 후 반복여부 검사, 그러므로 1은 출력됨.
			System.out.print(n + "\t");
			n++;
		} while (n > 5);
		System.out.println();
		
		
		
		
	}	

}
