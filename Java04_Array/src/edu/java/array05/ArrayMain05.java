package edu.java.array05;

import java.util.Random;

public class ArrayMain05 {

	public static void main(String[] args) {
//		int count = 10; // 배열의 길이 (원소 개수)
//		배열을 선언할때 [10] 대신 [count] 넣어 배열.length 사용 할 필요없이 count변수를 넣으면 된다.
//		String male = "Male" // 아래에서 변수 이름을 써주는 것이 더 안전하다.
//		String female = "여성" // 내용 수정에도 용이
		
		//int 10개를 저장할 수 있는 배열을 선언.
		int[] genderCodes = new int[10];
		
		// 배열에 난수 (0,1) 10개를 저장.
		Random random = new Random();
		for (int x = 0 ; x < genderCodes.length ; x++) {
			genderCodes[x] = random.nextInt(2);
		}
		
		// 배열의 내용을 출력.
		for (int x : genderCodes) {
			System.out.print(x + " "); ////// 내용 출력할때 배열 이름 넣을 필요없이 선언한 x 값만 출력
		}
	
		System.out.println();
		// 문자열 10개를 저장할 수 있는 배열(genders)을 선언.
		String[] genders = new String[10];
	
		// genderCodes의 값이 0이면 "Male", 1이면 "Female"을 문자열 배열에 저장.
		for (int x = 0; x < genders.length; x++ ) {
			if (genderCodes[x] == 0) {
				genders[x] = "Male";
			} else {
				genders[x] = "Female";
			} 
		}
		
		// 문자열 배열 genders의 내용 출력
		for (String x : genders) {
			System.out.print( x + " " ); 
		}
		System.out.println();
		// 문자열 배열에 저장된 "Male"의 개수, "Female"의 개수를 출력.
		// (Hint) 숫자 x, y가 같은 지 비교: x == y
		// (Hint) 문자열 x, y가 같은 지 비교: x.equals(y)
		int sumM = 0; // Male 갯수 
		int sumF = 0; // Female 갯수
		for ( String x : genders) {
			if (x.equals("Male")) {
				sumM ++; // Male 숫자 1++
			} else if (x.equals("Female")) {
				sumF ++; // Female 숫자 1++
			}
		}
		System.out.println("Male = " + sumM);
		System.out.println("Female = " + sumF);
		
	}

}
