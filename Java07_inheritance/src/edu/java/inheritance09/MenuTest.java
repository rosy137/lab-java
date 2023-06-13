package edu.java.inheritance09;

import java.util.Scanner;

enum Menu {
	// enum 상수 (public static final 변수) 선언
	QUIT, CREATE, READ_ALL, READ_BY_INDEX, UPDATE, DELETE, UNKNOWN;

	/**
	 * 정수가 입력되면, 그 정수에 해당하는 열거형 상수를 리턴.
	 * 0>QUIT, 1>CREATE, 2>READ_ALL, 3>READ_BY_INDEX, 4>UPDATE, 5>DELETE, 6>UNKNOWN
	 * @param n
	 * @return
	 */
	public static Menu getValue(int n) {
		Menu[] menus = Menu.values();
		final int MAX_LENGTH_INDEX = menus.length-1;
		if ( n > 0 && n <= MAX_LENGTH_INDEX) {
			return menus[n];
		}
		return menus[MAX_LENGTH_INDEX];
	}
}


public class MenuTest {

	public static void main(String[] args) {
		Singleton s = Singleton.INSTANCE;
		//-> enum 타입이 열거형 상수를 1개만 가지고 있으면,
		//	 그 enum 타입에 할당할 수 있는 객체는 1개만 있게 됨.
		//	 -> singleton 객체
		
		System.out.print("숫자 입력 >>> ");
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine()); // 콘솔창에서 입력받은 정수
		
		Menu menu = Menu.getValue(n); //정수를 전달하면 메뉴의 상수들 중 하나를 리턴하는 메서드
		switch(menu) {
		case QUIT:
            System.out.println(menu.name());
            break;
        case CREATE:
            System.out.println(menu.name());
            break;
        case READ_ALL:
            System.out.println(menu.name());
            break;
        case READ_BY_INDEX:
            System.out.println(menu.name());
            break;
        case UPDATE:
            System.out.println(menu.name());
            break;
        case DELETE:
            System.out.println(menu.name());
            break;
        default:
        	System.out.println(menu.name());
		}

	}

}
