package edu.java.modifier03;

public class Test {
	// field
	private int number;
	private String name;
	private double bloodPressure;
	private boolean married;
	
	// constructor
	// 우클릭 > Source > generate constructor using fields... (omit 체크)
	public Test() {
	}
	
	public Test(int number, String name, double bloodPressure, boolean married) {
		this.number = number;
		this.name = name;
		this.bloodPressure = bloodPressure;
		this.married = married;
	}
	
	// getter & setter
	// 우클릭 > Source > generate getters and setters...
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		
	}

	public double getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(double bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public boolean isMarried() { 
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	
	
}
