package edu.java.lambda03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LambdaMain03 {

	public static void main(String[] args) {
		// Employee를 원소로 갖는 리스트를 선언, 초기화
		List<Employee> employees = Arrays.asList(
				new Employee(100, "이찬희", "개발1팀", "대리", 400.0),
				new Employee(101, "지대한", "개발2팀", "사원", 350.0),
				new Employee(200, "김다훈", "개발2팀", "과장", 380.0),
				new Employee(201, "유다한", "개발1팀", "부장", 500.0),
				new Employee(300, "강효남", "인사팀", "사원", 300.0),
				new Employee(301, "위태욱", "인사팀", "과장", 1_000.0)
		);
		
		// 1. 모든 직원들의 정보를 한 줄에 한 명씩 출력.
//		employees.forEach(x -> System.out.println(x));
		employees.forEach(System.out::println); // 메서드 참조
				
		// 2. 개발 1,2팀에서 일하는 직원들의 급여의 합계를 출력
//		List<Employee> oneTwo = employees.stream()
//				.filter(x -> x.getDept().equals("개발1팀") || x.getDept().equals("개발2팀"))
//				.toList();
//		System.out.println("\n개발 1,2팀에서 일하는 직원들");
//		oneTwo.forEach(x -> System.out.println(x));
//				
//		
//		Double oneTwoSum = 0.0;
//		for(Employee e: oneTwo) {
//			oneTwoSum += e.getSalary();
//		}
//		System.out.println("급여의 합계= " +oneTwoSum);
		// Lambda
		double result = employees.stream()
				.filter(x -> x.getDept().contains("개발"))
				.mapToDouble(x -> x.getSalary())
				.sum();
		System.out.println("급여의 합계= " + result);
		
			
		// 3. 개발 1,2팀에서 일하는 직원들의 급여의 평균
//		Double oneTwoAver = oneTwoSum / oneTwo.size();
//		System.out.println("급여의 평균 = " + oneTwoAver);
		// Lambda
		result = employees.stream()
				.filter(x -> x.getDept().contains("개발"))
				.mapToDouble(x -> x.getSalary())
				.average()
				.orElseThrow();
			
		// 4. 직급이 사원인 직원들의 급여의 합계를 출력
		List<Employee> staff = employees.stream()
				.filter(x -> x.getEmpTitle().equals("사원"))
				.toList();
		System.out.println("\n직급이 사원인 직원들");
		staff.forEach(x -> System.out.println(x));
		
		Double staffSum = 0.0;
		for(Employee e: staff) {
			staffSum += e.getSalary();
		}
		System.out.println("급여의 합계 = " + staffSum);
		
		// 5. 직급이 사원인 직원들의 급여의 평균을 출력
		Double staffAver = staffSum / staff.size();
		System.out.println("급여의 평균 = " + staffAver);
		
		// 6. 급여가 400 이상인 직원들의 정보를 한 줄에 한 명씩 출력
		List<Employee> higher = employees.stream()
				.filter(x -> x.getSalary() >= 400.0)
				.toList();
		System.out.println("\n급여가 400 이상인 직원들");
		higher.forEach(x -> System.out.println(x));
		
		// 7. 개발1팀 직원들의 급여를 10% 인상하고, 그 직원들의 급여 평균을 계산하고 출력. 
		List<Employee> teamOne = employees.stream()
				.filter(x -> x.getDept().equals("개발1팀"))
				.toList();
		System.out.println("\n개발1팀 직원들");
		teamOne.forEach(x -> System.out.println(x));
		Double teamOneSum = 0.0;
		for (Employee e : teamOne) {
			e.setSalary(e.getSalary() * 1.1);
			teamOneSum += e.getSalary();
		}
		Double teamOneAver = teamOneSum / teamOne.size();
		System.out.println("급여의 합계 = " + teamOneSum);
		System.out.println("급여의 평균 = " + teamOneAver);
		
		
		// 8. 직원 리스트에서 "사원"은 몇 명?
		System.out.println("\n사원 " + staff.size() + "명");
		
	}

}
