package edu.java.thread01;

public class ThreadMain01 {
	
	public static void main(String[] args) {
		/*
		 * Thread 사용방법 1:
		 * 1. Thread를 상속하는 클래스를 선언(정의)
		 * 2. Thread를 상속하는 클래스에서 run() 메서드를 override - Thread가 할 일.
		 * 3. Thread를 상속하는 클래스의 객체 생성
		 * 4. 생성된 객체에서 start() 메서드를 호출.
		 * 		(주의) override한 run() 메서드를 직접 호출하면 thread가 실행되지 않음!
		 * 		start() method 호출 -> thread가 초기(메모리 할당, ...) -> run() method 실행.
		 */
		
		// local (inner) class(지역 클래스)
		// (1) Thread를 상속하는 클래스를 선언:
		class MyThread extends Thread {
			// field
			private String name;
			
			// constructor
			public MyThread(String name) {
				this.name = name;
			}
			
			// method
			@Override // (2) run 메서드 재정의 - 쓰레드가 할 일.
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println(i + " - " + name);
					
					try {
						sleep(10); // 0.01(=10/1000)초 멈춤.
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
				}
			}
		}
		// (3) Thread를 상속하는 객체 생성
		MyThread th1 = new MyThread("쓰레드");
		MyThread th2 = new MyThread("오쌤");
		
		// Thread 시작 전 시간 기록:
		long start = System.currentTimeMillis();
		
		// (4) Thread를 실행 - start() 메서드 호출
		th1.start();
		th2.start();
		
		try {
			// thread가 종료할 때까지 main tread는 기다림.
			th1.join();
			th2.join(); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 모든 thread 종료 후 시간 기록
		long end = System.currentTimeMillis();
		System.out.println("시간: " + (end - start) + "ms");
		
		System.out.println("main 메서드 종료");
		

	}
}
