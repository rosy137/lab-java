// overflow
// for (byte i = 0;;i++){
// 		System.out.println(i);
// }
// 실행해보면 양수와 음수가 반복되어 나옴, 저장할수있는 정보의 양이 선언된 byte 용량을 넘어서서 발생하는 현상

package edu.java.array04;

import java.util.Random;

public class ArrayMain04 {

	public static void main(String[] args) {
		// 정수 5개를 저장할 수 있는 배열을 선언.
        // 0 이상 9 이하의 정수 난수 5개를 배열에 저장.
        // 배열의 내용을 출력.
        // 배열의 모든 원소의 합을 계산하고 출력.
        // 배열 원소들의 평균을 double 타입으로 계산하고 출력.
		
		Random random = new Random();
		
		int[] number = new int[5];
		int sum = 0;
		for (int x = 0; x < number.length ; x++) {
			int ran = random.nextInt(10);
			number[x] = ran;				
//			number[x] = random.nextInt(10); // 변수 ran을 따로 만들지 않고 한번에 한 줄로 선언 
			System.out.print(number[x]+ " ");			
		}
		System.out.println();
	
//		출력 문장 따로 
//		for (int x : number) {
//			System.out.print(x + " ");
//		}
//		System.out.println();
		
		for (int y : number) {
			sum = y + sum;
//			sum += y;
		}
		System.out.println("합은 " + sum);
		
		double div = 0;
		div = sum / (double) number.length;
		System.out.println("평균은 " + div);
		
		// 배열의 원소들 중 최댓값을 찾고 출력.
		// 최댓값 저장할 변수 선언, 배열의 난수 순차적으로 저장.
		int max = number[0]; // 배열의 첫번째 원소를 최댓값이라고 가정 ***int max를 배열 첫번째 원소로 초기화***
		for (int x : number) { // 배열 number의 모든 원소들을 순회하면서 
			if ( x > max) {
				max = x;
			}
		}
		System.out.println("max = " + max);
		
		// 배열의 원소들 중 최솟값을 찾고 출력.
		int min = number[0]; // 배열의 첫번째 원소를 최솟값이라고 가정.
		for (int x : number) { // 배열의 모든 원소를 순서대로 반복하면서, // 돌아와서, 배열에 있는 모든 수를 비교
			if (x < min) { // 배열에서 읽은 값이 min보다 작다면 
				min = x; // min값을 x(배열에서 읽은 더 작은 값)로 변경.
			}
		} 
		System.out.println("min = " + min);
		
	}

}
