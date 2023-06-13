package edu.java.set04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class MapMain03 {

    public static void main(String[] args) {
        // 단어 개수 세기(word counting):
        // 문자열에 등장하는 단어를 key로 하고, 그 단어의 등자 횟수를 value로 하는 Map을 만들고 출력하세요.
        // 결과> {하늘=3, 땅=2, sky=2}
        String sentence = "하늘 땅 하늘 땅 하늘 sky sky";
        
        String[] words = sentence.split(" ");
        

        // 단어(key)-빈도수(value) 저장하는 Mapt 변수를 선언, 초기화
        HashMap<String, Integer> wordCounts = new HashMap<>();
        
        for (String w : words) { // 배열의 첫번째 원소부터 마지막 원소까지 순서대로 반복
        	Integer count = wordCounts.get(w); // 배열에서 꺼낸 단어 w에 mapping된 값(빈도수)를 찾음.
        	if (count == null) {// 단어에 매칭된 빈도수가 없을 때
        		wordCounts.put(w, 1); // null에는 +1 할 수 없어서 1 넣어줌
        	} else {
        		wordCounts.put(w, count + 1);
        	}
            System.out.println(wordCounts);
//          {하늘=1}
//          {땅=1, 하늘=1}
//          {땅=1, 하늘=2}
//          {땅=2, 하늘=2}
//          {땅=2, 하늘=3}
//          {sky=1, 땅=2, 하늘=3}
//          {sky=2, 땅=2, 하늘=3}
        }
        System.out.println("\n"+ wordCounts);
        
        HashMap<String, Integer> wordCount2 = new HashMap<>();
        for(String w : words) {
        	Integer count = wordCount2.getOrDefault(w, 0); // 맵안에 w 값 찾으면 정수 출력, 없으면 default 0;
        	wordCount2.put(w, count+1);
        }
        System.out.println(wordCount2);
    }

}
