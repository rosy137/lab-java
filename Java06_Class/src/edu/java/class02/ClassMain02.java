package edu.java.class02;

public class ClassMain02 {

	public static void main(String[] args) {
		// TV 객체(object) 사용 - TV 켬/끔, 채널 변경, 볼륨 변경, ...
		// (1) TV 객체를 생성.
		BasicTv tv1 = new BasicTv(); // 생성자 호출 -> 객체 생성.
		
		// (2) 생성된 TV 객체(인스턴스)의 필드 또는 메서드를 사용.
		// tv1.powerOn: 생성된 객체(인스턴스) tv1의 필드(멤버 변수) powerOn
		System.out.println("-----tv1-----");
		System.out.println("tv1 전원: " + tv1.powerOn);
		tv1.powerOnOff(); // 객체의 메서드 호출. 꺼져있어서 켬.
		
		System.out.println("tv1 채널: " + tv1.channel);
		System.out.println("tv1 음량: " + tv1.volume);
		tv1.channelUp(); // channel 0 -> 1
	
		tv1.volumeUp();  // volume 0 -> 1
		tv1.volumeUp();  // volume 1 -> 2
		
		tv1.powerOnOff(); // 켜져있어서 끔.
		
		tv1.channelUp(); //  TV는 꺼진 상태, 마지막으로 저장되어있는 채널을 알려줌
		
		System.out.println("\n-----tv2-----");
		BasicTv tv2 = new BasicTv();
		System.out.println("tv2 전원: " +tv2.powerOn);
		tv2.powerOnOff();
		
		for (int i = 0 ; i < 10 ; i++ ) {
			tv2.channelUp();
		}
		System.out.println("\n==========");
		for (int i = 0 ; i < 10 ; i++) {
			tv2.channelDown();
		}
		System.out.println("\n==========");
		for (int i = 0 ; i < 10 ; i++) {
			tv2.volumeUp();
		}
		System.out.println("\n==========");
		for (int i = 0 ; i < 10 ; i++) {
			tv2.volumeDown();
		}
		

		
	}

}
