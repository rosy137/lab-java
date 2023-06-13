package edu.java.modifier01;

import edu.java.class08.Account; // 다른 패키지의 클래스를 사용할 때 import 문을 사용

// 클래스 멤버(필드, 생성자, 메서드)의 접근 제한 수식어(access modifier):
// 1. private: 선언된 클래스 안에서만 직접 접근(사용) 가능. 
// 2. (package): 수식어가 없는 경우. 같은 패키지에 있는 클래스들에서 직접 접근(사용) 가능.
// 3. protected: 같은 패키지에 있거나 또는 상속하는 클래스들에서 직접 접근(사용) 가능.
// 4. public: 어디서든 직접 접근(사용) 가능.
// 가시성(visibility) 범위: private < (package) < protected < public


public class ModifierMain01 {

	public static void main(String[] args) {
		// 다른 패키지에 있는 클래스 타입은 import 문장 있어야 사용 가능
		Account acc = new Account(111, 10000); 
		acc.printInfo(); // < public으로 공개된 메서드는 어디서든지 사용 가능.
//		acc.< 이후 나오지 않는 옵션은 사용 불가
//		acc.balance << not visible! 수식어가 없는 경우 다른 패키지에서는 보이지 않음. (없는 것x 보이지 않는 것o)

		
		// 같은 패키지에 있는 클래스 타입은 import 문장 없이 사용 가능
		AccessTest test = new AccessTest(3, 4, 3, 3);
		test.printInfo();
		System.out.println("----------");
//		System.out.println(test.a); // not visible!: private
		System.out.println(test.b); // 수식어가 없는 경우 같은 패키지 범위에서는 보임.
		System.out.println(test.c);
		System.out.println(test.d);
		System.out.println("----------");
//		test.a = 100; // not visible!: private
		test.b = 100;
		test.printInfo();
		
		// 생성자를 private으로 선언하면 다른 클래스에서는 생성자를 호출할 수 없기 때문에 객체를 생성할 수 없듬.
//		new Math(); // 생성자 호출 > not visible!: JDK java.lang.Math 클래스의 생성자는 private-> 객체 생성 불가능
	}

}
