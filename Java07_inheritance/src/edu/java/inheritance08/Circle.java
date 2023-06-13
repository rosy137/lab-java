package edu.java.inheritance08;

public class Circle extends Shape {
    // field
    private double radius; // 원의 반지름
    
    public Circle(String type, double radius) {
    	super(type);
    	this.radius = radius;
    }

	@Override
	public double area() {
		return radius * radius *  Math.PI;
	}

	@Override
	public double perimeter() {
		return radius * 2 * Math.PI ;
	}

}