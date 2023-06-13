package edu.java.contact03;

import java.util.Scanner;

import edu.java.contact.menu.Menu;
import edu.java.contact.model.Contact;

public class ContactMain03 {

	private final Scanner scanner = new Scanner (System.in);
	private final ContactDaoImpl dao = ContactDaoImpl.getInstance();
	
	public static void main(String[] args) {
		System.out.println("*** 연락처 프로그램 v0.3 ***");
		
		ContactMain03 app = new ContactMain03(); // static 아닌 필드 메서드 사용 위함
		
		boolean run = true;
		while(run) { // run = false일 때 까지 무한 루프
			int n = app.showMainMenu(); // 메인 메뉴 보여주는 메서드
			Menu menu = Menu.getValue(n); // 메인 메뉴 메서드에서 가져온 숫자로 메뉴 enum에서 문자열 호출
			switch (menu) {
			case QUIT:
				run = false;
				break;
			case CREATE:
				app.insertNewContact();
				break;
			case READ_ALL:
				app.selectAllConteacts();
				break;
			case READ_BY_INDEX:
				app.selectContactByIndex();
				break;
			case UPDATE:
				app.updateContact();
				break;
			case DELETE:
				app.deleteContact();
				break;
			default:
				System.out.println("메인 메뉴 번호 확인");
			}
		}
		System.out.println("*** 프로그램 종료 ***");
		
	}
	
	private void deleteContact() {
		System.out.println("삭제할 연락처 인덱스 입력 >>> ");
		int index = inputNumber();
		
		if(!dao.isValidIndex(index)) {
			System.out.println("해당 인덱스 저장 연락처 없음.");
			return;
		}
		
		int result = dao.delete(index);
		if (result == 1) {
            System.out.println(">>> 연락처 삭제 성공");
        } else {
            System.out.println(">>> 연락처 삭제 실패");
        }
		
	}

	private void updateContact() {
		System.out.print("수정할 연락처 인덱스 입력 >>> ");
		int index = inputNumber();
		
		if (!dao.isValidIndex(index)) {
			System.out.println("해당 인덱스 저장 연락처 없음.");
			return;
		}
		
		Contact before = dao.read(index);
		System.out.println("수정 전: " + before);
		
		System.out.print("이름 입력> ");
        String name = scanner.nextLine();
        System.out.print("전화번호 입력> ");
        String phone = scanner.nextLine();
        System.out.print("이메일 입력> ");
        String email = scanner.nextLine();
        
        Contact after = new Contact(0, name, phone, email);
        
        int result = dao.update(index, after);
        if (result == 1) {
        	if (result == 1) {
                System.out.println(">>> 연락처 업데이트 성공");
            } else {
                System.out.println(">>> 연락처 업데이트 실패");
            }
        }
		
	}

	private void selectContactByIndex() {
		System.out.print("출력할 연락처 인덱스 입력 >>> ");
		int index = inputNumber();//인덱스 넘겨받고
		
		Contact contact = dao.read(index); //contact에 해당 인덱스 내용 저장
		
		if (contact != null) { //인덱스가 널값이 아님
			System.out.println(contact);// 내용 출력 
		} else {
			System.out.println("해당 인덱스 저장 연락처 없음.");//널값이면 없다고 출력
		}
		
	}

	private void selectAllConteacts() {
		System.out.println("연락처 전체 목록");
		Contact[] contacts = dao.read();//배열에 전체 reading 저장
		
		for(Contact c: contacts) {
			System.out.println(c);//배열 출력
		}
		System.out.println("목록 끝");
		
	}

	private void insertNewContact() {
		System.out.println("새 연락처 저장");
		
		if (!dao.isMemoryAvailable()) {
			System.out.println("연락처를 저장할 공간이 부족합니다.");
			return;
		}
		
		System.out.print("이름 입력> ");
        String name = scanner.nextLine();
        System.out.print("전화번호 입력> ");
        String phone = scanner.nextLine();
        System.out.print("이메일 입력> ");
        String email = scanner.nextLine();
        
        Contact contact = new Contact(0, name, phone, email);
		
        int result = dao.create(contact);
        
        if (result == 1) {
        	System.out.println(">>> 새 연락처 저장 성공");
        } else {
            System.out.println(">>> 새 연락처 저장 실패");
        }
        
		
}

	private int showMainMenu() {
		System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println("[0]종료 [1]새 연락처 [2]전체 목록 [3]검색 [4]수정 [5]삭제");
        System.out.println("------------------------------------------------------------");
        System.out.print("선택> ");
        int n = inputNumber();
        
        return n;
	}

	private int inputNumber() { // 정수만 입력하도록 하는 int를 받는 메서드	
		while (true) {
			try {
				int n = Integer.parseInt(scanner.nextLine()); // String으로 int 받음.
				return n; // int 돌려줌
			} catch (NumberFormatException e) {
				System.out.print("정수 입력 >>> ");	
			}
		}
	}
	
}