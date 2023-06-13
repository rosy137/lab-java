package edu.java.array09;

import java.util.Random;

public class ArrayMain09 {

    public static void main(String[] args) {
        // 1차원 정수(int) 배열 3개를 갖는 2차원 배열을 선언.
    	int[][] array = new int[3][];
//    	int array [][] = new int[][]; 대괄호 위치 상관 없음/ C언어 방식 
    	
    	// 첫번째 배열에는 난수 2개, 두번째 배열에는 난수 3개, 세번째 배열에는 난수 4개 저장.
//    	array[0] = new int[2];
//    	array[1] = new int[3];
//    	array[2] = new int[4];
    	Random random = new Random();
    	for (int i = 0 ; i < array.length ; i ++) {
    		array[i] = new int[i + 2];
    		for (int j = 0; j < array [i].length ; j++) {
    			array[i][j] = random.nextInt(101);
    		}
    	}
    	
        // 저장하는 난수의 범위는 0 이상 100 이하. / 위
//    	Random random = new Random();
//    	for (int i = 0 ; i < array.length ; i ++) {
//    		for ( int j = 0 ; j < array[i].length ; j ++) {
//    			array[i][j] = random.nextInt(101);
//    		}
//    	}
    	
        // 2차원 배열의 원소들을 출력.
    	for (int[] i : array) {
    		for (int j : i) {
    			System.out.print(j + "\t");
    		}
    		System.out.println();
    	} 
    	
        // 2차원 배열의 모든 원소들의 합을 계산하고 출력.
    	int sum = 0; // 배열 원소들의 합
    	int averSum1 = 0; // 배열 원소들의 개수 저장
    	for (int[] i : array) {
    		for (int j : i) {
    			sum += j;
    			averSum1 ++;
    		}
    	}
		System.out.println("모든 원소들의 합 " + sum);
		
		double aver = (double)sum / averSum1;
		System.out.println("모든 원소들의 평균 " + aver);
    	
        // 2차원 배열의 모든 원소들의 평균을 계산하고 출력.
//		int averSum = 0;
//		for (int i = 0 ; i < array.length ; i ++) {
//    		for ( int j = 0 ; j < array[i].length ; j ++) {
//    			averSum ++;
//    		}
//    	}
//		System.out.println(averSum);
//		double aver = (double)sum / averSum;
//		System.out.println("모든 원소들의 평균 " + aver);
		
        // 최댓값을 찾고 출력.
		int max = array[0][0];
		for (int[] i : array) {
			for (int j : i) {
//				if (j > max) {
//					max = j;
//				}
				max =  ( j > max ) ? j : max;
			}
		}
		System.out.println("최댓값 " + max);
		
        // 최솟값을 찾고 출력.
		int min = array[0][0];
		for (int[] i : array) {
			for (int j : i) {
				
				
				
				
				if (j < min) {
					min = j;
				}
			}
		}
		System.out.println("최솟값 " + min);

    }

}