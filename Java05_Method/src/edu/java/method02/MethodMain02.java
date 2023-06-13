package edu.java.method02;

import java.util.Random;

public class MethodMain02 {
	
	public static void main(String[] args) {
		// argument를 가지고, 리턴 값이 있는 메서드 작성/호출 연습
		
		// 같은 클래스 안에서 작성한 메서드인 경우에는 메서드 이름으로만 호출 가능
		
		Random random = new Random();
		double x = random.nextInt(100) + 1;
		double y = random.nextInt(100) + 1;
		double result = 0;
		int i = random.nextInt(10) + 1;
		
		System.out.print(x + "  " + y);
		
		System.out.println();
		result = add(x, y); // 메서드 호출. argument - 1, 2. // ctrl 누르고 링크뜨면 메서드 위치로 이동 // alt + <- 귀환
		System.out.println("add = " + result);
		
		result = subtract(x, y);
		System.out.println("subtract = " + result);
		
		result = multiply(x, y);
		System.out.println("multiply = " + result);
		
		result = divide(x, y);
		System.out.println("divide = " + result);
		
		boolean j = isEven(i);
		System.out.println("난수 " + i + "는 짝수입니다. T or F >> " + j);
//		System.out.println(isEven(60));
		
		int [] arrayx = makeArray(i);
			System.out.print("배열의 길이 = " + i + "\n배열 {");
		for (int q : arrayx) {
			System.out.print(q + " ");
		}
		System.out.print("}");
	}
	
	/**
	 * 실수 2개를 전달받아서, 덧셈 결과를 리턴하는 메서드.
	 * @param x 실수(double) 타입.
	 * @param y 실수(double) 타입.
	 * @return x + y.
	 */
	public static double add(double x, double y) {
		// 메서드 정의(선언)
		// 메서드 수식어 - public static
		// 메서드 리턴 타입 - double 
		// 메서드 이름 - add
		// 파라미터(parameter) - double x, double y
		
		return x + y; // 리턴 문장. x + y -> 리턴 값.
	}
    
    /**
     * subtract
     * 숫자 2개를 전달받아서, 뺄셈의 결과를 반환.
     * @param x double.
     * @param y double.
     * @return x - y.
     */
    // TODO
	public static double subtract(double x, double y) {
		return x - y;
		//return 이후로 문장이 있으면 안됨
	}
    
    /**
     * multiply
     * 숫자 2개 전달받아서 곱셈 결과를 반환.
     * @param x double.
     * @param y double.
     * @return x * y.
     */
    // TODO
    public static double multiply(double x, double y) {
    	return x * y;    
    }
    /**
     * divide
     * 숫자 2개를 전달받아서, 나눗셈 결과를 반환.
     * @param x double.
     * @param y double.
     * @return x / y.
     */
    // TODO
    public static double divide(double x, double y) {
    	return x / y;
    }
    
    /**
     * isEven
     * 정수가 짝수인 지 아닌 지를 리턴하는 메서드.
     * @param n 짝수인 지 홀수인 지 검사할 정수.
     * @return n이 짝수이면 true, 그렇지 않으면 false.
     */
    // TODO
    public static boolean isEven(int n) {
    	return  n % 2 == 0;
    	
//    	boolean result = false; // 짝수인 지, 홀수인 지를 저장할 변수.
//    	if (n % 2 == 0) {
//    		result = true;
//    	} else {
//    		result = false;
//    	} 
//    	return result;
   
    	// return 메서드 끝남, 값을 되돌려 줌
    	
    }
    
    /**
     * makeArray
     * argument로 전달된 배열의 길이 크기의 정수 배열을 생성하고,
     * 임의의 난수들로 배열을 초기화해서 리턴하는 함수.
     * @param length 배열의 길이. 양의 정수.
     * @return length개의 난수들로 초기화된 정수 배열.
     */
    // TODO
//  public static 결과값 메서드이름 (파라미터선언)
    public static int[] makeArray(int length) {
    	Random random = new Random();
    	
    	int[] arrayx = new int[length];
    	
    	for (int x = 0 ; x < arrayx.length ; x++) {
    		arrayx[x] = random.nextInt(100) + 1 ;
    	}
    	return arrayx;
    	
}
}
