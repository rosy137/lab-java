package edu.java.record.controller;

import java.util.ArrayList;
import java.util.List;

import edu.java.record.model.Everyday;

public interface EPostDao {

// 전체 저장, 글 수정, 읽기
	/**
	 * 전체 저장
	 * @param day
	 * @return
	 */
	int create(Everyday day);
	
	/**
	 * 
	 * @param core 해당 번호의 정보만 가져올 것ㅂ 
	 * @return 
	 */
	Everyday read(int core);
	
	/**
	 * 수정
	 * @param day
	 * @return
	 */
	int update(Everyday day, int core);
	

}