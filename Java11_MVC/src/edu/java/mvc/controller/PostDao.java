package edu.java.mvc.controller;

import java.util.List;

import edu.java.mvc.model.Post;

public interface PostDao {
	/**
	 * 새 글 만들기
	 * @param p post 입력
	 * @return 성공 1 실패 0
	 */
	int create(Post p);
	/**
	 * 전체 글 불러오기
	 * @return 배열
	 */
//	Post[]	read();
	List<Post> read();
	/**
	 * 글 불러오기
	 * @param index 인덱스값에 저장된 글 불러옴
	 * @return post 내용 or null
	 */
	Post read(int index);
	/**
	 * 수정
	 * @param index 수정할 인덱스
	 * @param p 수정할 내용
	 * @return 성공1 실패 0
	 */
	int update(int index, Post p);
	/**
	 * 삭제
	 * @param index 삭제할 인덱스
	 * @return 성공1 실패0
	 */
	int delete(int index);
}