package edu.java.date;

import java.sql.Timestamp;
// java.lang.String, java.lang.System, ... -> import 문장 생략
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class DateMain {

	public static void main(String[] args) {
		// Java 8 버전에서 새로 추가된 날짜/시간 관련 클래스와 메서드 
		LocalDate now = LocalDate.now(); 
		System.out.println(now); // LocalDate 클래스는 toString() 메서드를 override.
		System.out.println(now.getYear());
		System.out.println(now.getMonth()); // java.time.Month enum 상수를 리턴
		System.out.println(now.getMonthValue()); // 월을 숫자(int)로 리턴
		System.out.println(now.getDayOfMonth());
		System.out.println(now.getDayOfWeek()); // java.time.DayOfWeek enum
		System.out.println(now.plusDays(154)); // 154일
		System.out.println(now.plusWeeks(22)); // 22주
		System.out.println(now.plusMonths(5)); // 5달
		
		LocalDateTime nowTime = LocalDateTime.now();
		System.out.println(nowTime);
		System.out.println(nowTime.getNano());

		LocalDate d = LocalDate.of(2023, Month.AUGUST, 23); // month!!재미땅
		System.out.println(d);
		System.out.println(d.getDayOfWeek());
		
		// Timestamp: 1970-01-01 00:00:00를 기준으로 1/1000초(1 milli-second)마다 
		// 1씩 증가하는 정수를 기반으로 날짜와 시간 정보를 저장하는 클래스.
		// LocalDateTime 객체를 Timestamp 타입 객체로 변환:
		Timestamp ts = Timestamp.valueOf(nowTime);
		System.out.println(ts);
		System.out.println(ts.getTime()); 
		
		// Timestamp 객체를 LocalDateTime 타입 객체로 변환:
		LocalDateTime dt = ts.toLocalDateTime();
		System.out.println(dt);
		
	}

}
