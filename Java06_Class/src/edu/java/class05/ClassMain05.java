package edu.java.class05;

public class ClassMain05 {

	public static void main(String[] args) {
		System.out.println("=====Rec01=====");
		Rectangle rec01 = new Rectangle(5.5,3.5);
		System.out.println("width: " + rec01.width + ", height: " + rec01.height);
		
		double perimeter = rec01.perimeter();
		System.out.println("perimeter: " + perimeter);
		
		double area = rec01.area();
		System.out.println("area: " + area);
		
		System.out.println("------>>>------");
		rec01.width = 1.0; // 생성된 rec01 직사각형의 가로 길이를 변경
		rec01.height = 4.8; // 생성된 rec01 직사각형의 세로 길이를 변경
		System.out.println("width: " + rec01.width + ", height: " + rec01.height);
		
		perimeter = rec01.perimeter();
		System.out.println("perimeter: " + perimeter);
		
		area = rec01.area();
		System.out.println("area: " + area);
				

		System.out.println("=====Rec02=====");
		Rectangle rec02 = new Rectangle();
		System.out.printf("width: %f, height: %f\n", rec02.width, rec02.height);
		
		perimeter = rec02.perimeter();
		System.out.println("perimeter: " + perimeter);
		

	}

}

