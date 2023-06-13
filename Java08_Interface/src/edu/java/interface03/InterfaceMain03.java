package edu.java.interface03;

// 자바는 다중 상속을 제공하지 않음. 2개 이상의 클래스를 상속할 수 없음.
class A {}
class B {}
class C extends A {}
// class D extends A, B {} // 문법 오류

// class에서 구현하는 인터페이스의 개수는 제한이 없음.
interface E {}
interface F {}
class G implements E, F {} // 2개 인터페이스를 구현하는 클래스
class H extends A implements E,F {} // 1개의 클래스를 상속하고 2개 인터페이스를 구현하는 클래스

// 인터페이스는 다른 인터페이스를 확정(상속)할 수 있음.
// 자바에서 클래스는 단일 상속만 가능하지만, 인터페이스는 다중 상속이 가능!
interface I extends E, F {}

// 인터페이스는 클래스를 확장(상속)할 수 없음.
//interface J extends A {} //-> 상위 인터페이스는 인터페이스만 가능.
//-> The type A cannot be a superinterface of J; a superinterface must be an interface


interface Buyer {
	static void test() {} // static 메서드, 동일한 이름의 statis 메서드가 있더라도 interface가 다르기 때문에 상관없음
	void buy(); // public, abstract method
	default void register() { // default (인스턴스) method
		System.out.println("구매자 등록");
	}
}

interface Seller {
	static void test() {}
	void sell(); //public abstract method
	
	default void register() { // default (인스턴스) method
		System.out.println("판매자 등록");
	}
}

class User implements Buyer, Seller { 
	// Duplicate default methods named >>register<< with the parameters () and () are inherited from the types seller and Buyer
	// 중복되는 디폴트 메서드가 2개의 인터페이스에 있는 경우에는 반드시 override
	@Override
	public void register() {
		// 상위인터페이스.super.메서드() 호출 // 바이어 타입에 있는 메서드만 출력하겠다는 뜻
		Buyer.super.register(); // Buyer 인터페이스의 default 메서드가 호출됨.
		Seller.super.register(); // Seller 인터페이스의 default 메서드가 호출됨.
	}
	
	@Override // Buyer 인터페이스의 추상 메서드를 구현.
	public void buy() {
		System.out.println("구매");
	}

	@Override // Seller 인터페이스의 추상 메서드를 구현
	public void sell() {
		System.out.println("판매");
		
	}
}

public class InterfaceMain03 {

	public static void main(String[] args) {
		User user1 = new User();
		user1.register();
		// 구매자 등록
		// 판매자 등록
		user1.buy();
		// 구매
		user1.sell();
		// 판매
		
	}
	

}
