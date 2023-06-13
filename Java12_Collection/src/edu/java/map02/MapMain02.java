package edu.java.map02;

import java.util.Set;
import java.util.TreeMap;

public class MapMain02 {

	public static void main(String[] args) {
		// 문자열을 key로 하고 정수를 value로 하는 TreeMap을 선언, 초기화(객체 생성).
		TreeMap<String, Integer> menu = new TreeMap<>();
		
		menu.put("자장면", 8000); 
		menu.put("볶음밥", 9000);
		menu.put("짬뽕", 9000);
		System.out.println(menu);

		System.out.println(menu.get("자장면")); // 8000
		System.out.println(menu.get("냉면"));
		System.out.println(menu.getOrDefault("냉면",0));
		
		// TreeMap은 정렬 알고리즘이 적용된 map이기 때문에 오름차순/내림차순 키 집합을 제공.
		Set<String> KeySet = menu.keySet();
		for (String k: KeySet) {
			System.out.println(k + ": " + menu.get(k));
		}
		
		Set<String> descKeySet = menu.descendingKeySet();
		for (String k : descKeySet) {
			System.out.println(k + " - " + menu.get(k));
		}
		
	}

}
