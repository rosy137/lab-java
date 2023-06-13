package edu.java.class08;

public class ClassMain08 {

	public static void main(String[] args) {
		Account acc1 = new Account(1234, 0);
		acc1.printInfo();
		acc1.deposit(1500);
		acc1.printInfo();
		acc1.withdraw(500);
		acc1.printInfo();
		System.out.println("-----------");
		
		Account acc2 = new Account(5678, 3000);
		acc2.printInfo();
		acc2.transfer(acc1, 1500);
		System.out.println("===========");
		
		acc1.printInfo();
		acc2.printInfo();
		

	}

}
