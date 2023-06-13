package edu.java.list04;

import java.util.ArrayList;
import java.util.Scanner;

public class Listmain04 {
	public static void main(String[] args) {
		// User 타입을 저장하는 ArrayList 타입 변수 선언, 객체 생성.
		ArrayList<User> users = new ArrayList<>();
		
		// 3개의 User 객체를 ArrayList에 저장.
		Scanner scanner = new Scanner(System.in);
		User User1 = new User();
		users.add(User1);
		User User2 = new User("admin", "5678");
		users.add(User2);
		User User3 = new User("guest", "***");
		users.add(User3);
		
		
//		for (int i = 0; i <= 2 ; i++) {
//			System.out.println("id 입력 >>> ");
//			String id = scanner.nextLine();
//			System.out.println("passowrd 입력 >>> ");
//			String password = scanner.nextLine();
//			
//			User u = new User(id, password);
//			users.add(u);
//			}
		
		// 저장된 내용 출력
		System.out.println(users);
		
		// 리스트 user에서 인덱스 0번 위치의 원소를 삭제.
		users.remove(0);
		System.out.println(users);
		
		// id가 "guest"인 첫번째 User 객체를 리스트에서 삭제.
		
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getId().equals("guest")) { 
				// 배열에서 i번째 인덱스꺼냄, 그 인덱스의 id 꺼냄, 그 값이 "guest"와 같은지 확인
				users.remove(i);
				break;
			}
		}
		System.out.println(users);
		
		
	}
}
