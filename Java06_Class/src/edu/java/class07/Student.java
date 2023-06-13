package edu.java.class07;

public class Student {
	// 필드
	int stuNo; // 학생 번호
	String name; // 학생 이름
	Score score; // 학생의 시험 점수
	// 생성자
//	(1) 기본 생성자
	public Student() {}
//	(2) stuNo, name, score 초기화 생성자
	public Student(int stuNo, String name, Score score) {
		this.stuNo = stuNo;
		this.name = name;
		this.score = score;
	}
	
	public Student(int stuNo, String name, int java, int sql, int html) {
		this.stuNo = stuNo;
		this.name = name;
		this.score = new Score(java, sql, html);
		
	}
	
	// 메서드
//	(1) printStudent - 학번, 이름, 세 과목 점수, 총점, 평균을 출력하는 메서드
	public void printStudent() {
		System.out.println("-----학생 정보-----");
		System.out.println("학번: " + this.stuNo);
		System.out.println("이름: " + this.name);
		if (this.score != null) {
		System.out.println("java: " + this.score.java);
		System.out.println("sql: " + this.score.sql);
		System.out.println("html: " + this.score.java);
		this.score.printScore();
		System.out.println("총점: " + this.score.getTotal());
		System.out.println("평균: " + this.score.getAverage());
		} else {
			System.out.println("점수 없음");
		}
	}

}
