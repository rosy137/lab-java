package edu.java.exception06;

import java.util.Scanner;

public class ExceptionMain06 {

	private Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		// TODO inputInteger() 메서드 테스트 코드
		 ExceptionMain06 app = new ExceptionMain06(); // static이 아닌 메서드 호출을 위한 객체 생성
		 int x = app.inputInteger();
		 System.out.println(x);
	}
	
	public int inputInteger() {
		// TODO Scanner를 사용해서 입력받은 정수를 리턴.
		// Integer.parseInt(scanner.nextLine()) 과정에서 NumberFormatException이 발생할 수 있음. 
//		while (true) {
//			try {
//				System.out.print("정수 입력 >>> ");
//				int result = Integer.parseInt(scanner.nextLine());
//				return result;
//			} catch (NumberFormatException e) {
//				System.out.println(e.getMessage());
//			}
//		}
		
		int result = 0; // 콘솔에 입력받은 값을 저장하게 될 변수 
		while (true) {
			try {
				System.out.print("정수 입력 >>> ");
				result = Integer.parseInt(scanner.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("정수 입력할 것");
			}
		}
		return result;
		// 아님 while 빼고 재귀
	}
	

}
