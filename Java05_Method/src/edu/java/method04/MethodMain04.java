package edu.java.method04;

public class MethodMain04 {

	public static void main(String[] args) {
		// 메서드 오버로딩(method overloading):
		// 같은 이름의 메서드를 여러개 정의하는 것.
		// 메서드의 파라미터의 타입 또는 개수가 다를 때 overloading할 수 있음.
		// (주의) 메서드의 파라미터는 같고 리턴 타입만 다르게 overloading할 수는 없음.
		
		System.out.println("안녕하세요");
        System.out.println();
        System.out.println(10);
        System.out.println(3.14);
        System.out.println(true);
        System.out.println(12345678901L);
//      println ctrl+space 했을때 파라미터 타입이 다른 옵션들이 나오는 것 = overloading.
        
        System.out.println(divide(10, 4)); // 메서드의 파라미터 타입 int ( double 넣으면 자동으로 double 메서드 호출 )
        System.out.println(divide(10.0, 4.0)); // 메서드의 파라미터 타입 double
     // 메서드의 파라미터의 타입(메서드에 전달되는 아규먼트의 타입)이 int, double으로 다르므로 overloading 가능
	}

//	public static double divide(int x, int y) {
//		return (double) x / y;
//	}
//	 리턴 타입 = double, 메서드의 파라미터 = int
//	-> 리턴 타입이 다르다고 해서 overloading할 수 있는 것은 아니다.
	
	public static int divide(int x, int y) {
		return x / y; // x를 y로 나눈 몫을 리턴.
	}
	
	public static double divide(double x, double y) {
		return x / y; // (소수점 포함) 나누기 결과를 리턴.
	}
	
}
