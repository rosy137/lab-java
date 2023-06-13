package edu.java.conditional03;

import java.util.Scanner;

public class ConditionalMain03 {

	public static void main(String[] args) {
		// 간단한 성적 처리 프로그램
		// 스캐너 java, sql, html
		// 총점, 평균, A>=90 B>=80 C>=70 D>=60 F<60

		// 'Sysout' + Ctrl + Space <단축
		// Ctrl + Space >> 코드 추천 기능 (맥은 command + space //spotlight 단축어 바꾸기
		// Ctrl + F11 >> 실행 (Run Java Program)
		
		Scanner sc = new Scanner(System.in); //입력장치 Scanner를 사용할 준비 끝.
		

		System.out.println("java 성적 입력>>>");
		int java = sc.nextInt();
		System.out.println("java 성적 = " + java );
		
		System.out.println("sql 성적 입력>>>");
		int sql = sc.nextInt();
		System.out.println("sql 성적 = " + sql );
		
		System.out.println("html 성적 입력>>>");
		int html = sc.nextInt();
		System.out.println("html 성적 = " + html );
		
		
		System.out.println("----------------------");
		int total = java + sql + html; // 과목 총점 계산
		System.out.println("과목의 총점은 " + total + "입니다.");
		
		//double average = (double)total /3; // 과목 평균 계산
		double average = total/3.0;
		System.out.println("과목의 평균은 " + average + "입니다.");
		
		//학점 출력 		
		if (average >= 90) {
			System.out.println("학점 A입니다.");
		} else if (average >= 80) {
			System.out.println("학점 B입니다.");
		} else if (average >= 70) {
			System.out.println("학점 C입니다.");
		} else if (average >= 60) {
			System.out.println("학점 D입니다.");
		} else System.out.println("학점 F입니다.");
		
		
	}

}
