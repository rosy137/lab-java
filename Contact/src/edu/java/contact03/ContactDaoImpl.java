package edu.java.contact03;

import edu.java.contact.model.Contact;

//MVC(Model-View-Controller) 아키텍쳐에서 컨트롤러 구현 클래스.
//singleton 디자인 패턴을 적용.

public class ContactDaoImpl implements ContactDao {
	// 싱글톤으로 만
	private static ContactDaoImpl instance = null;
	private ContactDaoImpl() {};
	public static ContactDaoImpl getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		} 
		return instance;
	}
	// field
	private static final int MAX_LENGTH = 2;
	private Contact[] contacts = new Contact[MAX_LENGTH]; 
	private int count = 0;
	
	// methods
	/**
     * 연락처 배열에 새로운 연락처 객체를 저장할 수 있는 지를 리턴.
     * @return 배열에 빈 공간이 있으면 true, 그렇지 않으면 false.
     */
	public boolean isMemoryAvailable() {
		return count < MAX_LENGTH;
	}

    /**
     * 어떤 인덱스가 검색, 수정, 삭제할 때 사용 가능한 범위 안에 있는 인덱스인 지를 리턴.
     * @param index 유효한 인덱스인 지 검사할 인덱스.
     * @return 사용가능한 인덱스는 true, 그렇지 않으면 false.
     */
    public boolean isValidIndex(int index) {
        return (index >= 0) && (index < count);
    }

    
    // CRUD (Create, Read, Update, Delete)
	@Override
	public int create(Contact c) {
		if (isMemoryAvailable()) {
			contacts[count] = c;
			count++;
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public Contact[] read() {
		Contact[] array = new Contact[count]; //새로운 배열 생성
		for (int i = 0; i < count; i++) {
			array[i] = contacts[i]; //contacts 배열에 있는 것을 array 배열에 채워줌
		}
		return array;
	}

	@Override
	public Contact read(int index) { // 다형성? overloading? >>>Overloading(파라미터 다르고 생성자 같음)
		if (isValidIndex(index)) {
			return contacts[index];
		} else {
			return null;
		}
	}

	@Override
	public int update(int index, Contact contact) {
		if (isValidIndex(index)) {
			contacts[index] = contact;
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int delete(int index) {
		if (!isValidIndex(index)) {
			return 0;
		}
		
		for (int i = index ; i < count - 1 ; i ++) {
			contacts[i] = contacts[i+1];
		} 
		contacts[count - 1] = null;
		count --;
		
		return 1;
	}

}