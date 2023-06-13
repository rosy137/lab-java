package edu.java.class04;

public class ClassMain04 {

	public static void main(String[] args) {
		Product product01 = new Product();
		product01.printProductInfo();
		System.out.println("===========");
		
		Product product02 = new Product(02, "abc02", 3000);
		product02.printProductInfo();
		System.out.println("===========");
		
		Product product03 = new Product(03, "abc03");
		product03.printProductInfo();
		product03.setProductPrice(4500);
		product03.printProductInfo();
		System.out.println("===========");
		
		Product product04 = new Product(04, "abc04", 1400);
		product04.printProductInfo();
		product04.setProductPrice(1000);
		product04.printProductInfo();
		System.out.println("===========");
		
	}

}
