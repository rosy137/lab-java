package edu.java.loop09;

public class Practice {

	public static void main(String[] args) {
		
		int center = 10;
		for(int i = 0; i <= 10; i++ ) {
			for (int j = 0; j <= center *2 ; j++) {
				if (j == center) {
					System.out.print("*"); // center에 * 출력
				} else if((center - i) <= j && (center + i) >= j ) {
					// center - i => 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0
					// 작거나 같을 때 (j가 0일 때 부터 * 1, 2, 3, ...개 출력)
					// j		  =>  0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11 ~ 20
					// &&
					// center + i => 10,11,12,13,14,15,16,17,18,19,20
					// 크거나 같을 때 (j가 10일 때 부터 * 11, 10, 9, ...개 출력)
					// j		  =>  0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11 ~ 20
				System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		for(int i = 0; i <= 10; i++) {
			for(int j = 0; j <= center*2 ; j++) {
				if((center - i) >= j || (center + i) <= j) {
					// center - i => 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0
					// 크거나 같을 때 (j가 0일 때 부터 * 10, 9, 8, ...개 출력)
					// j		  =>  0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11 ~ 20
					// ||
					// center + i => 10,11,12,13,14,15,16,17,18,19,20
					// 작거나 같을 때 (j가 10일 때 부터 * 11, 10, 9, ...개 출력)
					// j		  =>  0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11 ~ 20
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

}
