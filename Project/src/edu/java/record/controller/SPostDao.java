package edu.java.record.controller;

import java.util.ArrayList;
import java.util.List;

import edu.java.record.model.Culture;
import edu.java.record.model.Everyday;

public interface SPostDao {

	
	/**
	 * 
	 * @param core 해당 키워드의 정보만 가져올 것ㅂ 
	 * @return 
	 */
	List<Everyday> readE(String keyword);
	

	/**
	 * 상동
	 * @param keyworkd
	 * @return
	 */
	List<Culture> readC(String keyword);

}