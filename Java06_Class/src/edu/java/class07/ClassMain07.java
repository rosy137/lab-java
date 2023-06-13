package edu.java.class07;

import java.util.Random;

public class ClassMain07 {

	public static void main(String[] args) {
		String emptyString = "";
		// 문자열이 없는 상태
		// 스택: 지역 변수에 
		// 힙:   ""
		System.out.println("길이: " + emptyString.length());

		String nullString = null;
		// 문자열 자체가 만들어지지 않은 상태 
		// -> NullPointerException Error
		// null: 생성된 객체가 없다.
		// 스택: 지역 변수만 만들어진 상태
		// 힙:   (아무것도 없음)
//		System.out.println("길이: " + nullString.length());
		// 데이터 타입의 기본값:
		// (1) boolean - false, (2) 정수 - 0, (3) 실수 - 0.0, (4) 참조(클래스)타입 = null
		
		
		
		
		System.out.println("\n==========\n");
		
		Random ran = new Random();
		int java = ran.nextInt(100)+1;
		int sql = ran.nextInt(100)+1;
		int html = ran.nextInt(100)+1;
		
//		기본 생성자를 사용해서 Score 객체 생성
		Score sco00 = new Score();
		System.out.println(sco00);
		System.out.println("java 점수" + sco00.java);
		System.out.println("html 점수: " + sco00.html);
		System.out.println("sql 점수" + sco00.sql);
		sco00.printScore();
		System.out.println("==========");
		
//		argument를 갖는 생성자를 호출해서 Score 객체를 생성.
		Score sco01 = new Score(java,sql,html);
		System.out.println(sco01);
		sco01.printScore();
		System.out.println("score 총점: " + sco01.getTotal());
		System.out.println("score 평균: " + sco01.getAverage());
		System.out.println("----------");
		
//		기본 생성자를 사용해서 Student 객체를 생성.
		
		Student stu01 = new Student();
		System.out.println(stu01);	
		stu01.printStudent();
		System.out.println();
		
		stu01.stuNo = 1;
		stu01.name = ":)";
		stu01.score = sco01;
		stu01.printStudent();
		


	}

}
