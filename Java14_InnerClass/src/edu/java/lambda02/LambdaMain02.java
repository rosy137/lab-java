package edu.java.lambda02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LambdaMain02 {

	public static void main(String[] args) {
		Random random = new Random();
		
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < 10 ; i++) {
			numbers.add(random.nextInt(100));
		}
		
		// 1)
		for (Integer x: numbers) {
			System.out.print(x+ " ");
		}
		System.out.println();
		
		// 2) Lambda
		numbers.forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		
		//
		// 리스트 numbers에서 짝수들만 선택해서 새로운 리스트에 저장하고 출력.
		// 1)
		LinkedList<Integer> evens = new LinkedList<>();
		for (Integer x: numbers) {
			if(x % 2 == 0) {
				evens.add(x);
			}
		}
		System.out.println(evens);
		
		// 2) Lambda
		List<Integer> evens2 = numbers.stream() // 리스트가 지나가는 통로
				.filter(x -> x % 2 == 0) // 조건 필터링
				.toList(); // 리스트로 만듦
		System.out.println(evens2);
		// filer 메서드의 argument:
		//		파라미터가 1개이고 리턴 타입이 boolean인 FuntionalInterface 객체를 전달.
		
		
		//
		// 리스트 numbers에서 홀수들의 제곱을 저장하는 리스트를 만들고 출력.
		// 1)
		LinkedList<Integer> oddSquares = new LinkedList<>();
		for (Integer x: numbers) {
			if(x % 2 !=0 ) {
				oddSquares.add(x * x);
			}
		}
		System.out.println(oddSquares);
		
		// 2) Lambda
		List<Integer> oddSquares2 = numbers.stream() // 리스트의 원소가 지나가는 통로
				.filter(x -> x % 2 != 0) // 조건 필터링 
				.map(x -> x * x) // 저장할 결과값 매핑
				.toList(); // 리스트로 만듦
		System.out.println(oddSquares2);
		// map 메서드의 argument:
		// 		파라미터가 1개이고, 리턴 값이 있는 (void가 아닌) FunctionalInterface 객체.
		
		//
		//
		List<String> languages = Arrays.asList("Java", "SQL", "Javascript", "Python");
		// 리스트 languages에서 5글자 이상인 문자열을 소문자로 변환한 문자열을 원소로 갖는 리스트를 만들고 출력
		// 1)
		LinkedList<String> upper = new LinkedList<>();
		for(String s : languages) {
			if(s.length() >= 5) {
				upper.add(s.toLowerCase());
			}
		}
		System.out.println(upper);
		
		// 2) Lambda
		List<String> up = languages.stream()
				.filter(x -> x.length() >= 5)
				.map(x -> x.toLowerCase())
				.toList();
		System.out.println(up);
		
		
	}
}
