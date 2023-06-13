package edu.java.class01;

// 객체 지향 프로그래밍(Object-Oriented Programming) 언어: java, C++, C#, ...
// 절차 지향 프로그래밍(Procedural Programming) 언어: C, ...
// 객체(object): 대상. 프로그램에서 사용하려는 대상.	붕어빵 (만들어지기 전, 붕어빵이라는 개념이 존재하는 상태)
// 인스턴스(instance): 실제로 만들어진(생성된) 객체. 	붕어빵 (실제로 만들어진, 공간을 차지하고 존재하는 상태)
// -> hello, java 라는 문자열 객체가 존재하고, 문자열 인스턴스가 생성되는 것.

// 클래스(class): object를 설계한 코드. 				붕어빵 틀
// -> 객체가 가질 수 있는 데이터(값)를 변수로 선언하고, 
// -> 객체가 가질 수 있는 기능들을 메서드로 정의한 소스 코드
// -> 데이터 타입(변수를 선언할 때 사용).



public class ClassMain01 {

	public static void main(String[] args) {
	    String s1 = "hello, java";
	    String s2 = new String("안녕하세요");
	    
	    System.out.println("s1 길이 = " + s1.length());
	    System.out.println("s1 길이 = " + s2.length());	    
	    System.out.println(s1.concat("!!!")); //concatenation //concatenate 엑셀 함수
	    System.out.println(s2.concat("...")); 
	    
	}

}

