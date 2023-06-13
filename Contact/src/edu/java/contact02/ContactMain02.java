package edu.java.contact02;

import java.util.Scanner;

import edu.java.contact.menu.Menu;

public class ContactMain02 {
	// 상수(constant)
	// 연락처 배열의 최대 길이(원소 개수) 상수로 지정
	private static final int MAX_LENGTH = 5;
	
	// field
	private Contact[] contacts = new Contact[MAX_LENGTH]; // 전체 목록을 보여주기 위한 연락처 배열 생성 
	private int count = 0; // 연락처 배열에 현재까지 저장된 연락처 개수, 배열에 저장될 때마다 값 증가.
	private Scanner scanner = new Scanner(System.in); // 입력 도구
	
	// main
	public static void main(String[] args) {
		System.out.println("******************** 연락처 프로그램 v0.2 *********************");
		
		ContactMain02 app = new ContactMain02(); // static이 아닌 메서드들을 사용하기 위해 !참조 변수! 생성.		
		boolean run = true;
		while (run) {
			// 메인 메뉴 보여주기
			// 메인 메뉴에서 선택된 값
			Menu menu = Menu.getValue(app.showMainMenu());
			switch (menu) {
			case QUIT: // 종료
				run = false;
				break;
			case CREATE: // 새 연락처 저장 (배열의 최댓값을 넘기면 안됨, 배열에 순서대로 저장되어야함.
				app.insertNewContact();
				break;
			case READ_ALL: // 연락처 전체 목록 보여주기
				app.selectAllContacts();
				break;
			case READ_BY_INDEX: // 배열의 인덱스로 검색하기
				app.selectContactByIndex();
				break;
			case UPDATE: // 연락처의 이름이나 전화번호, 이메일 정보를 수정하기
				app.updateContactByIndex();
				break;
			case DELETE: // 배열의 인덱스로 연락처 삭제
				app.deleteContactByIndex();
				break;				
			default:
				System.out.println("***************** 메인 메뉴 번호를 확인하세요 *****************");
			}
		}
		System.out.println("*********************** 프로그램 종료 *************************");
	}

	public void insertNewContact() {
//		if (count < MAX_LENGTH) { //
		System.out.println();
		System.out.println("------- 새 연락처 저장 -------");
		
		if (count == MAX_LENGTH) { 
			System.out.println("연락처를 저장할 공간이 부족합니다.");
			return; // 메서드 종료
		} 
		
		System.out.print("이름 입력 >>> ");
		String name = scanner.nextLine(); // 공백 포함한 엔터 입력될 때까지의 모든 문자열 
		System.out.print("전화번호 입력 >>> ");
		String phone = scanner.nextLine();
		System.out.print("이메일 입력 >>> ");
		String email = scanner.nextLine();
		
		// 입력받은 정보들로 Contact 타입의 객체 생성
		Contact c = new Contact(0, name, phone, email);
		
		// 생성된 Contact 타입의 객체를 배열에 저장
		contacts[count] = c; // 이미 배열 5자리 만들어져 있고, 거기에 0부터 하나씩 채워나가는 것.
		
		// 배열에 저장된 원소(연락처) 개수를 1 증가. 
		count++; //<< 다음 카운트 번호의 배열 자리에 값이 저장됨.
		
		System.out.println("---------- 저장 완료 ---------");
//		} else {
//			System.out.println(">>>>>> 저장 불가 <<<<<<");
//		}
	}
	
	public void selectAllContacts() {
		System.out.println();
		System.out.println("----- 연락처 목록 -----");
		if (count > 0) {
		for (int i = 0; i < count; i++) { //<<MAX로 하면 null값 때문에 에러뜸
		// Cannot invoke "edu.java.contact01.Contact.printInfo()" because "this.contacts[i]" is null
			System.out.println(contacts[i]);
		} 
		} else {
			System.out.println("저장된 연락처가 없습니다.");
		}
	}

	public void selectContactByIndex() {
		System.out.println();
		System.out.println("----- 인덱스 검색 -----");
		System.out.println("찾을 데이터의 인덱스를 입력 >>> ");
		int index = inputNumber(); 
		// **************************** string 타입 int 변환 ********************************
		if (index >= 0 && index < count ) { // index + 1 < count
		System.out.println(contacts[index]);
		} else {
			System.out.println("불러올 연락처가 없습니다.");
		}
		}
	
	public void updateContactByIndex() {
		System.out.println();
		System.out.println("----- 연락처 수정 -----");
		System.out.println("수정할 연락처 인덱스 입력 >>> ");
		int index = inputNumber();
		
//		if (index + 1 < count) {	
		if (index < 0 || index >= count) {
			System.out.println("불러올 연락처가 없습니다.");
			return; // 메서드 종료
		}
		
		System.out.print("수정 전: ");
		System.out.println(contacts[index]);
		
		System.out.print("수정할 이름 입력 >>> ");
		String name = scanner.nextLine();
		System.out.print("수정할 전화번호 입력 >>> ");
		String phone = scanner.nextLine();
		System.out.print("수정할 이메일 입력 >>> ");
		String email = scanner.nextLine();
		
		contacts[index].setName(name);
		contacts[index].setPhone(phone);
		contacts[index].setEmail(email);
		
//		contacts[index] = new Contact (count+1, name, phone, email);
		
		System.out.println("----- 연락처 수정 완료 -----");
//		} else { 
//			System.out.println("불러올 연락처가 없습니다.");
//		}
	}
	
	public void deleteContactByIndex() {
		System.out.println();
		System.out.println("----- 연락처 삭제 -----");
		System.out.println("삭제할 연락처 인덱스 입력 >>> ");
		int index = inputNumber();
//		if (index + 1 < count) {
		if (index < 0 || index >= count) {
			System.out.println("불러올 연락처가 없습니다.");
			return; // 메서드 종료
		} 
			
		System.out.print("삭제할 연락처 확인: ");
		System.out.println(contacts[index]);
		
		for (int i = index; i + 1 < count; i++) { // 인덱스 0부터 시작, count 1부터 시작
			contacts[i] = contacts[i+1];
		}
		contacts[count-1] = null; // 배열이니까 인덱스로 생각 ***************
		count --; // 배열 원소 개수 1 줄임.
//		} else {
//			System.out.println("불러올 연락처가 없습니다.");
//		}
		
		System.out.println("----- 삭제 완료 -----");
	}
	
	public int showMainMenu() {
		System.out.println();
		System.out.println("---------------------------------------------------------------");
		System.out.println("[0] 종료 [1] 새 연락처 [2] 전체 목록 [3] 검색 [4] 수정 [5] 삭제");
		System.out.println("---------------------------------------------------------------");
//		int result = 0;
//		while (true) {
//			try {
//				System.out.print("선택 >>> ");
//				result = Integer.parseInt(scanner.nextLine());
//				break;
//			} catch (NumberFormatException e) {
//				System.out.println("정수를 입력할 것");
//			}
//		}
//		return result;
		
//		int result = Integer.parseInt(scanner.nextLine());
		// parseInt (string > int) //nextLine (String 읽음) //-> 콘솔창에서 입력된 문자열 1개 라인을 정수(int)로 변환하겠다는 뜻
		
		int result = inputNumber();
		return result;
	}
	
	
	public int inputNumber() {
		while(true) {
			try {
				int n = Integer.parseInt(scanner.nextLine());
				return n; // return: (1) 값을 메서드 호출한 곳에 반환. (2) 메서드 종료.
			} catch(NumberFormatException e) {
				System.out.print("정수 입력 >>> ");
			}
		}
	}
	
}
