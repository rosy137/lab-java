package edu.java.method03;

import java.util.Random;

public class MethodMain03 {

	public static int[] makeTestData(int n) {
		Random random = new Random();
		int[] arr = new int[n]; 
		for (int i = 0 ; i < arr.length ; i++) {
			arr[i] = random.nextInt(100) + 1;
		}
		return arr;
	}
	
	public static void printTestArray(int[] array) { //출력만 하는 것으로 return 값이 없으니 void
		System.out.print("[ ");
		for ( int x : array ) {
			System.out.print(x + " ");
		}
		System.out.print("]");
		System.out.println();
		
		// void 타입의 메서드에서는 return; 문을 생략해도 됨.   
		return;
	}
		
    public static void main(String[] args) {
//    	Random random = new Random();
//        int[] arr = new int[10];
//        for (int i = 0 ; i < arr.length ; i ++ ) {
//        	arr[i] = random.nextInt(100) + 1;
//        }
//        for (int i : arr) {
//        	System.out.print(i + " ");
//        }
//        System.out.println();
        // 메서드 기능 테스트를 위한 난수 배열 출력
    	
    	int [] arr = makeTestData(10);
    	printTestArray(arr);
        
        int result = 0;
        double resultMean = 0;
        
        result = sum(arr);
        System.out.println("sum = " + result);
        
        resultMean = mean(arr);
        System.out.println("mean = " + resultMean);
        
        result = max(arr);
        System.out.println("max = " + result);
        
        result = maxAt(arr);
        System.out.println("maxAt = " + result);
        
        result = min(arr);
        System.out.println("min = " + result);     
        
        result = minAt(arr);
        System.out.println("minAt = " + result);
        
    }
    
    /**
     * sum
     * 정수 배열의 모든 원소들의 합을 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 모든 원소들의 합.
     */
    // TODO
    public static int sum(int[] arr) {
    	int total = 0; // 되도록이면 변수 이름은 메서드 이름과 다른 것으로 
    	for (int x : arr) {
    		total += x;
    	}
    	return total;
    }
    
    /**
     * mean
     * 정수 배열의 모든 원소들의 평균을 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 모든 원소들의 평균(double).
     */
    // TODO
    public static double mean(int[] arr) {
//    	int sum = 0;
//    	double result = 0;
//    	for (int x : arr) {
//    		sum += x;
//    	}
//    	result = (double) sum / arr.length;
//    	return result;
    	return (double)	sum(arr) / arr.length;
    
    }
    
    /**
     * max
     * 정수 배열에서 최댓값을 찾아서 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 원소들 중 최댓값.
     */
    // TODO
    public static int max(int[] arr) {
    	int maxVal = arr[0];
    	for (int x : arr) {
    		if (x > maxVal) {
    			maxVal = x;
    		}
    	}
    	return maxVal;
    }
    
    /**
     * maxAt
     * 정수 배열에서 최댓값의 인덱스 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 원소들 중 최댓값의 인덱스.
     * 최댓값이 여러개 있는 경우, 첫번째 최댓값의 인덱스. 배열 순서 인덱스 나오게 하는ㄱ 
     */
    // TODO
    public static int maxAt(int[] arr) {
//    	int max = arr[0];
    	int maxIndex = 0;

//    	for (int i = 0; i < arr.length ; i ++) {
//    		if (arr[i] > max) {
//    			max = arr[i];
//    			maxIndex = i; 
//    		} 		
//    	}
    	for (int i = 0; i <arr.length ; i ++) {
    		if (arr[i] >arr[maxIndex]) {
    			maxIndex = i;
    		}
    	}
    	return maxIndex;
    	
    	
    	
    }

    /**
     * min
     * 정수 배열에서 최솟값을 찾아서 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 원소들 중 최솟값.
     */
    // TODO
    public static int min(int[] arr) {
    	int minVal = arr[0];
    	for (int x : arr) {
//    		if (x < minVal) {
//    			minVal = x;
    		minVal = (x< minVal) ? x : minVal;
    	}
    	return minVal;
    }
    /**
     * minAt
     * 정수 배열에서 최솟값의 인덱스 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 원소들 중 최솟값의 인덱스.
     * 최솟값이 여러개 있는 경우, 첫번째 최솟값의 인덱스.
     */
    // TODO
    public static int minAt(int[] arr) {
//    	int min = arr[0];
//    	int minIndex = 0;
//    	for (int i = 0; i < arr.length ; i ++) {
//    		if (arr [i] < min) {
//    			min = arr[i];
//    			minIndex = i;
//    		}
//    	}
//    	return minIndex;
    	


    	int minVal = min(arr);
    	// 최솟값을 찾음. 
    	int index = 0; // 배열의 인덱스
    	for (index= 0; index < arr.length ; index ++) {
    		// 배열의 원소들을 순서대로 반복하면서, 그 원소가 최솟값인 지 검사.
    		if (arr[index] == minVal) {
    			break; 
    			// 최솟값을 찾았으면 반복을 종료.
    		}
    	}
    	return index; // break로 for문이 종료되었을때 나온 index를 리턴해줘야하니까 185에서 index 초기화 선언
    	// 반복문이 종료됐을 때의 인덱스를 리턴
    }
    
}