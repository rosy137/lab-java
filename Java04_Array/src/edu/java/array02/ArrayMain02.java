package edu.java.array02;

public class ArrayMain02 {

	public static void main(String[] args) {
		// 문자열 3개를 저장할 수 있는 배열(names)을 선언, 초기화.
		String[] names = new String[3];
		
		// 배열 names에 문자열을 저장.
		names[0] = "이찬희";
		names[1] = "지대한";
		names[2] = "김다훈";
		
		// 배열 names의 내용을 한 줄로 출력.
		// (1) for 구문
		// (2) for-each 구문
		
		for (int x = 0 ; x < names.length ; x++) {
			System.out.print(names[x] + " ");
		}
		System.out.println();
		for (String x : names) {
			System.out.print(x + " ");
		}
		System.out.println();
		
		String[] subjects = {"Java", "SQL", "HTML", "JavaScript"};
		for ( String s : subjects) {
			System.out.print(s + " ");
 		}
		System.out.println();
		
		
	}

}
