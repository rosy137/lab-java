package edu.java.string;

import java.util.Arrays;

public class StringMain {
	public static void main(String[] args) {
		// Ex 1. 아래의 주민번호 문자열에서 성별을 표시하는 위치의 문자만 출력.
		String ssn = "991231-1234567";
		System.out.println(ssn.charAt(7)); // 1) 문자열에서 인덱스 7번 출력
		
		String[] ssnArray = ssn.split("-");
		System.out.println(ssnArray[1].charAt(0));  // 2) "-" 으로 문자열을 배열에 나눠 저장, 두번째 배열 인덱스 0번 출력
		
		System.out.println();
		
		// Ex 2. 아래의 문자열 배열에서 홍길동이라고 하는 문자열이 처음 등장하는 인덱스를 출력.
		// 	     만약에 "홍길동" 문자열이 배열에 없으면 -1 을 출력.
		String[] names = {"오쌤", "John", "Jane", "홍길동", "허균", "홍길동"};
		String s = "홍길동";
		System.out.println(Arrays.asList(names).indexOf(s)); // 1) String[] 타입 List<String> 변환하기
		
		int index = -1;
		for(int i = 0 ; i < names.length ; i++) {
			if(names[i].equals(s)) {
				index = i;
				break; // 2) 홍길동 찾으면 i 값을 index에 저장하고 멈춤.
			}
		}
		System.out.println(index);
		
		System.out.println();
		
		// Ex 3. 아래의 문자열 배열에서 다섯글자 이상인 문자열들을 찾아 출력
		String[] languages = {"Java", "SQL", "HTML", "CSS", "JavaScript", "Python"};
//		for(int i = 0; i < languages.length;i++) {
//			if (languages[i].length() >= 5) {
//				System.out.println(languages[i]);
//			}
//		}
		for(String upper: languages) {
			if (upper.length() >= 5) {
				System.out.println(upper);
			}
		}
		
		System.out.println();

		// Ex 4. 아래의 문자열 배열에서 대소문자 구별없이 "est"가 포함된 문자열들을 찾아서 출력.
		String [] tests = {"TEST", "test", "TeSt", "tEST", "테스트"};
		String t = "est";
		for(String e: tests) {
			if(e.toLowerCase().contains(t)) { // 전부 소문자로 변환해서 찾음. // CharSequence -> interface 
				System.out.println(e);
			}
		}
		
	
		
		System.out.println();
		
		// Ex 5. 아래의 "YYYY-MM-DD" 형식의 날짜 문자열에서 연/월/일 정보를 각각의 int타입 변수에 저장하고 출력. 
		String date = "2023-03-22";
		String[] ymd = date.split("-");
		int year = Integer.parseInt(ymd[0]);
		int month = Integer.parseInt(ymd[1]);
		int day = Integer.parseInt(ymd[2]);
		System.out.printf("%d년 %d월 %d일", year, month, day);
	}
}
