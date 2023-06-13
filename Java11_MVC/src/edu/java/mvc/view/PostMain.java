package edu.java.mvc.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import edu.java.mvc.controller.PostDaoImpl;
import edu.java.mvc.menu.Menu;
import edu.java.mvc.model.Post;

public class PostMain {
	
	private final Scanner scanner = new Scanner(System.in);
	private final PostDaoImpl dao = PostDaoImpl.getInstance();
	
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		
		PostMain app = new PostMain();
		
		boolean run = true;
		while(run) {
			int n = app.showMainMenu();
			Menu menu = Menu.getvalue(n);
			switch (menu) {
			case QUIT:
				run = false;
				System.out.println("\n종료");
				break;
			case CREATE:
				app.newPost();
				break;
			case READ_ALL:
				app.postAll();
				break;
			case READ_BY_INDEX:
				app.contactByIndex();
				break;
			case UPDATE:
				app.updateByIndex();
				break;
			case DELETE:
				app.deleteByIndex();
				break;
			default:
				System.out.println("메인 메뉴 확인\n");
			
			}
		}
	}
	
	private void deleteByIndex() {
		System.out.println("삭제할 게시물 찾기");
		System.out.print("인덱스 입력 >>> ");
		int index = inputNumber();
		if(!dao.isindexValid(index)) {
			System.out.println("해당 인덱스 데이터 없음");
			return;
		} 
		int result = dao.delete(index);
		if (result == 0) {
			System.out.println("삭제 실패");
		} else {
			System.out.println("삭제 완료");
		}
		
	}

	private void updateByIndex() {
		System.out.println("수정할 게시물 찾기");
		System.out.print("\n수정할 인덱스 입력 >>> ");
		int index = inputNumber();
		
		Post before = dao.read(index);
		
		if (before != null) {
			System.out.println("수정 전 데이터 확인\n" +before);
		} else {
			System.out.println("해당 인덱스 데이터 없음");
		}
		
		System.out.print("제목 수정 >>> ");
		String title = scanner.nextLine();
		System.out.print("내용 수정 >>> ");
		String content = scanner.nextLine();
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
		String modifiedTime = now.format(format);
		
		Post after = new Post(before.getPid(), title, content, before.getAuthor(), before.getCreatedTime(), modifiedTime);
		
		int result = dao.update(index, after);
		if (result == 1) {
			System.out.println("수정 완료");
		} else {
			System.out.println("수정 실패");
		}
		
	}

	private void contactByIndex() {
		System.out.println("게시물 찾기");
		System.out.print("\n인덱스 입력 >>> ");
		int index = inputNumber();

		Post post = dao.read(index);
		
		if (post != null) {
			System.out.println(post);
		} else {
			System.out.println("해당 인덱스 저장 내용 없음");
		}
		System.out.println("게시물 찾기 끝");
		
	}

	private void postAll() {
		System.out.println("게시물 전체 출력");
		List<Post> posts = dao.read();
		for (Post p : posts) {
			System.out.println(p);
		}
		System.out.println("목록 끝");
	}

	private void newPost() {
		System.out.println("\n새 게시물 저장");
		
		System.out.print("\n제목 입력 >>> ");
		String title = scanner.nextLine();
		System.out.print("\n내용 입력 >>> ");
		String content = scanner.nextLine();
		System.out.print("\n작성자 입력 >>> ");
		String author = scanner.nextLine();
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
		String createdTime = now.format(format);
		String modifiedTime = "";
		
		Post post = new Post(0, title, content, author, createdTime, modifiedTime);
		
		int result = dao.create(post);
		if (result == 1) {
			System.out.println("게시물 저장 완료");
		} else {
			System.out.println("게시물 저장 실패");
		}
		
		
	}

	public int showMainMenu(){
		System.out.println("\n0: 종료 1: 새 게시물 2: 전체 게시물 3: 게시물 찾기 4: 게시물 수정 5: 게시물 삭제");
		System.out.print("\n메뉴 선택 >>> ");
		int n = inputNumber();
		return n;
	}
	
	private int inputNumber() {
		while(true) {
			try {
				int n = Integer.parseInt(scanner.nextLine());
				return n;
			} catch(NumberFormatException e) {
				System.out.println("정수 입력");
			}
		}
	}
	
}