package edu.java.loop10;

import java.util.Scanner;

public class LoopMain10 {

	public static void main(String[] args) {
		boolean run = true; // 프로그램을 계속 실행할 지, 종료할 지를 결정할 변수.
		int balance = 0; // 은행 예금 잔고.
		Scanner scanner = new Scanner(System.in);
		
		while (run) {
			System.out.println("----------------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("----------------------------------------");
			System.out.print("선택 > ");
			
			int menu = scanner.nextInt();			
			switch (menu) {
			case 1:
				System.out.print("예금액을 입력>>> ");
				int input = scanner.nextInt();
				balance += input;
				System.out.println("예금액 = " + input + "원");
				break;
			case 2:
				System.out.print("출금액을 입력>>> ");
				int output = scanner.nextInt();
				balance -= output; 
				System.out.println("출금액 = " + output + "원");
				break;
			case 3:
				System.out.println("잔고 = " + balance + "원");
				break;
			case 4:
				run = false; //while문을 종료
				break; // switch문을 종료
			default:
				System.out.println("오류. 다시 선택할 것");
			}
			
			
		}
		System.out.println("프로그램 종료"); 

	}

}
