package edu.java.method05;

import java.util.Random;

public class MethodMain05 {

	public static void main(String[] args) {
		System.out.printf("이름: %s \n", "오쌤");
		System.out.printf("이름: %s, 나이: %d \n", "오쌤", 16);
		System.out.printf("이름: %s, 나이: %d, 키: %f \n", "오쌤", 16, 180.5);
		
		double result = calculate("+");
		System.out.println(result);
		
		result = calculate("+", 1,2,3);
		System.out.println(result);
		
		result = calculate("*");
		System.out.println(result);
		
		result = calculate("*", 1,2,3,4,5);
		System.out.println(result);
		
		Random random = new Random();
		double[] arr = new double[5];
		for (int i = 0; i < arr.length; i ++) {
			arr[i] = random.nextDouble(100)+1;
		}
		for (double i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(calculate("+", arr));
		System.out.println(calculate("*", arr));  
		
//		System.out.printf(아규먼트 2개짜리 "문자열", "오브젝트 ...");
// 		파라미터 타입 뒤에 ... 를 붙이는 것 -> 가변 길이 아규먼트 (아규먼트의 개수가 바뀔 수 있다. )		

		// 가변 길이 아규먼트(variable-length) argument를 갖는 메서드:
		// 파라미터를 선언할 때, 변수 타입 뒤에 "..."을 붙임.
		// 가변 길이 아규먼트에는 전달하는 값의 개수 제한이 없음. 아규먼트를 전달하지 않아도 됨!
		// 가변 길이 아규먼트는 메서드 안에서는 배열처럼 취급함. 
		// (주의) 가변 길이 아규먼트는 가장 마지막 파라미터로 선언해야 한다.
		// (주의) 가변 길이 아규먼트를 갖는 파라미터는 오직 1개만 선언할 수 있음.
			
	}

	/**
	 * argument op가 "+"인 경우에는, 모든 가변 아규먼트들의 합계를 반환하고,
	 * argument op가 "*"인 경우에는, 모든 가변 아규먼트들의 곱하기를 반환하는 메서드.
	 * @param op "+" 또는 "*". 그 이외의 문자열들은 모두 무시.
	 * @param args double 타입의 (임의의 개수의) 숫자(들).
	 * @return  double. 
	 * op가 "+" 이면 모든 숫자들의 합을 리턴.
	 * op가 "*" 이면, 모든 숫자들의 곱하기를 리턴. 
	 * op가 "*" 인데, 아규먼트로 전달된 숫자가 없으면 1을 리턴.
	 * op가 "+" 또는 "*"가 아니면 0.0을 리턴.
	 */
	public static double calculate(String op, double... args) {
		double result = 0.0;
		switch (op) {
		case "+" : 
			for(double x : args) { // args라는 배열이 생기는 것
				result += x;
			}
			break;
		case "*" :
			result = 1.0; 
			// 문자열이 "*"이어서 result = 1.0 으로 선언됨, 그러나 함께 전달된 숫자가 없어서 result로 return 됨.
			for(double x : args) {
				result *= x;
			}
			break;
		default:
		}
		return result;
	}
	
	
}
