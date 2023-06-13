package edu.java.modifier03;

public class Person {
	// field
	private String name;
	private int age;
	
	// constructor
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	// method
	// getter 메서드
	public String getName() {//<< 관습
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	// setter 메서드
	public void setName(String name) {
		if (name.length() <= 5) {
			this.name = name;
		} else {
			System.out.println("error");
		}
	}
	
	public void setAge(int age) {
		if (age >= 0) {
			this.age = age;
		} else {
			System.out.println("error");
		}
	}
}
