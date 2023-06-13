package edu.java.record.controller;

import java.util.ArrayList;
import java.util.List;

import edu.java.record.model.Culture;
import edu.java.record.model.Everyday;

public interface CPostDao {

// 전체 저장, 글 수정, 읽기
	/**
	 * 전체 저장
	 * @param day
	 * @return
	 */
	int create(Culture cul);
	
	/**
	 * 
	 * @param core 해당 번호의 정보만 가져올 것ㅂ 
	 * @return 
	 */
	Culture read(int core);
	
	/**
	 * 수정
	 * @param day
	 * @return
	 */
	int update(Culture cal, int core);
	

}