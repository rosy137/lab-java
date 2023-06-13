package edu.java.array03;

public class ArrayMain03 {

	public static void main(String[] args) {
		// Ex 1.
		// 정수(int) 10개를 저장할 수 있는 배열 선언.
		// 배열에 순서대로 0, 2, 4, 6, 8, 10, ..., 18을 저장
		// 배열의 원소들을 한 줄로 출력
		
		int[] teen = new int[10];
		for (int x = 0; x < teen.length ; x++ ) {
			teen[x]= x * 2;
			System.out.print(teen[x] + " "); // 걍 출력
		}
//		teen[0] = 0;
//		teen[1] = 2;
//		teen[2] = 4;
//		teen[9] = 18;
//		teen[x] = x * 2 ^^		
		System.out.println();		
		for(int x : teen) { // for-each로 출력
			System.out.print(x + " ");
		}
		// for - each 구문은 배열 내 원소 변경에 영향을 미치지 않는다. 조건 선언은 따로 
		
		System.out.println();
		// Ex 2.
		// boolean 10개를 저장할 수 있는 배열 선언,
		// 배열에 순서대로 true, false, ..., false를 저장
		// 배열의 원소들을 한 줄로 출력
		
		boolean[] tf = new boolean[10];
		for (int i = 0; i < tf.length ; i++) {
			if(i % 2 == 0) {
				System.out.print(!tf[i] + " ");
			} else {
				System.out.print(tf[i] + " ");
			} 
		} // boolean[] 안에 들어있는 값이 다 false가 나오게 됨. boolean의 기본값은 false!¡
		System.out.println();
		
		boolean[] tf1 = new boolean[10];
		for (int i = 0; i < tf1.length ; i++) {
			if(i % 2 == 0) {
				tf1[i] = true;
			} else {
				tf1[i] = false; // boolean의 기본값이 false이므로 생략가능함.
			} 
		}
		for (boolean b : tf1) {
			System.out.print(b + " ");
		}
		System.out.println();
		
		
	}

}
