package edu.java.list03;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListMain03 {
	public static void main(String[]args) {
		// 문자열들을 원소로 갖는 리스트 생성과 동시에 초기화.
		// Arrays.asList(...) - 아규먼트로 전달된 값들을 원소로 갖는 리스트 객체를 생성.
		List<String> subjects = Arrays.asList("Java","SQL","HTML","CSS","Javascript","Servlet", "JSP","Spring","Python");
		System.out.println(subjects);
		
		// 리스트  subject에서 5글자 이상인 문자열들만 저장하는 리스트를 만들고 출력.
		// ArrayList<String> list = new ArrayList<>();
		// SuperType var = new SubType();
		List<String> overFives = new LinkedList<>();
//		for (String s : subjects) {
//			if (s.length() >= 5) {
//				overFives.add(s);
//			}
//		}
		
//		for (int i = 0; i<subjects.size(); i++) {
//			String word = subjects.get(i);
//			if (word.length() >= 5) {
//				overFives.add(word);
//			}
//		}
		
		Iterator<String> itr = subjects.iterator();
		while(itr.hasNext()) {
			String s = itr.next();
			if (s.length() >= 5) {
				overFives.add(s);
			}
		}
		
		System.out.println(overFives);
				
		// 리스트 subject의 원소들의 글자수를 저장하는 리스트를 만들고 출력.
		List<Integer> numbers = new LinkedList<>();
		for (String s : subjects) {
			numbers.add(s.length());
		}
		System.out.println(numbers);
		
		// 정수(0, 1)을 저장하는 리스트 생성.
		List<Integer> codes = Arrays.asList(0,1,0,0,1,1);
		// 리스트의 codes의 원소가 0이면 "Male" 1이면 "Female"을 원소로 갖는 리스트를 만들고 출력.
		List<String> mafema = new LinkedList<>();
		for(int i : codes) {
			mafema.add((i == 0)? "Male" : "Female");
		}
		System.out.println(mafema);
	}
}
