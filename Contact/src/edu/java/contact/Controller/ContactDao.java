package edu.java.contact.Controller;

import java.util.ArrayList;
import java.util.List;

import edu.java.contact.model.Contact;

// controller 역할의 interface
// CRUD
public interface ContactDao {
	/**
	 * 연락처 저장 기능
	 * @param contact
	 * @return 저장 성공 1, 실패 0
	 */
	int create(Contact contact);
	
	/**
	 * 연락처 전체 검색
	 * DB contacts 테이블에 저장된 연락처 정보를 검색.
	 * 
	 * @return Contact 타입을 원소로 갖는 List.
	 */
	List<Contact> read();
	
	/**
	 * DB의 contacts 테이블에서 primary key로 연락처 정보를 검색.
	 * 
	 * @param cid 검색할 pk
	 * @return cid 존재하면 contact 타입 리턴, cid 없느면 null 리턴
	 */
	Contact read(int cid);
	
	/**
	 * 주어진 검색어가 이름 또는 전화번호 또는 이메일에 포함된 연락처들의 리스트를 DB에서 검색 후 리턴.
	 * 
	 * @param keyword 검색 키워드 (대소문자 구분 없음)
	 * @return keyword 존재하면 list 리턴, 없으면 null
	 */
	List <Contact> read(String keyword);
	
	/**
	 * pk로 연락처 검색
	 * 
	 * @param contact 저장
	 * @return 업데이트된 행의 개수
	 */
	int update(Contact contact);
	
	/**
	 * pk 에 해당하는 연락처 삭제
	 * @param cid
	 * @return
	 */
	int delete(int cid);
	
}
