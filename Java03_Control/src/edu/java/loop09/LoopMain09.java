package edu.java.loop09;

import java.util.Random;

public class LoopMain09 {

	public static void main(String[] args) {
		/*
		 * 문제 1. 아래와 같이 출력하세요.
		 *
		 **
		 ***
		 ****
		 *****
		 */
		// Ctrl+Shift+F: 코드 포맷팅(자동정렬)

		for (int i = 1; i <= 5; i++) { // 라인의 수
			for (int j = 1; j < 1 + i; j++) { // "*" 프린트 할 횟수
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		int line = 1; // 라인 넘버
		while (line <= 5) { 
			int count = 1; // * 출력 횟수
			while (count <= line) {
				System.out.print('*');
				count ++;
			}
			System.out.println();
			line++;
		}
		
		System.out.println("\n----------\n");

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= 5 - i; j++) {
				if (j < 5 - i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}

		System.out.println("\n----------\n");
		/*
		 * 문제 2. 아래와 같이 출력하세요.
		 *
		 **
		 ***
		 ****
		 *****
		 ****
		 ***
		 **
		 *
		 */

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		// 쌤거
		for (int x = 4; x >= 1; x--) {
			for (int y = 1 ; y <= x ; y++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int x = 1; x <= 4; x++) {
			for (int y = 4 ; y >= x ; y--) {
				System.out.print("*");
			}
			System.out.println();
		}
		//djfuqj :)
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int x = 6; x <=9; x++) {
			for (int y = 4 ; y >= x - 5 ; y--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int x = 1 ; x <=9 ; x ++) {
			if (x <=5) { // *를 하나씩 늘려나감.
				for (int y = 1; y < x + 1 ; y ++) {
					System.out.print("*");
				}
			} else { // *를 하나씩 줄여감.
				for (int y = 4; y >= x - 5; y--) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	
		System.out.println("\n----------\n");

		/*
		 * 문제 3. 주사위 2개를 던졌을 때 나오는 주사위 눈을 (x, y) 형식으로 출력하세요. 
		 * 두 눈의 합이 5가 되면 출력을 멈추세요. 
		 * 힌트: Random 타입의 nextInt(start, end) 메서드를 사용. 
		 * 힌트: 무한 루프: for (;;) {...}, while (true) {...}  
		 * 출력 결과 예시:(2, 4) (6, 1) (3, 3) (4, 1)
		 */

		// 난수 2개
		Random random = new Random();

		while (true) {
			int dice1 = random.nextInt(6) + 1;
			int dice2 = random.nextInt(1, 7);
			System.out.printf("(%d, %d)\n", dice1, dice2);
			if (dice1 + dice2 == 5) {
				break;
			}
		}

		System.out.println("\n----------\n");

		for (;;) {
			int dice1 = random.nextInt(6) + 1; // 그냥 (숫자)하면 0이 출력됨
			int dice2 = random.nextInt(1, 7); // 1 <= random < 7
			System.out.printf("(%d, %d)\n", dice1, dice2);
			if (dice1 + dice2 == 5) {
				break;
			}
		}

	}

}