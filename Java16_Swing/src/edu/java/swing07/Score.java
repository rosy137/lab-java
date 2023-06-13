package edu.java.swing07;

// MVC 아키텍쳐에서 Model 객체
public class Score {
	private final int SUB = 3;
	private int korean;
	private int english;
	private int math;
	
	public Score() {}

	public Score(int korean, int english, int math) {
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	// 세 과목의 총점을 int 타입으로 리턴하는 메서드. getTotal
	public int getTotal() {
		int result = this.korean + this.english + this.math;
		return result;
	}
	
	// 세 과목의 평균을 double 타입으로 리턴하는 메서드. getMean
	public double getMean() {
		double result = this.getTotal() / (double)SUB;
		return result;
	}
	
	// toString
	@Override
	public String toString() {
		return String.format("Score(Korean: %d, English: %d, Math: %d, Total: %d, Average: %f)", 
				this.korean, this.english, this.math, this.getTotal(), this.getMean());
	}
	
	
	
}
