package edu.java.homework;

import java.util.Random;
import java.util.Scanner;

public class Homework01 {

	public static void main(String[] args) {
		// 가위바위보 게임
		// 0 가위, 1 바위, 2 보
		// 컴퓨터 >> 난수, 나 >> scanner (ui 출력 할 것)
		// >>> 누가 이겼는지 결과를 출력
		
		Random random = new Random();
		int computer = random.nextInt(3);
		
		System.out.println("가위/바위/보 게임");
        System.out.println("-----------------");
        System.out.println("[0] 가위");
        System.out.println("[1] 바위");
        System.out.println("[2] 보");
        System.out.println("-----------------");
        System.out.print("선택>>>");
		
		Scanner scanner = new Scanner(System.in);
		int me = scanner.nextInt();
		
		System.out.println("computer = " + computer + " >><< me = " +me); // ctrl 누르고 클릭시 변수 선언 위치로 이동

		if (computer == 0) {
			System.out.println("컴퓨터는 '가위'를 냈습니다.");
		} else if (computer == 1) {
			System.out.println("컴퓨터는 '바위'를 냈습니다.");
		} else if (computer == 2) {
			System.out.println("컴퓨터는 '보'를 냈습니다.");
		}
		if (me == 0) {
			System.out.println("사용자는 '가위'를 냈습니다.");
		} else if (me == 1) {
			System.out.println("사용자는 '바위'를 냈습니다.");
		} else if (me == 2) {
			System.out.println("사용자는 '보'를 냈습니다.");
		}
		
		System.out.println();
		System.out.println("--------method0---------");
		if (computer == me) {
			System.out.println("비겼습니다.");
		} else if (computer == 0 && me == 1 || computer == 1 && me == 2 || computer == 2 && me == 0) {
			System.out.println("사용자가 이겼습니다.");
		} else if (computer == 1 && me == 0 || computer == 2 && me == 1 || computer == 0 && me == 2) {
			// 생략 가능
			System.out.println("컴퓨터가 이겼습니다.");
		} 
		
		System.out.println();
		System.out.println("--------method1---------");
		if (me == 0) {
			if(computer == 0) {
				System.out.println("비김");
			} else if (computer == 1 ) {
				System.out.println("컴 이김");
			} else {
				System.out.println("사용자 이김");
			}
		} else if (me == 1) {
			if(computer == 0) {
				System.out.println("사용자 이김");
			} else if (computer == 1 ) {
				System.out.println("비김");
			} else {
				System.out.println("컴 이김");
			}
		} else {
			if(computer == 0) {
				System.out.println("컴 이김");
			} else if (computer == 1 ) {
				System.out.println("사용자 이김");
			} else {
				System.out.println("비김");
			}
		}

		System.out.println();
		System.out.println("---------method2--------");
		if ( me == computer ) {
			System.out.println("비김");
		} else if (me == 0) {
			if ( computer == 1 ) {
				System.out.println("컴 이김");
			} else {
				System.out.println("사용자 이김");
			}
		} else if (me == 1) {
			if ( computer == 2 ) {
				System.out.println("컴 이김");
			} else {
				System.out.println("사용자 이김");
			}
		} else if (me == 2) {
			if ( computer == 0 ) {
				System.out.println("컴 이김");
			} else {
				System.out.println("사용자 이김");
			}
		}
		
		System.out.println();
		System.out.println("---------method3--------");
		if (computer == me) {
			System.out.println("비겼습니다.");
		} else if (computer == 0 && me == 1 || computer == 1 && me == 2 || computer == 2 && me == 0) {
			System.out.println("사용자가 이겼습니다.");
		} else {
			System.out.println("컴퓨터가 이겼습니다.");
		} 
		
		System.out.println();
		System.out.println("---------method4--------");
		int diff = me - computer;
		if (diff == 0) {
			System.out.println("TIE");
		} else if (diff == -2 || diff == 1) {
			System.out.println("user win");
		} else {
			System.out.println("com win");
		}
		
		
		
	}

}