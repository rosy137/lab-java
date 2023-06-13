package edu.java.record.controller;

import java.util.List;

import edu.java.record.model.MonthlyGoal;

public interface MPostDao {

	/**
	 * 새 포스트 저장 기능
	 * @param 객체
	 * @return 저장 성공 1, 실패 0
	 */
	int create(MonthlyGoal mg);
	
	/**
	 * 전체 목록
	 * @return 리스트
	 */
	List<MonthlyGoal> read();
	
	
	/**
	 * 인덱스 삭제 기능
	 * @param int 삭제할 포스트의 키워드...흠.
	 * @return 삭제 성공 1, 실패 0
	 */
	int delete(int mid);
}